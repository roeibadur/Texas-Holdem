package Model;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class CardTest
{
    Card card;
    @Before
    public void setUp() throws Exception
    {
        card=new Card(8,CardType.DIAMONDS);

    }
    @Test
    public void setnumber()
    {
        card.setnumber(9);
        assertEquals(9,card.getnumber());
    }

    @Test
    public void getnumber()
    {
        assertEquals(8,card.getnumber());
    }

    @Test
    public void getType()
    {
        assertEquals(CardType.DIAMONDS,card.getType());
    }

    @Test
    public void setType()
    {
        card.SetType(CardType.HEARTS);
        assertEquals(CardType.HEARTS,card.getType());
    }

    @Test
    public void setAvillable()
    {
        card.setAvailable(true);
        assertEquals(true,card.IsAvillable());
    }

    @Test
    public void isAvillable()
    {
        assertEquals(false,card.IsAvillable());
    }
}