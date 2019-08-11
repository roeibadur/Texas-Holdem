package Model.Action;

public abstract class IAction {
    public abstract String GetName();

    public abstract void SetName(String name);

    public abstract void SetRaise(int money);

    public abstract int GetRaise();
}

