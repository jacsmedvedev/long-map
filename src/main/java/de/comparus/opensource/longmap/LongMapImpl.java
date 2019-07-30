package de.comparus.opensource.longmap;

public class LongMapImpl<V> implements LongMap<V> {

    private int size = 0;
    private int DEFAULT_MAP_SIZE = 16;
    private Node[] buckets;

    public LongMapImpl() {
        buckets = new Node[DEFAULT_MAP_SIZE];
    }

    public LongMapImpl(int initSize) {
        buckets = new Node[initSize];
    }

    public V put(long key, V value) {
        Node newNode = new Node(key,value);
        int index = newNode.hashCode() & (buckets.length - 1);
        buckets[index] = newNode;
        countSize();
        return (V) newNode.getValue();
    }

    public V get(long key) {
        for (Node n : buckets) {
            if (n != null){
                if (n.getKey() == key) return (V) n.getValue();
            }
        }
        return null;
    }

//    public void getK() {
//        for (Node n : buckets) {
//            if (n!=null)System.out.println(n.toString());
////            if (n != null && n.getKey() == key) return (V) n.getValue();
//        }
//    }

    public V remove(long key) {
        countSize();
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(long key) {
        return false;
    }

    public boolean containsValue(V value) {
        return false;
    }

    public long[] keys() {
        return null;
    }

    public V[] values() {
        return null;
    }

    public long size() {
        return size;
    }

    public void clear() {
        int oldLength = buckets.length;
        buckets = new Node[oldLength];
        countSize();
    }

    private void countSize(){
        size = 0;
        for (Node n : buckets) if (n!=null) size++;
    }
}
