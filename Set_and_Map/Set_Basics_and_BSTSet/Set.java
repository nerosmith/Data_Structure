package com.nerosmith.java.Set_and_Map.Set_Basics_and_BSTSet;

public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
