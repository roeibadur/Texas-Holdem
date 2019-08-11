package Model;

//***************************Test Logic************************************//
//Player Bot reacts to the game based on last move and His Hand            //
//All the action verified by creating specific scenarios                   //
//                                                                         //
//**********************End Test Logic Description*************************//

import Model.Action.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BotPlayerTest {
    BotPlayer bot;
    CallAction call;
    FoldAction fold;
    RaiseAction raise;
    CheckAction check;
    AllInAction Allin;
    IAction PreavoiusAction;


    @Before
    public void setUp() throws Exception
    {
        bot = new BotPlayer(1000, "Computer");
        call = new CallAction();
        fold = new FoldAction();
        raise = new RaiseAction(10);
        check = new CheckAction();
        Allin = new AllInAction();
        PreavoiusAction = new RaiseAction(10);
    }

    @Test
    public void evaluateBet()
    {

        int curaise=5;
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.DIAMONDS));
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.HEARTS));
        assertEquals(call.GetName() ,bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        bot.getMyHand().getCardsInHand().add(new Card(11,CardType.SPADES));
        bot.getMyHand().getCardsInHand().add(new Card(10,CardType.HEARTS));
        bot.getMyHand().getCardsInHand().add(new Card(12,CardType.DIAMONDS));
        PreavoiusAction.SetRaise(500);
        assertEquals(fold.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        PreavoiusAction.SetRaise(20);
        assertEquals(call.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        PreavoiusAction.SetName("Check");
        PreavoiusAction.SetRaise(0);
        assertEquals(raise.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        assertEquals(check.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.DIAMONDS));
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.HEARTS));
        assertEquals(raise.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.SPADES));
        bot.getMyHand().getCardsInHand().add(new Card(10,CardType.HEARTS));
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.CLUBS));
        assertEquals(Allin.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        PreavoiusAction.SetRaise(1500);
        PreavoiusAction.SetName("Raise");
        assertEquals(Allin.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        PreavoiusAction.SetRaise(700);
        PreavoiusAction.SetName("Raise");
        assertEquals(call.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().remove(0);
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.HEARTS));
        bot.getMyHand().getCardsInHand().add(new Card(8,CardType.DIAMONDS));
        bot.getMyHand().getCardsInHand().add(new Card(10,CardType.HEARTS));
        bot.getMyHand().getCardsInHand().add(new Card(10,CardType.DIAMONDS));
        assertEquals(call.GetName(),bot.EvaluateBet(PreavoiusAction,curaise).GetName());
    }
}