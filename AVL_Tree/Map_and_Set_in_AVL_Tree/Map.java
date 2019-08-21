package com.nerosmith.java.AVL_Tree.Map_and_Set_in_AVL_Tree;

public interface Map<K,V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
