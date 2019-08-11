package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

//***************************Test Logic************************************//
//Hand must have 2/5/6/7 Card in every step of the Game                    //
//each Hand Evaluation will take always the strong combination             //
//Each Check Level evaluation of the Hand will return Integer              //
//Value That represents The Hand strength.                                 //
//CheckWinner, Will Evaluate Tow Hands And return String                   //
//that represents the Winner (Strongest Hand) from the given Hands         //
//**********************End Test Logic Description*************************//

public class HandEvaluatorTest {
    HandEvaluator handEvaluator;
    ArrayList<Card> HandStright;
    ArrayList<Card> ThreeOfkind;
    ArrayList<Card> Onepair;
    ArrayList<Card> Flush;
    ArrayList<Card> TowPairs;
    ArrayList<Card> FullHouse;

    @Before
    public void setUp() {
        handEvaluator = new HandEvaluator();
        HandStright = new ArrayList<Card>();
        ThreeOfkind = new ArrayList<Card>();
        Onepair =  new ArrayList<Card>();
        Flush =  new ArrayList<Card>();
        TowPairs=  new ArrayList<Card>();
        FullHouse=  new ArrayList<Card>();
        Card firstCard = new Card( 3,CardType.CLUBS);
        Card SecondCard = new Card(3,CardType.DIAMONDS);
        Card ThirdCard =new Card(4,CardType.DIAMONDS);
        Card FourthCard =new Card(4,CardType.CLUBS);
        Card FifthCard =new Card(6,CardType.DIAMONDS);
        Card SixthCard =new Card(7,CardType.DIAMONDS);
        Card seventhCard =new Card(8,CardType.DIAMONDS);
        Card EighthCard =new Card(3,CardType.HEARTS);
        Card ninth =new Card(5,CardType.CLUBS);
        Onepair.add(firstCard);
        Onepair.add(SecondCard);

        TowPairs.add(firstCard);
        TowPairs.add(SecondCard);
        TowPairs.add(ThirdCard);
        TowPairs.add(FourthCard);
        TowPairs.add(seventhCard);

        Flush.add(SecondCard);
        Flush.add(ThirdCard);
        Flush.add(FifthCard);
        Flush.add(SixthCard);
        Flush.add(seventhCard);

        ThreeOfkind.add(firstCard);
        ThreeOfkind.add(SecondCard);
        ThreeOfkind.add(EighthCard);
        ThreeOfkind.add(ThirdCard);
        ThreeOfkind.add(SixthCard);

        FullHouse.add(firstCard);
        FullHouse.add(SecondCard);
        FullHouse.add(EighthCard);
        FullHouse.add(ThirdCard);
        FullHouse.add(FourthCard);

        HandStright.add(firstCard);
        HandStright.add(ThirdCard);
        HandStright.add(ninth);
        HandStright.add(FifthCard);
        HandStright.add(SixthCard);
        HandStright.add(seventhCard);
        HandStright.add(EighthCard);
    }



    @Test
    public void EvaluateHand() {
        assertEquals("three-of-kind", handEvaluator.EvaluateHand(ThreeOfkind));
        assertEquals("one-pair", handEvaluator.EvaluateHand(Onepair));
        assertEquals("two-pairs", handEvaluator.EvaluateHand(TowPairs));
        assertEquals("flush", handEvaluator.EvaluateHand(Flush));
        assertEquals("straight", handEvaluator.EvaluateHand(HandStright));


    }
    @Test
    public void checkWinner()
    {
        assertEquals("Player", handEvaluator.CheckWinner(TowPairs,Onepair));
        assertEquals("Player", handEvaluator.CheckWinner(ThreeOfkind,TowPairs));
        assertEquals("Player", handEvaluator.CheckWinner(FullHouse,ThreeOfkind));
        assertEquals("Player", handEvaluator.CheckWinner(FullHouse,Flush));
        assertEquals("Player", handEvaluator.CheckWinner(Flush,HandStright));

        assertEquals("Even", handEvaluator.CheckWinner(ThreeOfkind,ThreeOfkind));
        assertEquals("Even", handEvaluator.CheckWinner(HandStright,HandStright));

        assertEquals("Computer", handEvaluator.CheckWinner(Onepair,TowPairs));
        assertEquals("Computer", handEvaluator.CheckWinner(TowPairs,ThreeOfkind));
        assertEquals("Computer", handEvaluator.CheckWinner(ThreeOfkind,FullHouse));
        assertEquals("Computer", handEvaluator.CheckWinner(Flush,FullHouse));

    }
}