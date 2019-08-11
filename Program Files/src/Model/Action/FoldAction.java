package Model.Action;

public class FoldAction extends IAction {
    private String name = "Fold";

    @Override
    public String GetName() {
        return this.name;
    }

    @Override
    public int GetRaise() {
        return 0;
    }

    public void SetName(String name) {
        this.name = "Fold";
    }

    public void SetRaise(int raise) {
    }
}
