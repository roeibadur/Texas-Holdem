package Model;

import java.util.Observable;
//*******************************************************************//
//Table Data class holds all the relevant Data for the current Game, //
//used As Data object for interaction with the Table View via  Table //
// View controller, extends Observable class.                        //
//*******************************************************************//
public class TableData extends Observable
{

    private Player p1;
    private BotPlayer bot;
    private Deck d1;
    private String playerRaise;
    private String botRaise;
    private Table table;
    private int smallBlind;
    String computermove;
    String winner="no winner";
    String error="no error";

    //Initialize all the table screen
    public TableData(Player p1, BotPlayer bot, Deck d1, int PlayerRaise, int BotRaise, Table t1)
    {
        this.p1 = p1;
        this.bot = bot;
        this.d1 = d1;
        this.playerRaise = Integer.toString(PlayerRaise);
        this.botRaise = Integer.toString(BotRaise);
        table = t1;
    }

    public Player getP1() { return p1;}

    public BotPlayer getBot() {

        return bot;
    }

    public String getWinner() {

        return winner;
    }

    public void setWinner(String winner) {

        this.winner = winner;
    }

    public Deck getD1() {

        return d1;
    }

    public void setP1(Player p1) {

        this.p1 = p1;
    }

    public void setBot(BotPlayer bot) {

        this.bot = bot;
    }

    public void setD1(Deck d1) {

        this.d1 = d1;
    }
    void Update(Player p1, BotPlayer bot, Deck d1) {
        setBot(bot);
        setP1(p1);
        setD1(d1);
        setChanged();
        notifyObservers(this);
    }

    public int getPlayerRaise() {

        return Integer.parseInt(playerRaise);
    }

    public void setPlayerRaise(int PlayerRaise) {

        this.playerRaise = Integer.toString(PlayerRaise);
    }

    public int getBotRaise() {

        return Integer.parseInt(botRaise);
    }

    public void setBotRaise(int BigBlind) {

        this.botRaise = Integer.toString(BigBlind);
    }

    public Table GetTable() {

        return table;
    }

    public void Setsmallblind(int smallblind) {

        this.smallBlind = smallblind;
}

    public int Getsmallblind() {

        return this.smallBlind;
    }

    public void SetComputermove(String move){
        this.computermove=move;
    }
    public String Getcomputermove()
    {
        return this.computermove;
    }

    public String getError() {

        return error;
    }

    public void setError(String error) {

        this.error = error;
    }

}

