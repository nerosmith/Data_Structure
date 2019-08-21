package com.nerosmith.java.Trie.Add_Prefix;

public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
