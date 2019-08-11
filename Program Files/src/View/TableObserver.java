package View;

//Data object that holds the relevant Data for the Interaction Between the Table View and The Game logic (Model) throw the controller
public class TableObserver {
    private String actionName;
    private String raise;

    public TableObserver(String actionName, String raise) {
        this.actionName = actionName;
        this.raise = raise;
    }

    public void setActionName(String actionName) {

        this.actionName = actionName;
    }

    public void setRaise(String raise) {

        this.raise = raise;
    }

    public String getActionName() {

        return actionName;
    }

    public String getRaise() {

        return raise;
    }
}
