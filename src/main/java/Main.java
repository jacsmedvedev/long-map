import de.comparus.opensource.longmap.LongMapImpl;
import de.comparus.opensource.longmap.Node;

import java.util.Arrays;
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
        longMap.put(22, "hsdjkfhjksdnf");
        longMap.put(4678, new Object());
        System.out.println(Arrays.asList(longMap.values()).toString());
//        System.out.println(longMap.size());
//
//        longMap.clear();
//        System.out.println(longMap.get(444));

    }
}
