package View;

import javax.swing.*;

import Controller.SettingController;
import Controller.Controller;
import Model.ModelSetting;

public class SettingView extends JDialog {
    private JButton ButtonStart;
    private JButton ButtonBack;
    private JTextField PlayernameTextBox;
    private JTextField moneyTextBox;
    private JTextField smallBlind;
    private JLabel PlayerNameLabel;
    private JLabel moneyLabel;
    private JLabel blindsLabel;
    private SettingViewActionListener listener;
    private MainView mainView;

    //Create the second window - SettingView
    SettingView(MainView frame) {
        mainView = frame;
        CreateView();
        setUndecorated(true);
        setVisible(true);
        setSize(560, 330);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        ModelSetting model = new ModelSetting();
        Controller controller = new SettingController(model, listener);
        model.addObserver(controller);
        listener.addObserver(controller);

    }
    private void CreateView() {
        //The function Allocates the GUI Objects filling them with the relevant Text and locating them in the correct position
        ButtonStart = new JButton("Start");
        ButtonBack = new JButton("Back");
        PlayerNameLabel = new JLabel("Player Name:");
        PlayernameTextBox = new JTextField();
        moneyTextBox = new JTextField(1);
        blindsLabel = new JLabel("Small Blinds:");
        moneyLabel = new JLabel("Money:");
        smallBlind = new JTextField();
        listener = new SettingViewActionListener(PlayernameTextBox, moneyTextBox, smallBlind, this, mainView);
        ButtonBack.setBounds(50, 260, 100, 50);
        ButtonBack.addActionListener(listener);
        ButtonStart.setBounds(400, 260, 100, 50);
        ButtonStart.addActionListener(listener);
        PlayerNameLabel.setBounds(45, 30, 120, 40);
        PlayernameTextBox.setBounds(180, 30, 140, 40);
        PlayerNameLabel.setFont(PlayerNameLabel.getFont().deriveFont(18f)); //Resize the font
        moneyLabel.setBounds(45, 90, 120, 40);
        moneyTextBox.setBounds(180, 90, 140, 40);
        moneyLabel.setFont(moneyLabel.getFont().deriveFont(18f));
        blindsLabel.setBounds(45, 150, 120, 40);
        smallBlind.setBounds(180, 150, 140, 40);
        blindsLabel.setFont(blindsLabel.getFont().deriveFont(18f));
        getContentPane().add(PlayerNameLabel);
        getContentPane().add(PlayernameTextBox);
        getContentPane().add(moneyLabel);
        getContentPane().add(moneyTextBox);
        getContentPane().add(blindsLabel);
        getContentPane().add(smallBlind);
        getContentPane().add((ButtonStart));
        getContentPane().add((ButtonBack));
        getContentPane().add((new BackgroundPanel("BG2.jpg"))); //Set the Background pic
    }
}
