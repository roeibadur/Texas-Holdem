package Controller;
import Model.TableData;
import View.TableObserver;
import View.TableViewActionListener;
import View.TableView;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

public class TableController implements Controller {
    private TableData tableData;
    private TableView tableView;
    private TableViewActionListener actionListener;
    private ArrayList<ImageIcon> playerHand;
    private ArrayList<ImageIcon> computerHand;
    private ArrayList<ImageIcon> deck;
    private String moneyInDeck;
    private String botRaise;
    private String playerRaise;
    private String playerMoney;
    private String botMoney;
    private String winner;


    TableController(TableData TableModel, TableView TableView, TableViewActionListener TableButtonActionListener) {
        tableData = TableModel;
        tableView = TableView;
        playerHand = new ArrayList<ImageIcon>();
        computerHand = new ArrayList<ImageIcon>();
        deck = new ArrayList<ImageIcon>();
        actionListener = TableButtonActionListener;
    }

    @Override
    public void update(Observable o, Object arg) {
        //Implements update with tow choices TableData  - Passing Data from Model To View
        //TableActionListener instance of TableViewListener passing user Action to the Model
        if (o instanceof TableData) {
            if (tableData.GetTable().GetIsNewGame()) {
                playerHand.add(((TableData) arg).getP1().getMyHand().getCardsInHand().get(0).GetImage());
                playerHand.add(((TableData) arg).getP1().getMyHand().getCardsInHand().get(1).GetImage());
                computerHand.add(((TableData) arg).getBot().getMyHand().getCardsInHand().get(0).GetBackpic());
                computerHand.add(((TableData) arg).getBot().getMyHand().getCardsInHand().get(1).GetBackpic());
                for (int i = 0; i < 5; i++) {
                    if (((TableData) arg).getD1().getOpenCards().get(i).IsAvillable())
                        deck.add(((TableData) arg).getD1().getOpenCards().get(i).GetImage());
                    else deck.add(((TableData) arg).getD1().getOpenCards().get(i).GetBackpic());
                }
                tableData.GetTable().SetIsNewGame(false);
            }
            else {
                for (int i = 4; i >= 0; i--)
                    deck.remove(i);
                for (int i = 1; i >= 0; i--) {
                    playerHand.remove(i);
                    computerHand.remove(i);
                }
                for (int i = 0; i < 2; i++)
                {
                    playerHand.add(((TableData) arg).getP1().getMyHand().getCardsInHand().get(i).GetImage());
                    if(tableData.getWinner().equals("no winner"))
                        computerHand.add(((TableData) arg).getBot().getMyHand().getCardsInHand().get(i).GetBackpic());
                    else computerHand.add(((TableData) arg).getBot().getMyHand().getCardsInHand().get(i).GetImage());

                }

                for (int i = 0; i < 5; i++) {
                    if (((TableData) arg).getD1().getOpenCards().get(i).IsAvillable())
                        deck.add(((TableData) arg).getD1().getOpenCards().get(i).GetImage());
                    else deck.add(((TableData) arg).getD1().getOpenCards().get(i).GetBackpic());
                }

            }
            moneyInDeck = Integer.toString(tableData.getD1().GetTotalMoneyInTable());
            botRaise = Integer.toString(tableData.getBotRaise());
            playerRaise = Integer.toString(tableData.getPlayerRaise());
            playerMoney = Integer.toString(tableData.getP1().GetMoney());
            botMoney = Integer.toString(tableData.getBot().GetMoney());
            tableView.UpdateGame(playerHand, computerHand, deck, moneyInDeck, botRaise, playerRaise, playerMoney, botMoney, tableData.Getsmallblind(),tableData.Getcomputermove(),tableData.getWinner(),tableData.getError());
        } else if (o instanceof TableViewActionListener) {
            tableData.GetTable().PlayerTurn(((TableObserver) arg).getActionName(), ((TableObserver) arg).getRaise());

        }

    }
}
