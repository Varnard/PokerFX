package pokerfx.verdict.hands;

/**
 * Created by buzalskim on 2016-07-06.
 */
public class TwoPairs extends Hand{

    private Card card2;

    public TwoPairs(Card card,Card card2)
    {
        super(HandValue.TwoPairs,card);
        this.card2=card2;
    }

    @Override
    public int getCardValue() {
        if (card.ordinal()>card2.ordinal())
        {
            return card.ordinal()*100+card2.ordinal();
        }
        else return card2.ordinal()*100+card.ordinal();
    }

    @Override
    public String toString() {
        return value+ ": " + card+" and "+card2;
    }
}
