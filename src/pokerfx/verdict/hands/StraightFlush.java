package pokerfx.verdict.hands;

/**
 * Created by buzalskim on 2016-07-06.
 */
public class StraightFlush extends Hand {

    public StraightFlush(Card card) {
        super(HandValue.StraightFlush, card);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
