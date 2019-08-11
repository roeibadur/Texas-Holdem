package Model.Action;

//need to do call in Table
public class CallAction extends IAction {
    private String name = "Call";

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public int GetRaise() {
        return 0;
    }

    public void SetName(String name) {
        this.name = "Call";
    }

    public void SetRaise(int money) {
    }

}
