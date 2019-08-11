package Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableDataTest
{
    TableData tableData;
    Player player;
    BotPlayer computer;
    Deck deck;
    int playerRaise;
    int botRaise;
    Table table;
    ModelSetting model;

    @Before
    public void setUp() throws Exception
    {
        player=new Player(1000,"Roei");
        computer= new BotPlayer(1000,"Computer");
        deck= new Deck();
        playerRaise =10;
        botRaise =10;
        model=new ModelSetting();
        table=new Table("Roei",1000,5,model);
        tableData=new TableData(player,computer,deck, playerRaise, botRaise,table);
    }

    @Test
    public void getP1()
    {
        assertEquals(player.GetName(),tableData.getP1().GetName());
        assertEquals(player.GetMoney(),tableData.getP1().GetMoney());
    }

    @Test
    public void getBot()
    {
        assertEquals(computer.GetName(),tableData.getBot().GetName());
        assertEquals(computer.GetMoney(),tableData.getBot().GetMoney());
    }

    @Test
    public void getD1()
    {
        assertEquals(0,tableData.getD1().GetTotalMoneyInTable());
    }

    @Test
    public void getPlayerRaise()
    {
        assertEquals(playerRaise,tableData.getPlayerRaise());
    }

    @Test
    public void getBotRaise()
    {
        assertEquals(botRaise,tableData.getBotRaise());
    }


}