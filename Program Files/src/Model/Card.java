package Model;

import javax.swing.*;


public class Card {
    private int number;
    private CardType Type;
    private boolean isAvailable;
    private ImageIcon pic;
    private ImageIcon backPic;

    public Card(int number, CardType type) {
        this.number = number;//The number of card
        Type = type;//The type of card
        isAvailable = false;//The status of card
        try {
            pic = new ImageIcon(getClass().getResource("/Resources/Cards/" + number + "_" + type + ".jpg"));//create picture of the card
            backPic = new ImageIcon(getClass().getResource("/Resources/Cards/gav.png"));//create back picture of the card
        } catch (Exception e) {

            //in the reality i would write into the log......
        }
    }

    public void setnumber(int number) {
        this.number = number;
    } //Set number of the card

    public int getnumber() {
        return number;
    } //Get number of the card

    public CardType getType() {
        return Type;
    } //Get type of the card

    public void SetType(CardType type) {
        this.Type = type;
    } //Set type of the card

    public void setAvailable(boolean Avillable) {

        isAvailable = Avillable;
    }

    public boolean IsAvillable() {
        return isAvailable;
    }

    public ImageIcon GetImage() {
        return pic;
    }

    public ImageIcon GetBackpic() {
        return backPic;
    }


}
