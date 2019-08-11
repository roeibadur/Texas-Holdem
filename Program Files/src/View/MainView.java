package View;

import javax.swing.*;

public class MainView extends JFrame {
    //MainView is the first window that interacts with the user,
    //There is no logic except user use flow
    private JButton buttonPlay;
    private JButton buttonHelp;
    private JButton buttonExit;
    private MainViewActionListener listener;

    //Create the first window - MainView
    public MainView() {
        CreateView();
        setTitle("Texas Holde'm Poker");
        setSize(830, 460);
        setResizable(false);
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Allocates the GUI Objects filling them with the relevant Text and locating them in the correct position
    private void CreateView() {
        //Allocates the buttons and filling them with the relevant Text
        listener = new MainViewActionListener(this);
        buttonPlay = new JButton("Play");
        buttonPlay.addActionListener(listener);
        buttonHelp = new JButton("Help");
        buttonHelp.addActionListener(listener);
        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(listener);
        getContentPane().add((buttonPlay));
        getContentPane().add((buttonHelp));
        getContentPane().add((buttonExit));
        getContentPane().add((new BackgroundPanel("bg.jpeg"))); //Set the Background pic
        //position the buttons in SettingView
        buttonPlay.setBounds(100, 100, 100, 50);
        buttonHelp.setBounds(100, 200, 100, 50);
        buttonExit.setBounds(100, 300, 100, 50);
    }

    public static void main(String[] args) {
        MainView main = new MainView();
    }
}