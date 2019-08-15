package de.comparus.opensource.longmap.entity;

import java.util.Objects;


/**
 * Created by medvedevyakov on 2019-07-29.
 */
public class Node<V> {

    private long key;
    private V value;
    private Node<V> next;

    public Node() {
    }

    public Node(long key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node(long key, V value, Node<V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
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
        return key == node.key &&
                value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
