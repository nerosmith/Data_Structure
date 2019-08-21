package com.nerosmith.java.Heap_and_Queue.Priority_Queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
