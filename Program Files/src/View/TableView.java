package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TableView extends Observable {

    private JDialog frame;
    private JButton checkButton;
    private JButton raiseButton;
    private JButton callButton;
    private JButton allINButton;
    private JButton FoldButton;
    private JLabel playerMoneyLabel;
    private JLabel playerNameLabel;
    private JLabel computerMoneyLabel;
    private JLabel computerNameLabel;
    private JLabel firstCardPlayerLabel;
    private JLabel secondCardPlayerLabel;
    private JLabel firstCardComputerLabel;
    private JLabel secondCardComputerLabel;
    private JLabel firstCardDeckLabel;
    private JLabel secondCardDeckLabel;
    private JLabel thirdCardDeckLabel;
    private JLabel fourCardDeckLabel;
    private JLabel fiveCardDeckLabel;
    private JLabel playerBlind;
    private JLabel botBlind;
    private JLabel raisePlayerLabel;
    private JLabel raiseBotLabel;
    private JLabel playerNameTag;
    private JLabel playerMoneyTag;
    private JLabel botMoneyTag;
    private JLabel botNameTag;
    private JLabel deckAmountTag;
    private JLabel moneyOfDeckLabel;
    private JTextField raiseAmount;
    private JLabel raiseAmountTag;
    private int bigBlind;
    private JLabel Blinds;
    private JLabel computermove;
    private TableViewActionListener listener;

    //    //Create the third window,the game view - TableView
    public TableView(String PlayerName, String StartMoney, String BotMoney, int SmallBlind) {
        CreateView();
        frame.setTitle("Texas Holde'm Poker");
        frame.setSize(1000, 666);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setResizable(false); //The window can't be resized
        frame.setLocationRelativeTo(null); //Set the window In the center of the screen
        frame.setVisible(true);
        bigBlind = SmallBlind * 2;
        //adjust the TableView label to the input
        playerBlind.setText(Integer.toString(SmallBlind));//Change int to string
        playerNameLabel.setText(PlayerName);
        botBlind.setText(String.valueOf(bigBlind));
        computerMoneyLabel.setText(BotMoney);
        playerMoneyLabel.setText(StartMoney);

    }

    private void CreateView() {
        // Allocates the GUI Objects filling them with the relevant Text and locating them in the correct position
        frame = new JDialog();
        callButton = new JButton("Call");
        raiseButton = new JButton("Raise");
        allINButton = new JButton("AllIN");
        checkButton = new JButton("Check");
        FoldButton = new JButton("Fold");
        listener = new TableViewActionListener(this);
        firstCardPlayerLabel = new JLabel();
        secondCardPlayerLabel = new JLabel();
        firstCardComputerLabel = new JLabel();
        secondCardComputerLabel = new JLabel();
        firstCardDeckLabel = new JLabel();
        secondCardDeckLabel = new JLabel();
        thirdCardDeckLabel = new JLabel();
        fourCardDeckLabel = new JLabel();
        fiveCardDeckLabel = new JLabel();
        callButton.addActionListener(listener);
        raiseButton.addActionListener(listener);
        allINButton.addActionListener(listener);
        checkButton.addActionListener(listener);
        FoldButton.addActionListener(listener);
        computerNameLabel = new JLabel("Computer");
        playerNameLabel = new JLabel();
        computerMoneyLabel = new JLabel();
        computermove = new JLabel("Computer Put BigBlind");
        moneyOfDeckLabel = new JLabel("0");
        raisePlayerLabel = new JLabel();
        playerMoneyLabel = new JLabel();
        raiseBotLabel = new JLabel();
        playerBlind = new JLabel();
        botBlind = new JLabel();
        playerNameTag = new JLabel();
        playerMoneyTag = new JLabel();
        botMoneyTag = new JLabel();
        botNameTag = new JLabel();
        deckAmountTag = new JLabel();
        moneyOfDeckLabel = new JLabel("0");
        raiseAmount = new JTextField("");
        raiseAmountTag = new JLabel("Enter how much to raise");
        Blinds = new JLabel("Blinds:");
        //Change the Background on this buttons
        checkButton.setBackground(Color.white);
        raiseButton.setBackground(Color.white);
        FoldButton.setBackground(Color.white);
        allINButton.setBackground(Color.white);
        //position the buttons in SettingView
        checkButton.setBounds(200, 585, 95, 35);
        callButton.setBounds(320, 585, 95, 35);
        raiseButton.setBounds(440, 585, 95, 35);
        FoldButton.setBounds(560, 585, 95, 35);
        allINButton.setBounds(680, 585, 95, 35);
        Blinds.setBounds(800, 585, 95, 25);
        botBlind.setBounds(470, 190, 95, 35);
        playerBlind.setBounds(470, 390, 95, 35);
        botMoneyTag.setBounds(70, 70, 95, 35);
        botNameTag.setBounds(70, 40, 95, 35);
        computerNameLabel.setBounds(110, 40, 95, 35);
        computerMoneyLabel.setBounds(110, 70, 95, 35);
        playerNameLabel.setBounds(110, 450, 95, 35);
        playerMoneyLabel.setBounds(110, 480, 95, 35);
        playerMoneyTag.setBounds(70, 480, 95, 35);
        playerNameTag.setBounds(70, 450, 95, 35);
        deckAmountTag.setBounds(70, 250, 120, 45);
        moneyOfDeckLabel.setBounds(150, 251, 100, 40);
        raiseAmount.setBounds(215, 510, 100, 25);
        raiseAmountTag.setBounds(70, 510, 140, 35);
        firstCardPlayerLabel.setBounds(375, 400, 100, 200);
        secondCardPlayerLabel.setBounds(475, 400, 100, 200);
        firstCardComputerLabel.setBounds(375, 20, 100, 200);
        secondCardComputerLabel.setBounds(475, 20, 100, 200);
        computermove.setBounds(375, 0, 200, 35);
        firstCardDeckLabel.setBounds(225, 200, 100, 200);
        secondCardDeckLabel.setBounds(325, 200, 100, 200);
        thirdCardDeckLabel.setBounds(425, 200, 100, 200);
        fourCardDeckLabel.setBounds(525, 200, 100, 200);
        fiveCardDeckLabel.setBounds(625, 200, 100, 200);
        //Changing the Border on this buttons
        checkButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
        callButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
        raiseButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
        FoldButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
        allINButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
        botNameTag.setText("Name: ");
        playerNameTag.setText("Name: ");
        playerMoneyTag.setText("Money: ");
        botMoneyTag.setText("Money: ");
        deckAmountTag.setText("Total Money: ");
        //Change the color font
        deckAmountTag.setForeground(Color.white);
        botNameTag.setForeground(Color.white);
        playerNameTag.setForeground(Color.white);
        playerMoneyTag.setForeground(Color.white);
        botMoneyTag.setForeground(Color.white);
        deckAmountTag.setForeground(Color.white);
        moneyOfDeckLabel.setForeground(Color.white);
        computerNameLabel.setForeground(Color.white);
        computermove.setForeground(Color.white);
        computermove.setFont(computermove.getFont().deriveFont(16f)); //Resize this label
        playerMoneyLabel.setForeground(Color.white);
        raiseAmountTag.setForeground(Color.white);
        playerBlind.setForeground(Color.white);
        playerNameLabel.setForeground(Color.white);
        botBlind.setForeground(Color.white);
        computerMoneyLabel.setForeground(Color.white);
        Blinds.setForeground(Color.white);
        //Add all the button and label to the frame
        frame.add(checkButton);
        frame.add(callButton);
        frame.add(raiseButton);
        frame.add(FoldButton);
        frame.add(allINButton);
        frame.add(playerNameLabel);
        frame.add(playerMoneyLabel);
        frame.add(playerNameTag);
        frame.add(playerMoneyTag);
        frame.add(botNameTag);
        frame.add(botMoneyTag);
        frame.add(computerMoneyLabel);
        frame.add(computerNameLabel);
        frame.add(computermove);
        frame.add(raiseAmount);
        frame.add(raiseAmountTag);
        frame.add(botBlind);
        frame.add(playerBlind);
        frame.add(deckAmountTag);
        frame.add(moneyOfDeckLabel);
        frame.add(firstCardPlayerLabel);
        frame.add(secondCardPlayerLabel);
        frame.add(firstCardComputerLabel);
        frame.add(secondCardComputerLabel);
        frame.add(firstCardDeckLabel);
        frame.add(secondCardDeckLabel);
        frame.add(thirdCardDeckLabel);
        frame.add(fourCardDeckLabel);
        frame.add(fiveCardDeckLabel);
        frame.add(Blinds);
        frame.add((new BackgroundPanel("MainFrame.jpg"))); //Set the Background pic
    }


    public void UpdateGame(ArrayList<ImageIcon> Playerhand, ArrayList<ImageIcon> ComputerHand, ArrayList<ImageIcon> Deck, String MoneyDeck, String RaiseBot, String RaisePlayer, String PlayerMoney, String BotMoney, int Smallblind, String move, String winner, String error) {
        //Updates Table view by interacting with the Model throw the controller, alerting the use if invalid action reformed/match ended
        firstCardPlayerLabel.setIcon(Playerhand.get(0)); //deal player cards
        secondCardPlayerLabel.setIcon(Playerhand.get(1));
        firstCardComputerLabel.setIcon(ComputerHand.get(0)); //deal computer cards
        secondCardComputerLabel.setIcon(ComputerHand.get(1));
        firstCardDeckLabel.setIcon(Deck.get(0)); //deal cards to Deck
        secondCardDeckLabel.setIcon(Deck.get(1));
        thirdCardDeckLabel.setIcon(Deck.get(2));
        fourCardDeckLabel.setIcon(Deck.get(3));
        fiveCardDeckLabel.setIcon(Deck.get(4));
        moneyOfDeckLabel.setText(MoneyDeck);  //update deck money
        playerMoneyLabel.setText(PlayerMoney); //update player money
        computerMoneyLabel.setText(BotMoney); //update computer money
        computermove.setText(move);
        botBlind.setText(RaiseBot);
        playerBlind.setText(RaisePlayer);
        raiseAmount.setText("");
        Blinds.setText("Blinds:" + Smallblind + "/" + Smallblind * 2); //set big blind
        if (!(error.equals("no error")))

            JOptionPane.showMessageDialog(this.frame, error, "Error", JOptionPane.ERROR_MESSAGE);

        if (winner.equals("Computer Won The Match")) {
            JOptionPane.showMessageDialog(this.frame, winner, "winner", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (winner.equals("Congratulations, You Won the Match")) {

            JOptionPane.showMessageDialog(this.frame, winner, "winner", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (winner.equals("Player Won The Round"))
            JOptionPane.showMessageDialog(this.frame, winner, "winner", JOptionPane.INFORMATION_MESSAGE);
        else if (winner.equals("Congratulations, You Won the Match"))
            JOptionPane.showMessageDialog(this.frame, winner, "winner", JOptionPane.INFORMATION_MESSAGE);
        else if (winner.equals("The Round Ended With Draw"))
            JOptionPane.showMessageDialog(this.frame, winner, "winner", JOptionPane.INFORMATION_MESSAGE);
        frame.repaint();
    }

    public JDialog getFrame() {
        return frame;
    }

    public String GetHowMuchRaise() {

        return raiseAmount.getText();
    }

    public TableViewActionListener GetListener()
    {
        return listener;
    }

}
