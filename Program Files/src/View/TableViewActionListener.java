package View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
public class TableViewActionListener extends Observable implements ActionListener
{
    private TableObserver observer;
    private TableView tableView;

    //Adjusting each button
    public TableViewActionListener(TableView table)
    {
        observer=new TableObserver("Check","0");
        tableView=table;
    }
    private void Update()
    {
        setChanged();
        notifyObservers(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Check": //Push "Check" - set raise on 0 and update
                        observer.setActionName("Check");
                        observer.setRaise("0");
                        Update();
                        break;
            case "Fold": //Push "Fold" - fold and update
                        observer.setActionName("Fold");
                        observer.setRaise("0");
                        Update();
                        break;
            case "Call": //Push "Call" - call and update
                        observer.setActionName("Call");
                        observer.setRaise("0");
                        Update();
                        break;
            case "AllIN": //Push "ALINN" - raise al the money and update
                        observer.setActionName("AllIN");
                        observer.setRaise("0");
                        Update();
                        break;
            case "Raise": //Push "Raise" - raise money and update
                        if (InputValidation(tableView.GetHowMuchRaise())) {
                        observer.setActionName("Raise");
                        observer.setRaise(tableView.GetHowMuchRaise());
                        Update();
                        }
                        break;
        }
    }
    //Check if your raise is valid
    boolean InputValidation(String RaiseAmount)
    {
        int value;
        try{
            value = Integer.parseInt(RaiseAmount);

        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(tableView.getFrame(), "Please Enter Valid Value","Invalid Input",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }
}
