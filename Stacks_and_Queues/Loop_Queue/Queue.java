package com.nerosmith.java.Stacks_and_Queues.Loop_Queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
