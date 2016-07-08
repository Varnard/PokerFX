package pokerfx.verdict.hands;

public abstract class Hand {

    HandValue value;
    Card card;

    public Hand(HandValue value,Card card)
    {
        this.value=value;
        this.card=card;
    }

    public int getValue() {
        return value.ordinal();
    }

    public int getCardValue() {
        return card.ordinal();
    }

    public int compare(Hand secondHand)
    {
        if (getValue()>secondHand.getValue())return 1;
        else if (getValue()<secondHand.getValue()) return -1;
        else
        {
            if (getCardValue()>secondHand.getCardValue())return 1;
            else if(getCardValue()<secondHand.getCardValue()) return -1;
            else return 0;
        }
    }

    @Override
    public String toString() {
        return value.toString()+ ": " + card.toString();
    }

}
