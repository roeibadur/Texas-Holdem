package Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//***************************Test Logic************************************//
//                 //
//each Hand Evaluation will take always the strong combination             //
//Each Check Level evaluation of the Hand will return Integer              //
//Value That represents The Hand strength.                                 //
//CheckWinner, Will Evaluate Tow Hands And return String                   //
//that represents the Winner (Strongest Hand) from the given Hands         //
//**********************End Test Logic Description*************************//

public class HandTest {
    Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();

    }

    @Test
    public void getCardsInHand() {
        hand.getCardsInHand().add(new Card(8, CardType.DIAMONDS));
        hand.getCardsInHand().add(new Card(9, CardType.DIAMONDS));
        assertEquals(2, hand.getCardsInHand().size());
    }
}