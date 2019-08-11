package Model;

import java.util.ArrayList;
//*******************************************************************//
//This class contain all the Poker Evaluation, Winning               //
// and Hand Strength(translated into integer), this class is core    //
// logic class                                                       //
//*******************************************************************//

public class HandEvaluator {
    private int level;
    public HandEvaluator() {
        level = 0;
    }

    public String EvaluateHand(ArrayList<Card> hand) { //return the values of the hand(one pair, two pair...)
        int counter = 0;
        int size = hand.size();
        int maxnumber = 0;
        int[] groups = new int[14];
        boolean flush, straight;
        for (Card c : hand) //Add the card of hand to new list
            groups[c.getnumber()]++;
        for (int i = 1; i < 14; ++i) {
            if (groups[i] > 0)
                counter++; //The number of different cards
            if (groups[i] > maxnumber)
                maxnumber = groups[i]; //The high common cards number
        }
        switch (size) {
            case 2: //2 cards in hand case

                if (counter == 1)
                    return "one-pair";
                return "high-card";

            case 5: //5 cards in hand Case

                if (counter == 5) {
                    straight = is_straight(groups);
                    flush = is_flush(hand);
                    if (flush && straight)
                        return "straight-flush";
                    if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else return "high-card";
                }
                if (counter == 4)
                    return "one-pair";
                else if (counter == 3 && maxnumber == 3)
                    return "three-of-kind";
                else if (counter == 3 && maxnumber == 2)
                    return "two-pairs";
                else if (counter == 2 && maxnumber == 4)
                    return "four-of-kind";
                else if (counter == 2 && maxnumber == 3)
                    return "full-house";
                else return "four-of-kind";

            case 6: //6 cards in hand Case
                if (counter == 6) {
                    flush = is_flush(hand);
                    straight = is_straight(groups);
                    if (flush && straight)
                    {
                        if (Is_StraightFlush(hand))
                            return "straight-flush";
                    }
                    if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else return "high-card";
                }
                if (counter == 5) {
                    flush = is_flush(hand);
                    straight = is_straight(groups);
                    if (flush && straight)
                        return "straight-flush";
                    else if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else return "one-pair";
                }
                if (counter == 4 && maxnumber == 3)
                    return "three-of-kind";
                else if (counter == 4 && maxnumber == 2)
                    return "two-pairs";
                else if (counter == 3 && maxnumber == 4)
                    return "four-of-kind";
                else if (counter == 3 && maxnumber == 3)
                    return "full-house";
                else if (counter == 3 && maxnumber == 2)
                    return "two-pairs";
                else if (counter == 2 && maxnumber == 4)
                    return "four-of-kind";
                else return "three-of-kind";

            default: //7 cards in hand Case
                if (counter == 7)
                {
                    flush = is_flush(hand);
                    straight = is_straight(groups);
                    if (flush && straight)
                    {
                        if (Is_StraightFlush(hand))
                            return "straight-flush";
                    }
                    if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else return "high-card";
                }
                if (counter == 6)
                {
                    flush = is_flush(hand);
                    straight = is_straight(groups);
                    if (flush && straight)
                    {
                        if (Is_StraightFlush(hand))
                            return "straight-flush";
                    }
                    if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else return "one-pair";
                }
                if (counter == 5) {
                    flush = is_flush(hand);
                    straight = is_straight(groups);
                    if (flush && straight) {
                        if (Is_StraightFlush(hand))
                            return "straight-flush";
                    }
                    if (flush)
                        return "flush";
                    else if (straight)
                        return "straight";
                    else if (maxnumber == 3)
                        return "three-of-kind";
                    else return "two-pairs";
                }
                if (counter == 4 && maxnumber == 4)
                    return "four-of-kind";
                else if (counter == 4 && maxnumber == 3)
                    return "full-house";
                else if (counter == 4 && maxnumber == 2)
                    return "two-pairs";
                else if (counter == 3 && maxnumber == 4)
                    return "four-of-kind";
                else if (counter == 3 && maxnumber == 3)
                    return "full-house";
                else return "four-of-kind";

        }
    }

