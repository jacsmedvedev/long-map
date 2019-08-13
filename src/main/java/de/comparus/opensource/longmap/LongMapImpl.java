package de.comparus.opensource.longmap;

public class LongMapImpl<V> implements LongMap<V> {

    private int size = 0;
    private final int DEFAULT_MAP_SIZE = 16;
    private float LOAD_FACTOR = 0.75f;
    private int sizeWhenMapShouldDouble;
    private Node[] buckets;

    public LongMapImpl() {
        buckets = new Node[DEFAULT_MAP_SIZE];
        sizeWhenMapShouldDouble = (int)(DEFAULT_MAP_SIZE * LOAD_FACTOR);
    }

    public LongMapImpl(int initSize) {
        buckets = new Node[initSize];
        sizeWhenMapShouldDouble = (int)(initSize * LOAD_FACTOR);
    }

    public V put(long key, V value) {
        Node newNode = new Node(key,value);
        int index = newNode.hashCode() & (buckets.length - 1);
        buckets[index] = newNode;
        size++;
        if (size == sizeWhenMapShouldDouble) resize();
        return (V) newNode.getValue();
    }

    public V get(long key) {
        for (Node n : buckets) {
            if (n.getKey() == key) return (V) n.getValue();
        }
        return null;
    }


    public V remove(long key) {
        V rez;
        if (containsKey(key)){
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null && buckets[i].getKey() == key){
                    rez = (V) buckets[i].getValue();
                    buckets[i] = null;
                    size--;
                    return rez;
                }
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(long key) {
        for (Node n : buckets) {
            if (n != null && n.getKey() == key) return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node n : buckets) {
            if (n != null && n.getValue() == value) return true;
        }
        return false;
    }

    public long[] keys() {
        long[] rez = new long[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) rez[i] = buckets[i].getKey();
        }
        return rez;
    }

    public V[] values() {
        Object[] rez = new Object [buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) rez[i] = buckets[i].getValue();
        }
        return (V[]) rez;
    }

    public long size() {
        return size;
    }

    public void clear() {
        int oldLength = buckets.length;
        buckets = new Node[oldLength];
        size = 0;
    }

    private void resize(){
        Node[] newbuckets = new Node[buckets.length * 2];
        size = 0;
        for (Node n : buckets ) {
            if (n == null) continue;
            int index = n.hashCode() & (newbuckets.length - 1);
            newbuckets[index] = n;
            size++;
        }
        buckets = newbuckets;
        sizeWhenMapShouldDouble = (int)(buckets.length * LOAD_FACTOR);
    }
}
