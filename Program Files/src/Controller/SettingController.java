package Controller;
import View.SettingViewActionListener;
import View.SettingObserver;
import Model.ModelSetting;
import java.util.Observable;
import Model.TableData;
import View.TableView;

public class SettingController implements Controller
{
    private ModelSetting model;
    private SettingViewActionListener view;
    private Controller controller;
    private TableView gameView;

    public SettingController(ModelSetting model, SettingViewActionListener view)
    {
        this.view = view;
        this.model = model;
    }
    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof SettingViewActionListener)
        {
            model.StartGame(((SettingObserver)arg).getPlayerName(),((SettingObserver)arg).getStartMoney(),((SettingObserver)arg).getSmallBlind());
        }
        else if(o instanceof ModelSetting)
        {
            gameView = new TableView(((TableData)arg).getP1().GetName(),Integer.toString(((TableData)arg).getP1().GetMoney()),Integer.toString(((TableData)arg).getBot().GetMoney()),((TableData)arg).getPlayerRaise());
            controller=new TableController(((TableData)arg), gameView, gameView.GetListener());
            gameView.GetListener().addObserver(controller);
            gameView.addObserver(controller);
            ((TableData)arg).addObserver(controller);
        }

    }
}
