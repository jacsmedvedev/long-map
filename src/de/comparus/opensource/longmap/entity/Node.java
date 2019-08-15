package de.comparus.opensource.longmap.entity;

import java.util.Objects;

/**
 * Created by medvedevyakov on 2019-07-29.
 */
public class Node<V> {

    private int hash;
    private long key;
    private V value;
    private Node<V> next;

    public Node() {
    }

    public Node(int hash, long key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Node(long key, V value, Node<V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(int hash, long key, V value, Node<V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public long getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return hash == node.hash &&
                key == node.key &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, key, value);
    }

    @Override
    public String toString() {
        return "Node -- " +
                "hash=" + hash +
                ", key=" + key +
                ", value=" + value +
                ", next=" + next +
                '.';
    }
}
