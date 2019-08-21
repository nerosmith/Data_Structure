package com.nerosmith.java.Heap_and_Queue.Priority_Queue_in_Leetcode;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
