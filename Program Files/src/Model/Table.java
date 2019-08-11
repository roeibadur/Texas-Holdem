package Model;
import Model.Action.Action;
import Model.Action.IAction;
import java.util.Observable;
//*******************************************************************//
//Table class holds all the relevant Data for the current Game,      //
// implements all the Table Logic                                    //
//used for interaction with the Table View, extends Observable class.//
//*******************************************************************//
public class Table extends Observable {

    private int smallBlind;
    private int bigBlind;
    private Dealer dealer;
    private Player p1;
    private BotPlayer bot;
    private Deck deck;
    private Action previousAction;
    private TableData obsrever;
    private int round = 0;
    private int blindTurn = 1;
    private Boolean isNewGame = true;
    private int howMuchBlinds = 0;
    boolean firstturn = false;
    private HandEvaluator HandEvaluator;
    private ModelSetting model;
    // Create new table
    public Table(String name, int InitMoney, int SmallBlinds, ModelSetting model)
    {
        p1 = new Player(InitMoney, name);//Allocates new player
        bot = new BotPlayer(InitMoney, "BoT");//Allocates new playerBot
        deck = new Deck();//Allocates new deck
        dealer = new Dealer();//Allocates new dealer
        //Initialize the blinds
        this.smallBlind = SmallBlinds;
        this.bigBlind = this.smallBlind * 2;
        dealer.AddPlayer(p1); //Add player to table
        dealer.AddPlayer(bot);//Add playerBot to table
        p1.setMoney(p1.GetMoney() - this.smallBlind); //Manage who is the small/big clind
        bot.setMoney(bot.GetMoney() - this.bigBlind);
        obsrever = new TableData(p1, bot, deck, smallBlind, bigBlind, this);
        previousAction = new Action();
        previousAction.SetName("Raise");
        previousAction.SetRaise(bigBlind);
        this.model = model;
        HandEvaluator = new HandEvaluator();
    }
    //restart game after every round
    public void StartGame()
    {
        if (isNewGame) //Update the game in the first time
            model.Update();

        if(p1.GetMoney()<bigBlind) //P1 don't have enough money
            obsrever.setWinner("Computer Won The Match");
        else if(bot.GetMoney()<bigBlind) //bot dont have enough money
            obsrever.setWinner("Congratulations, You Won the Match");
        else obsrever.setWinner("no winner");
        obsrever.setError("no error");
        howMuchBlinds++;
        if (howMuchBlinds % 3 == 0) //Every 3 round the blind doubled
        {
            smallBlind = smallBlind * 2;
            bigBlind = bigBlind * 2;
        }
        obsrever.Setsmallblind(smallBlind);
        round = 0;
        dealer.DistributionOfCards(deck);
        previousAction.SetName("Raise");
        previousAction.SetRaise(bigBlind);
        if (blindTurn == 1) //Manage the blinds turn
        {//player1 is the small blind
            obsrever.setBotRaise(bigBlind);
            obsrever.setPlayerRaise(smallBlind);
            p1.setMoney(p1.GetMoney() - smallBlind);
            bot.setMoney(bot.GetMoney() - bigBlind);
            blindTurn = 0;
            obsrever.SetComputermove("");
            obsrever.Update(p1, bot, deck);
        }
        else
        {//bot is the small blind
            obsrever.setBotRaise(smallBlind);
            obsrever.setPlayerRaise(bigBlind);
            p1.setMoney(p1.GetMoney() - bigBlind);
            bot.setMoney(bot.GetMoney() - smallBlind);
            blindTurn = 1;
            obsrever.Update(p1, bot, deck);
            firstturn = true;
            ComputerTurn();

        }
    }
    //Get the action pf the player and validate if the action is correct-do it, else- Error message
    public void PlayerTurn(String ActionName, String Raise)
    {
        obsrever.error="no error";
        int curraise = Integer.parseInt(Raise);
        switch (ActionName)
        {
            case "Check":
                        if (previousAction.GetName().equals("Check"))
                                NextRound();
                        else if (previousAction.GetName().equals("no action") && previousAction.GetRaise() == 0)
                        {
                                previousAction.SetName("Check");
                                ComputerTurn();
                        }
                        else {
                            obsrever.setError("Can't push this button");
                            obsrever.Update(p1, bot, deck);
                        }
                        break;
            case "Fold":
                        bot.setMoney(bot.GetMoney() + deck.GetTotalMoneyInTable() + previousAction.GetRaise() + obsrever.getPlayerRaise());
                        deck.SetTotalMoneyInTable(0);
                        dealer.CollectingCards(deck);
                        StartGame();
                        break;
            case "Call":
                        if (previousAction.GetName().equals("Raise") || previousAction.GetName().equals("AllIN"))
                        {
                            if (p1.GetMoney() >= previousAction.GetRaise())
                            {
                                deck.SetTotalMoneyInTable(deck.GetTotalMoneyInTable() + (previousAction.GetRaise() * 2));
                                p1.setMoney(p1.GetMoney() - previousAction.GetRaise());
                            }
                            else
                            {
                                bot.setMoney(bot.GetMoney() + (previousAction.GetRaise() - p1.GetMoney() + obsrever.getPlayerRaise()));
                                deck.SetTotalMoneyInTable(deck.GetTotalMoneyInTable() + (p1.GetMoney() + obsrever.getPlayerRaise()) * 2);
                                p1.setMoney(0);
                            }
                            NextRound();
                        }
                        else {
                            obsrever.setError("Can't push this button");
                            obsrever.Update(p1, bot, deck);
                        }
                        break;
            case "AllIN":
                        if (p1.GetMoney() > dealer.GetMaxBet())
                        {
                            previousAction.SetRaise(dealer.GetMaxBet());
                            previousAction.SetName("AllIN");
                            obsrever.setPlayerRaise(dealer.GetMaxBet());
                            p1.setMoney(p1.GetMoney() - dealer.GetMaxBet());

                        }
                        else
                        {
                            previousAction.SetRaise(p1.GetMoney());
                            previousAction.SetName("AllIN");
                            obsrever.setPlayerRaise(p1.GetMoney());
                            p1.setMoney(0);
                        }
                        ComputerTurn();
                        break;
            case "Raise":
                        if (p1.GetMoney() < curraise)
                        {
                            obsrever.setError("You dont have enough money");
                            obsrever.Update(p1, bot, deck);
                        }
                        else if ((previousAction.GetName().equals("Raise") || previousAction.GetName().equals("AllIN")) && (curraise + obsrever.getPlayerRaise() < previousAction.GetRaise()) || (curraise + obsrever.getPlayerRaise()) == previousAction.GetRaise())
                        {

                            obsrever.setError("You Can't Raise Less Then Computer Raise");
                            obsrever.Update(p1, bot, deck);
                        }
                        else if (curraise > 0)
                        {
                            previousAction.SetRaise(curraise + obsrever.getPlayerRaise());
                            previousAction.SetName("Raise");
                            p1.setMoney(p1.GetMoney() - curraise);
                            obsrever.setPlayerRaise(obsrever.getPlayerRaise() + curraise);
                            obsrever.Update(p1, bot, deck);
                            ComputerTurn();
                        }
                        break;
            }

        }

