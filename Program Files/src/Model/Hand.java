package Model;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cardsInHand;//Hold all the cards of player

    public Hand() {

        cardsInHand = new ArrayList<Card>();
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }
}
