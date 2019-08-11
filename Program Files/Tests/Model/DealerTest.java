package Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DealerTest {

    Dealer dealer;
    Player Playerone;
    BotPlayer Computer;
    Deck deck;
    @Before
    public void setUp() throws Exception
    {
        dealer=new Dealer();
        Playerone= new Player(1000,"nir");
        Computer= new BotPlayer(1000,"Computer");
        deck=new Deck();

    }
    @Test
    public void createPackOfCards()
    {
        assertEquals(52,dealer.GetPackOfCards().size());

    }
    @Test
    public void DistributionOfCards()
    {
        dealer.AddPlayer(Playerone);
        dealer.AddPlayer(Computer);
        dealer.DistributionOfCards(deck);
        dealer.CreatePackOfCards();
        assertEquals(2,Playerone.getMyHand().getCardsInHand().size());
        assertEquals(2,Computer.getMyHand().getCardsInHand().size());
        assertEquals(5,deck.getOpenCards().size());
    }

    @Test
    public void collectingCards()
    {
        dealer.CreatePackOfCards();
        dealer.DistributionOfCards(deck);
        dealer.AddPlayer(Playerone);
        dealer.AddPlayer(Computer);
        dealer.CollectingCards(deck);
        assertEquals(0,Playerone.getMyHand().getCardsInHand().size());
        assertEquals(0,Computer.getMyHand().getCardsInHand().size());
        assertEquals(0,deck.getOpenCards().size());
    }

    @Test
    public void revealedCards()
    {
        dealer.AddPlayer(Playerone);
        dealer.AddPlayer(Computer);
        dealer.DistributionOfCards(deck);
        dealer.RevealedCards(deck,1);
        assertTrue(deck.getOpenCards().get(0).IsAvillable());
        assertTrue(deck.getOpenCards().get(1).IsAvillable());
        assertTrue(deck.getOpenCards().get(2).IsAvillable());
        dealer.RevealedCards(deck,2);
        assertTrue(deck.getOpenCards().get(3).IsAvillable());
        dealer.RevealedCards(deck,3);
        assertTrue(deck.getOpenCards().get(4).IsAvillable());
    }
    @Test
    public void addPlayer()
    {
        dealer.AddPlayer(Playerone);
        dealer.AddPlayer(Computer);
        assertEquals(2,dealer.GetPlayers().size());
    }
}