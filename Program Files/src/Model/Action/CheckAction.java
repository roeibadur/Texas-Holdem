package Model.Action;

public class CheckAction extends IAction {
    private String name = "Check";

    @Override
    public String GetName() {
        return this.name;
    }

    @Override
    public int GetRaise() {
        return 0;
    }

    public void SetName(String name) {
        this.name = "Check";
    }

    public void SetRaise(int money) {
    }

}
