package Model;

import java.util.Observable;
//*******************************************************************//
//Model Setting,used for processing the data from the setting view,  //
//and then initializing the game with the user properties.          //
//*******************************************************************//
public class ModelSetting extends Observable {
    private Table table;
    private int startmoney;
    private int smallBlind;

    public ModelSetting() {
    }

    public void StartGame(String Playername, String StartMoney, String SmallBlind) {
        this.startmoney = Integer.parseInt(StartMoney);
        this.smallBlind = Integer.parseInt(SmallBlind);
        this.table = new Table(Playername, this.startmoney, this.smallBlind, this); //Initialize table
        table.StartGame();

    }

    public void Update() { //Update the table
        setChanged();
        notifyObservers(table.GetTableData());
    }
}
