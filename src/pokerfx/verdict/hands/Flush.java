package pokerfx.verdict.hands;

/**
 * Created by buzalskim on 2016-07-06.
 */
public class Flush extends Hand {

    public Flush(Card card) {
        super(HandValue.Flush, card);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
