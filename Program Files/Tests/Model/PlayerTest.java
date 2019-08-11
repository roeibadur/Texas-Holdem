package Model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest{
    Player player;

    @Before
    public void setUp() throws Exception
    {
        player=new Player(1000,"Roei");
    }

    @Test
    public void getMoney()
    {
        assertEquals(1000,player.GetMoney());
    }

    @Test
    public void GetName()
    {
        assertEquals("Roei",player.GetName());
    }

    @Test
    public void setMoney()
    {
        player.setMoney(900);
        assertEquals(900,player.GetMoney());
    }

    @Test
    public void getMyHand()
    {
        player.getMyHand().getCardsInHand().add(new Card(8,CardType.DIAMONDS));
        assertEquals(1,player.getMyHand().getCardsInHand().size());
    }
}