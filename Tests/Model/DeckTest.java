package Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest
{
    Deck deck;
    @Before
    public void setUp() throws Exception
    {
        deck=new Deck();

    }
    @Test
    public void getTotalMoneyInTable()
    {
        assertEquals(0,deck.GetTotalMoneyInTable());
    }

    @Test
    public void setTotalMoneyInTable()
    {
        deck.SetTotalMoneyInTable(10);
        assertEquals(10,deck.GetTotalMoneyInTable());
    }

    @Test
    public void getOpenCards()
    {
        deck.getOpenCards().add(new Card(8,CardType.DIAMONDS));
        deck.getOpenCards().add(new Card(9,CardType.DIAMONDS));
        assertEquals(2,deck.getOpenCards().size());
    }
}