    private Boolean Is_StraightFlush(ArrayList<Card> hand) { //Check if your hand is POKER
        ArrayList<Card> check = new ArrayList<Card>(7);
        ArrayList<Card> optimal = new ArrayList<Card>(2);
        for (Card card : hand) //Add to check array ak the card in the hand
            check.add(card);
        for (int i = 0; i < check.size(); i++) { //Iterating over the Player Hand creats the Optimal Hand From Given cardss
            optimal.add(check.get(i));
            check.remove(check.get(i));
            if (is_flush(check))
                continue;
            else
                check.add(optimal.get(optimal.size() - 1));
        }
        int[] counts = new int[14];
        for (Card c : check)
            counts[c.getnumber()]++;
        if (is_straight(counts))
            return true;
        return false;
    }

    //Check if has a straight
    private boolean is_straight(int[] groups) {
        int counter = 0;
        for (int i = 1; i < 14; i++)
        {
            if (groups[i] > 0)
                counter++;
            else counter = 0;
            if (counter == 5)
                return true;
        }
        if(counter==4&&groups[1]>0)
            return true;
        return false;
    }

    //Check if have flush
    private boolean is_flush(ArrayList<Card> hand) {
        int flag = 0;
        int[] suits = new int[4];
        int i, counter = 0;
        for (Card c : hand) {
            if (c.getType() == CardType.DIAMONDS)
                suits[0]++;
            if (c.getType() == CardType.SPADES)
                suits[1]++;
            if (c.getType() == CardType.HEARTS)
                suits[2]++;
            if (c.getType() == CardType.CLUBS)
                suits[3]++;
        }
        for (i = 0; i < 4; i++) {
            if (suits[i] >= 5)
                return true;
        }
        return false;

    }

