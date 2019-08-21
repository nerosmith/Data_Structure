package com.nerosmith.java.Set_and_Map.LinkedListSet;

public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
