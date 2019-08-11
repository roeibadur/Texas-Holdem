package Model;

import Model.Action.*;
//***************************Description************************************//
//Bot Player Class implements all the Computer Decision making process,     //
// he is using the poker Evaluation logic for the decision how to react     //
// to the user                                                              //
//****************************Description********************************//

public class BotPlayer extends Player {
    private HandEvaluator HandEvaluator;

    public BotPlayer(int money, String name) {
        super(money, name);
        HandEvaluator = new HandEvaluator(); //Evaluate the computer hand with HandValidator()
    }

    //check what is the "level" of the computer hand with cardvalidator() and with the hand level the computer computer bet a adjusted amount of money
    public IAction EvaluateBet(IAction PreviousAction, int Curaise) {
        String valueOfHand = HandEvaluator.EvaluateHand(this.getMyHand().getCardsInHand());
        int level = HandEvaluator.CheckLevel(valueOfHand, this.getMyHand().getCardsInHand());
        int caselevel = isBetween(level);
        switch (caselevel) {
            case 1:
                if ((PreviousAction.GetName().equals("Raise")) && (PreviousAction.GetRaise() - Curaise < this.GetMoney() * 0.1))
                    return new CallAction();
                else if ((PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")))
                    return new FoldAction();
                return new CheckAction();

            case 2:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.15)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.07));
            case 3:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.15)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.1));
            case 4:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.25)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.15));
            case 5:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.30)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.15));
            case 6:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.45)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.20));
            case 7:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.55)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.25));
            case 8:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.65)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.25));
            case 9:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney())
                        return new CallAction();
                    else return new AllInAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.25));
            case 10:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney() * 0.70)
                        return new CallAction();
                    else return new FoldAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.30));
            case 11:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney())
                        return new CallAction();
                    else return new AllInAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.50));
            case 12:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney())
                        return new CallAction();
                    else return new AllInAction();
                } else return new RaiseAction((int) (this.GetMoney() * 0.60));
            case 13:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney())
                        return new CallAction();
                    else return new AllInAction();
                } else return new AllInAction();
            case 14:
                if (PreviousAction.GetName().equals("Raise") || PreviousAction.GetName().equals("AllIN")) {
                    if (PreviousAction.GetRaise() - Curaise <= this.GetMoney())
                        return new CallAction();
                    else return new AllInAction();
                } else return new AllInAction();
            default:
                return null;

        }

    }

    //Getting level as input and return what is the case to EvaluateBet()
    private int isBetween(int level) {
        if (level > 1 && level < 6)
            return 1;
        else if (level > 6 && level < 11)
            return 2;
        else if (level == 11)
            return 3;
        else if (level > 13 && level < 17)
            return 4;
        else if (level == 19)
            return 5;
        else if (level > 24 && level < 28)
            return 6;
        else if (level == 30)
            return 7;
        else if (level > 34 && level < 41)
            return 8;
        else if (level == 45)
            return 9;
        else if (level > 49 && level < 56)
            return 10;
        else if (level == 60)
            return 11;
        else if (level > 64 && level < 76)
            return 12;
        else if (level > 79 && level < 91)
            return 13;
        else return 14;
    }

}
