import de.comparus.opensource.longmap.LongMapImpl;
import de.comparus.opensource.longmap.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by medvedevyakov on 2019-07-29.
 */
public class Main {
    public static void main(String[] args) {

        Map<String ,String> m = new HashMap<>();
//        long[] mapSize = new long[16];
//
//        System.out.println(mapSize[4]);
//        Node[] mapSize = new Node[16];

        LongMapImpl longMap = new LongMapImpl(55);
        longMap.put(444, new Node<>(777, "FFFFFFFFFf"));
        System.out.println(longMap.get(444));
        longMap.put(22, new Node<>(777, 55555));
    }
}