    public TableData GetTableData() { return obsrever; }

    public void ComputerTurn() //Evaluate the next computer move after he get the prev avtion the play does
    {
        IAction action = bot.EvaluateBet(previousAction, obsrever.getBotRaise());
        switch (action.GetName())
        {
            case "Check":
                        obsrever.SetComputermove("Computer Check");
                        if (previousAction.GetName().equals("no action"))
                        {
                            previousAction.SetName("Check");
                            previousAction.SetRaise(0);
                        }
                        else NextRound();
                        break;
            case "Fold":
                        obsrever.SetComputermove("Computer Fold");
                        p1.setMoney(p1.GetMoney() + deck.GetTotalMoneyInTable() + obsrever.getBotRaise() + obsrever.getPlayerRaise());
                        deck.SetTotalMoneyInTable(0);
                        dealer.CollectingCards(deck);
                        StartGame();
                        break;
            case "Call":
                        obsrever.SetComputermove("Computer Call");
                        if (firstturn)
                        {
                            bot.setMoney(bot.GetMoney() + obsrever.getBotRaise() - previousAction.GetRaise());
                            obsrever.setBotRaise(previousAction.GetRaise());
                            previousAction.SetName("Check");
                            previousAction.SetRaise(0);
                            firstturn = false;
                            obsrever.Update(p1, bot, deck);
                        }
                        else
                        {
                            bot.setMoney(bot.GetMoney() - (previousAction.GetRaise() - obsrever.getBotRaise()));
                            NextRound();
                        }
                        break;
            case "AllIN":
                        obsrever.SetComputermove("Computer AllIN");
                        if (bot.GetMoney() + obsrever.getBotRaise() < dealer.GetMaxBet())
                        {
                            previousAction.SetRaise(bot.GetMoney() + obsrever.getBotRaise());
                            previousAction.SetName("AllIN");
                            obsrever.setBotRaise(bot.GetMoney() + obsrever.getBotRaise());
                            bot.setMoney(0);
                        }
                        else
                        {
                            previousAction.SetName("AllIN");
                            previousAction.SetRaise(dealer.GetMaxBet());
                            bot.setMoney(bot.GetMoney() - (dealer.GetMaxBet() - obsrever.getBotRaise()));
                            obsrever.setBotRaise(dealer.GetMaxBet());
                        }
                        obsrever.Update(p1, bot, deck);
                        break;
            case "Raise":
                        obsrever.SetComputermove("Computer Raise :"+Integer.toString(action.GetRaise()));
                        previousAction.SetName("Raise");
                        previousAction.SetRaise(action.GetRaise());
                        bot.setMoney(bot.GetMoney() - (action.GetRaise() - obsrever.getBotRaise()));
                        obsrever.setBotRaise(previousAction.GetRaise());
                        obsrever.Update(p1, bot, deck);
                        break;
        }


    }

