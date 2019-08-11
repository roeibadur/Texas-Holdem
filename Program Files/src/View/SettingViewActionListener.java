package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class SettingViewActionListener extends Observable implements ActionListener {
    private SettingObserver observer;
    private JTextField playerName;
    private JTextField startMoney;
    private JTextField smallBlind;
    private SettingView view;
    private MainView mainView;

    // Manage all actions in the window MainView
    public SettingViewActionListener(JTextField playernameTextBox, JTextField StartMoney, JTextField smallBlind, SettingView view, MainView mainview) {
        this.startMoney = StartMoney;
        this.playerName = playernameTextBox;
        this.smallBlind = smallBlind;
        this.view = view;
        this.mainView = mainview;
    }
    //Adjusting each button
    public void actionPerformed(ActionEvent event) {
        boolean IsValid;
        switch (event.getActionCommand()) {
            case "Start": //Push button "Start"
                IsValid = InputValidation(playerName.getText(), startMoney.getText(), smallBlind.getText());//Check if you entered a valid imput
                if (IsValid) { //If the input is valid - create new SettingObserver
                    observer = new SettingObserver(playerName.getText(), startMoney.getText(), smallBlind.getText());
                    setChanged();
                    view.dispose();
                    notifyObservers(observer);
                }
                break;
            case "Back":
                mainView.setVisible(true);
                view.dispose();
                break;
        }
    }
   // Verifying The input
    boolean InputValidation(String Playername, String StartMoney, String SmallBlind) {
        int value;
        try {

            value = Integer.parseInt(StartMoney);
            value = Integer.parseInt(SmallBlind);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Please Enter Valid Value", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}