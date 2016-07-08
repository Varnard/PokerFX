package pokerfx.verdict.hands;

/**
 * Created by buzalskim on 2016-07-06.
 */
public class FullHouse extends Hand {

    private Card card2;

    public FullHouse(Card card,Card card2) {
        super(HandValue.FullHouse, card);
        this.card2 = card2;
    }

    @Override
    public String toString() {
        return value+ ": " + card+" and "+card2;
    }
}