    //Getting ths
    public int CheckLevel(String ValueOfHand, ArrayList<Card> hand) {
        int i;
        int[] count = new int[14];
        for (Card card : hand)
            count[card.getnumber()]++;

        switch (ValueOfHand) {
            case "high-card":
                level = 1;
                if (count[1] == 1)
                    level += 4;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 1)
                            break;
                    if (i >= 2 && i <= 6) level += 1;
                    else if (i >= 7 && i <= 10) level += 2;
                    else level += 4;
                }
                break;
            case "one-pair":
                level = 5;
                if (count[1] == 2)
                    level += 6;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 2)
                            break;
                    if (i >= 2 && i <= 6) level += 2;
                    else if (i >= 7 && i <= 10) level += 4;
                    else level += 6;
                }
                break;
            case "two-pairs":
                level = 12;
                if (count[1] == 2)
                    level += 7;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 2)
                            break;
                    if (i >= 2 && i <= 6) level += 2;
                    else if (i >= 7 && i <= 10) level += 4;
                    else level += 7;
                }
                break;
            case "three-of-kind":
                level = 20;
                if (count[1] == 3)
                    level += 10;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 3)
                            break;
                    if (i >= 2 && i <= 6) level += 5;
                    else if (i >= 7 && i <= 10) level += 7;
                    else level += 10;
                }
                break;
            case "straight":
                level = 30;
                int counter = 0;
                for (i = 1; i < 14; i++) {
                    if (count[i] == 1)
                        counter++;
                    else counter = 0;
                    if (counter == 5) break;
                }
                if (counter == 4 && count[1] == 1)
                    level += 15;
                else if (i <= 6) level += 5;
                else if (i >= 7 && i <= 10) level += 10;
                else level += 15;
                break;
            case "flush":
                level = 45;
                int[] suits = new int[4];
                int[] Values = new int[4];
                for (Card c : hand) {
                    if (c.getType() == CardType.DIAMONDS) {
                        suits[0]++;
                        if (Values[0] < c.getnumber())
                            Values[0] = c.getnumber();
                    }
                    if (c.getType() == CardType.SPADES) {
                        suits[1]++;
                        if (Values[1] < c.getnumber())
                            Values[1] = c.getnumber();
                    }
                    if (c.getType() == CardType.HEARTS) {
                        suits[2]++;
                        if (Values[2] < c.getnumber())
                            Values[2] = c.getnumber();
                    }
                    if (c.getType() == CardType.CLUBS) {
                        if (Values[3] < c.getnumber())
                            Values[3] = c.getnumber();
                        suits[3]++;
                    }

                }
                for (i = 0; i < 4; i++)
                    if (suits[i] >= 5)
                        break;
                if (Values[i] >= 2 && Values[i] <= 6)
                    level += 5;
                else if (Values[i] >= 7 && Values[i] <= 10)
                    level += 10;
                else level += 15;
                break;
            case "full-house":
                level = 60;
                if (count[1] == 3)
                    level += 15;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 3)
                            break;
                    if (i >= 2 && i <= 6) level += 5;
                    else if (i >= 7 && i <= 10) level += 10;
                    else level += 15;
                }
                break;
            case "four-of-kind":
                level = 75;
                if (count[1] == 4)
                    level += 15;
                else {
                    for (i = 13; i > 2; i--)
                        if (count[i] == 4)
                            break;
                    if (i >= 2 && i <= 6) level += 5;
                    else if (i >= 7 && i <= 10) level += 10;
                    else level += 15;
                }
                break;
            case "straight-flush":
                level = 100;
                break;
        }
        return level;
    }


    public String HighCard(int[] countPlayer, int[] countComputer) {
        for (int i = 13; i >= 0; i--) {
            if (countComputer[i] > 0 && countPlayer[i] == 0)
                return "Computer";
            else if (countComputer[i] == 0 && countPlayer[i] > 0)
                return "Player";
        }
        return "Even";
    }


    public String CheckWinner(ArrayList<Card> Playerhand, ArrayList<Card> Computerhand) {
        String ValueofhandPlayer = EvaluateHand(Playerhand);
        String ValueofhandBot = EvaluateHand(Computerhand);
        int LevelPlayer = CheckLevel(ValueofhandPlayer, Playerhand);
        int LevelBot = CheckLevel(ValueofhandBot, Computerhand);
        if (LevelPlayer > LevelBot)
            return "Player";
        else if (LevelBot > LevelPlayer)
            return "Computer";
        else {
            int counterC = 0;
            int counterP = 0;
            int[] countPlayer = new int[14];
            int[] countComputer = new int[14];
            for (Card card : Playerhand)
                countPlayer[card.getnumber()]++;
            for (Card card : Computerhand)
                countComputer[card.getnumber()]++;
            switch (ValueofhandPlayer) {
                case "high-card":
                    return HighCard(countPlayer, countComputer);
                case "one-pair":
                    for (int i = 13; i >= 0; i--) {
                        if (countComputer[i] == 2 && countPlayer[i] < 2)
                            return "Computer";
                        else if (countComputer[i] == 2 && countPlayer[i] < 2)
                            return "Player";
                    }
                    return HighCard(countPlayer, countComputer);


                case "two-pairs":
                    for (int i = 13; i >= 0; i--) {
                        if (countComputer[i] == 2 && countPlayer[i] < 2)
                            return "Computer";
                        else if (countComputer[i] == 2 && countPlayer[i] < 2)
                            return "Player";
                    }
                    return HighCard(countPlayer, countComputer);

                case "three-of-kind":
                    for (int i = 13; i >= 0; i--) {
                        if (countComputer[i] == 3 && countPlayer[i] < 3)
                            return "Computer";
                        else if (countComputer[i] == 3 && countPlayer[i] < 3)
                            return "Player";
                    }
                    return HighCard(countPlayer, countComputer);
                default:
                    return "Even";
            }

        }


    }
}