package com.nerosmith.java.Stacks_and_Queues.Array_Stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
