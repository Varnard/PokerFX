package pokerfx.verdict.hands;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by buzalskim on 2016-07-06.
 *
 */
public class CardMap {
    
    private static Map<String,Card> map;
    
    private CardMap(){}
    
    public static Map<String,Card> getMap()
    {
        if (map==null)
        {
            map = new HashMap<>();
            map.put("2",Card.Two);
            map.put("3",Card.Three);
            map.put("4",Card.Four);
            map.put("5",Card.Five);
            map.put("6",Card.Six);
            map.put("7",Card.Seven);
            map.put("8",Card.Eight);
            map.put("9",Card.Nine);
            map.put("T",Card.Ten);
            map.put("J",Card.Jack);
            map.put("Q",Card.Queen);
            map.put("K",Card.King);
            map.put("A",Card.Ace);
        }
        return map;
    }
    
    
}