    public void NextRound() //manage the turn and check if the turn not done, continue the tun, else wh check who winner
    {
        deck.SetTotalMoneyInTable(deck.GetTotalMoneyInTable() + (previousAction.GetRaise() * 2));
        round++;
        if (round == 4) //End the round
            CheckWinner();
        else //The round continue
        {
            dealer.RevealedCards(deck, round);
            obsrever.setBotRaise(0);
            obsrever.setPlayerRaise(0);
            previousAction.SetName("no action");
            previousAction.SetRaise(0);
            //obsrever.SetComputermove("");
            obsrever.Update(p1, bot, deck);
            if (blindTurn == 1)
                    ComputerTurn();
        }
    }

    public boolean GetIsNewGame() { return isNewGame; }

    public void SetIsNewGame(Boolean b) { isNewGame = b; }

    public void ComputerWin()
    {
        obsrever.setWinner("Computer Won The Round");
        obsrever.Update(p1,bot,deck);
        bot.setMoney(bot.GetMoney() + deck.GetTotalMoneyInTable());
        deck.SetTotalMoneyInTable(0);
        dealer.CollectingCards(deck);
        StartGame();
    }

    public void PlayerWin()
    {
        obsrever.setWinner("Player Won The Round");
        obsrever.Update(p1,bot,deck);
        p1.setMoney(p1.GetMoney() + deck.GetTotalMoneyInTable());
        deck.SetTotalMoneyInTable(0);
        dealer.CollectingCards(deck);
        StartGame();
    }

    public void CheckWinner()
    {
        String Winner=HandEvaluator.CheckWinner(p1.getMyHand().getCardsInHand(),bot.getMyHand().getCardsInHand());
        if(Winner.equals("Player"))
            PlayerWin();
        else if(Winner.equals("Computer"))
            ComputerWin();
        else
        {
            obsrever.setWinner("The Round Ended With Draw");
            obsrever.Update(p1,bot,deck);
            p1.setMoney(p1.GetMoney()+(deck.GetTotalMoneyInTable()/2));
            bot.setMoney(bot.GetMoney()+(deck.GetTotalMoneyInTable()/2));
            deck.SetTotalMoneyInTable(0);
            dealer.CollectingCards(deck);
            StartGame();
        }
    }
}


