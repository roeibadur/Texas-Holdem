package Model.Action;

public class RaiseAction extends IAction {
    private String name;
    private int raiseSum;

    public RaiseAction(int raise) {
        name = "Raise";
        this.raiseSum = raise;

    }

    @Override
    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name=name;
    }

    @Override
    public int GetRaise() {
        return raiseSum;
    }

    @Override
    public void SetRaise(int money) {
        raiseSum = money;
    }
}
