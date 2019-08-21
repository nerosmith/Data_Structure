package com.nerosmith.java.Linked_List.Implement_Stack_in_LinkedList;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
