package com.nerosmith.java.Linked_List.Implement_Queue_in_LinkedList;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
