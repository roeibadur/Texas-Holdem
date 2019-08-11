package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
// Manage all actions in the MainView Window
public class MainViewActionListener implements ActionListener {

    MainView mainView;

    public MainViewActionListener(MainView view) {

        mainView = view;
    }
    //Adjusting each button
    public void actionPerformed(ActionEvent event) {

        switch (event.getActionCommand()) {

            case "Play": //Push "Play" - create new SettingView
                SettingView view = new SettingView(mainView);
                mainView.setVisible(false);
                break;
            case "Help": //Push "Help" - Open the Help document
                if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File(getClass().getResource("/Resources/help.pdf").getPath());
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(mainView, "Missing Help File", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Exit": //Push "Exit" - Close MainView window
                mainView.dispose();
                break;


        }


    }
}


