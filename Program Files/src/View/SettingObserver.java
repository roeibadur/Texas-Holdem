package View;

public class SettingObserver {
    private String playerName;
    private String startMoney;
    private String smallBlind;

    //Data object that used by the setting view in order to interacts with the Model throw the controller

    public SettingObserver(String Playername, String StartMoney, String SmallBlind) {

        this.playerName = Playername;
        this.startMoney = StartMoney;
        this.smallBlind = SmallBlind;
    }

    //Get to user information
    public String getPlayerName() {

        return playerName;
    }
    public String getStartMoney() {

        return startMoney;
    }
    public String getSmallBlind() {

        return smallBlind;
    }
}
