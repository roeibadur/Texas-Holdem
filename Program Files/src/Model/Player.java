package Model;

public class Player {
    private Hand myHand;
    private int money;//Total player money
    private String name;//Player name

    public Player(int money, String name) { //Create new player
        myHand = new Hand(); //Allocates new hand
        this.money = money; //set player money
        this.name = name; //set player name
    }
    public int GetMoney() {
        return money;
    }
    public String GetName() {
        return this.name;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Hand getMyHand() {
        return myHand;
    }
}
