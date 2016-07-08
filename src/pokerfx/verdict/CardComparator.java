package pokerfx.verdict;



import pokerfx.verdict.hands.Card;
import pokerfx.verdict.hands.CardMap;

import java.util.Comparator;


/**
 * Compares 2 Cards
 */
class CardComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {

        Card c1=CardMap.getMap().get(String.valueOf(s1.charAt(0)));
        Card c2= CardMap.getMap().get(String.valueOf(s2.charAt(0)));
        return c1.ordinal()-c2.ordinal();

    }
}
