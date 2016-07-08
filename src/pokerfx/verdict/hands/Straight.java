package pokerfx.verdict.hands;

/**
 * Created by buzalskim on 2016-07-06.
 */
public class Straight extends Hand {

    public Straight(Card card) {
        super(HandValue.Straight, card);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
