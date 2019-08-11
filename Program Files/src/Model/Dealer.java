package Model;

import java.util.ArrayList;
import java.util.Collections;
//*******************************************************************//
//Dealer class is in charge of card distribution,                    //
// to the players and to the card package,                           //
// reveling cards on the deck and shuffling the cards every turn     //
//*******************************************************************//
public class Dealer {

    private ArrayList<Card> packOfCards; //Hold all the 52 cards
    private ArrayList<Player> players; //hold all the players that played
    private HandEvaluator cardValidator;

    public Dealer() { //The Dealer manage the turn
        packOfCards = new ArrayList<Card>(52); //Allocates pack of card
        players = new ArrayList<Player>();//Allocates list to players cards
        CreatePackOfCards();
        shuffleDeck(); //Shaffel the cards
        cardValidator = new HandEvaluator();
    }

    //Create package of 52 cards
    public void CreatePackOfCards() {
        for (int i = 1; i < 14; i++)
            for (CardType type : CardType.values())
                packOfCards.add(new Card(i, type));
    }

    //Shuffle the cards in the arraylist
    public void shuffleDeck() {
        Collections.shuffle(packOfCards);
    }

    //Distribution the card between players and table
    public void DistributionOfCards(Deck d1) {
        for (Player p1 : players) {
            p1.getMyHand().getCardsInHand().add(packOfCards.remove(0));
            p1.getMyHand().getCardsInHand().add(packOfCards.remove(0));
            if (players.get(0) == p1) {
                p1.getMyHand().getCardsInHand().get(0).setAvailable(true);
                p1.getMyHand().getCardsInHand().get(1).setAvailable(true);
            }
        }
        for (int i = 0; i < 5; i++)
            d1.getOpenCards().add(packOfCards.remove(0));
    }

    //Collecting all the cards back to package
    public void CollectingCards(Deck d1) {
        for (Player p1 : players) {
            while (p1.getMyHand().getCardsInHand().size() > 0) {
                p1.getMyHand().getCardsInHand().get(0).setAvailable(false);
                packOfCards.add(p1.getMyHand().getCardsInHand().remove(0));
            }

        }
        for (int i = 0; i < 5; i++) {
            d1.getOpenCards().get(0).setAvailable(false);
            packOfCards.add(d1.getOpenCards().remove(0));
        }
        shuffleDeck();
    }

    //Check which cards need to revealed
    public void RevealedCards(Deck d1, int round) {
        if (round == 1)
            for (int i = 0; i < 3; i++) { // we need to poen 3 cards
                d1.getOpenCards().get(i).setAvailable(true);
                players.get(0).getMyHand().getCardsInHand().add(d1.getOpenCards().get(i));
                players.get(1).getMyHand().getCardsInHand().add(d1.getOpenCards().get(i));
            }
        if (round == 2) {  //we need to poen 1 card
            d1.getOpenCards().get(3).setAvailable(true);
            players.get(0).getMyHand().getCardsInHand().add(d1.getOpenCards().get(3));
            players.get(1).getMyHand().getCardsInHand().add(d1.getOpenCards().get(3));
        }
        if (round == 3) { //we need to poen 1 card
            d1.getOpenCards().get(4).setAvailable(true);
            players.get(0).getMyHand().getCardsInHand().add(d1.getOpenCards().get(4));
            players.get(1).getMyHand().getCardsInHand().add(d1.getOpenCards().get(4));
        }

    }

    //Return the max raise that players can do
    public int GetMaxBet() {
        int min = players.get(0).GetMoney();
        for (Player p1 : players) {
            if (min > p1.GetMoney())
                min = p1.GetMoney();
        }
        return min;
    }

    public void AddPlayer(Player p1) {
        players.add(p1);
    }

    public ArrayList<Card> GetPackOfCards() {
        return this.packOfCards;
    }

    public ArrayList<Player> GetPlayers() {
        return this.players;
    }
}
