package pokerfx.verdict;


import pokerfx.verdict.hands.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class for running Poker game simulation
 */
public class Poker {

    /**
     * @param white String representation of the hand of "white" player
     * @param black String representation of the hand of "black" player
     * @return String describing the result of the round
     */
    public static String compareHands(List<String> white, List<String> black)
    {
        white.sort(new CardComparator());
        black.sort(new CardComparator());

        Hand whiteValue=checkHand(white);
        Hand blackValue=checkHand(black);

        if (whiteValue.compare(blackValue)>0)
        {
            return "White wins - "+whiteValue;
        }
        else if (whiteValue.compare(blackValue)<0)
        {
            return "Black wins - "+blackValue;
        }
        else if (compareHighestCards(white,black)>0)
        {
            return "White wins -"+whiteValue+" with higher card";
        }
        else if(compareHighestCards(white,black)<0)
        {
            return "Black wins -"+blackValue+" with higher card";
        }
        else return "TIE";

    }

    /**
     * @param args standard main singature
     *  does nothing, just for compilation purposes
     */
    public static void main(String[] args) {
        /*
         * I do nothing
         */
    }

    private static Map<String,Long> countHand(List<String> hand)
    {
        List<String> checkMe = stripColors(hand);

        return checkMe.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    private static List<String> stripColors(List<String> oldList)
    {
        List<String> newList= new ArrayList<>();
        for (String s : oldList)
        {
            newList.add(((Character)s.charAt(0)).toString());
        }
        return newList;
    }

    private static Hand checkHand(List<String> hand)
    {
        Hand h;
        h = checkMultiple(hand);
        if (h!=null)
        {
            return h;
        }

        h = checkStraightAndFlush(hand);
        if (h!=null)
        {
            return h;
        }

         Card card = findHighestCard(hand);
        return new HighCard(card);
    }

    private static Card findHighestCard(List<String> hand)
    {
        hand.sort(new CardComparator());
        Collections.reverse(hand);

        return CardMap.getMap().get(String.valueOf(hand.get(0).charAt(0)));
    }

    private static int compareHighestCards(List<String> white, List<String> black)
    {
        return findHighestCard(white).ordinal()-findHighestCard(black).ordinal();
    }

    private static boolean isStraight(List<String> hand)
    {
        boolean result = true;
        int i=CardMap.getMap().get(String.valueOf(hand.get(0).charAt(0))).ordinal();
        for (int j=1;j<5;j++,i++)
        {
            if (CardMap.getMap().get(String.valueOf(hand.get(j).charAt(0))).ordinal()!=i+1)
            {
                result=false;
            }
        }
        return result;
    }

    private static boolean isFlush(List<String> hand)
    {
        boolean result = true;
        char c = hand.get(0).charAt(1);
        for (String s : hand)
        {
            if (s.charAt(1)!=c)
            {
                result=false;
            }
        }
        return result;
    }

    private static Hand checkMultiple(List<String> hand)
    {
        Map<String,Long> cardCount = countHand(hand);

        Map<String,Long> multipleCounts = cardCount.entrySet().stream().filter(map->map.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (multipleCounts.size()==1)
        {
            return checkSingleMultiple(multipleCounts);

        }
        else if (multipleCounts.size()==2)
        {
            return checkDoubleMultiple(multipleCounts);
        }

        return null;
    }

    private static Hand checkSingleMultiple(Map<String, Long> multipleCounts)
    {
        if (multipleCounts.containsValue(2L))
        {
            Card card= CardMap.getMap().get(multipleCounts.entrySet().stream().findFirst().get().getKey());
            return new Pair(card);
        }
        else if (multipleCounts.containsValue(3L))
        {
            Card card= CardMap.getMap().get(multipleCounts.entrySet().stream().findFirst().get().getKey());
            return new ThreeOfAKind(card);
        }
        else
        {
            Card card= CardMap.getMap().get(multipleCounts.entrySet().stream().findFirst().get().getKey());
            return new FourOfAKind(card);
        }

    }

    private static Hand checkDoubleMultiple(Map<String, Long> multipleCounts)
    {
        if (multipleCounts.containsValue(3L))
        {
            Object[] keys = multipleCounts.keySet().toArray();
            Card card1= CardMap.getMap().get(keys[0]);
            Card card2= CardMap.getMap().get(keys[1]);
            return new FullHouse(card2,card1);
        }
        else
        {
            Object[] keys = multipleCounts.keySet().toArray();
            Card card1= CardMap.getMap().get(keys[0]);
            Card card2= CardMap.getMap().get(keys[1]);
            return new TwoPairs(card1,card2);
        }
    }

    private static Hand checkStraightAndFlush(List<String> hand)
    {
        if (isStraight(hand))
        {
            if (isFlush(hand))
            {
                Card card = findHighestCard(hand);
                return new StraightFlush(card);
            }

            Card card = findHighestCard(hand);
            return new Straight(card);
        }

        if (isFlush(hand))
        {
            Card card = findHighestCard(hand);
            return new Flush(card);
        }

        return null;
    }
}
