package Model;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> openCards;//Hold all the cards in table
    private int totalMoneyInTheTable;//The number of money in this round

    public Deck() {
        openCards = new ArrayList<Card>(5);
    } //5 card to play the round

    public int GetTotalMoneyInTable() {
        return this.totalMoneyInTheTable;
    }

    void SetTotalMoneyInTable(int money) {
        this.totalMoneyInTheTable = money;
    }

    public ArrayList<Card> getOpenCards() {
        return openCards;
    }
}
