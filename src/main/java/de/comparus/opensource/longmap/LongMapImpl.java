package de.comparus.opensource.longmap;

public class LongMapImpl<V> implements LongMap<V> {

    long[] mapSize;

    public LongMapImpl() {
        mapSize = new long[16];
    }

    public LongMapImpl(int initSize) {
        mapSize = new long[initSize];
    }

    public V put(long key, V value) {
        return null;
    }

    public V get(long key) {
        return null;
    }

    public V remove(long key) {
        return null;
    }

    public boolean isEmpty() {
        return false;
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
        return 0;
    }

    public void clear() {

    }
}
