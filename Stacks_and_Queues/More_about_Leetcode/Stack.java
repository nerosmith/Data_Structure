package com.nerosmith.java.Stacks_and_Queues.More_about_Leetcode;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
