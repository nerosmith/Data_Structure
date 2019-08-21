package com.nerosmith.java.AVL_Tree.Map_and_Set_in_AVL_Tree;

public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
