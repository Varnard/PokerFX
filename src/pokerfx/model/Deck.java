package pokerfx.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Deck {

    private static List<String> deck;

    public static void shuffleDeck()
    {
        deck = new ArrayList<>();

        char[] values = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
        char[] colors = {'H','S','D','C'};

        for (char v : values)
        {
            for (char c : colors)
            {
                deck.add(Character.toString(v)+c);
            }
        }
    }

    public static String giveOne()
    {
        return deck.remove(new Random().nextInt(deck.size()-1));
    }

    public static String giveFive()
    {
        StringJoiner sj= new StringJoiner(" ");

        for (int i=0;i<5;i++)
        {
            sj.add(deck.remove(new Random().nextInt(deck.size()-1)));
        }
        return sj.toString();
    }


}
