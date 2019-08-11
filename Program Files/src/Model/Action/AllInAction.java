package Model.Action;

public class AllInAction extends IAction {
    private String name = "AllIN";
    private int raise;

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public int GetRaise() {
        return raise;
    }

    @Override
    public void SetRaise(int money) {
        raise = money;
    }

    public void SetName(String name) {
        this.name = "AllIN";
    }
}
