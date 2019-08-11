package Model.Action;

public class Action extends IAction
{
    private String name;
    private int raise;
    public Action()
    {
        name="no action";
        this.raise=0;
    }
    public String  GetName()
    {
        return name;
    }
    public void SetName(String name)
    {
        this.name=name;
    }
    public void SetRaise(int money)
    {
        this.raise=money;
    }
    public int GetRaise()
    {
        return raise;
    }
}

