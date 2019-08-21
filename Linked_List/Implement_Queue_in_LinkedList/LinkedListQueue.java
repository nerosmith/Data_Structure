package com.nerosmith.java.Linked_List.Implement_Queue_in_LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list;

    public LinkedListQueue(){
        list = new LinkedList();
        }

    @Override
    public int getSize() {
            return list.getSize();
        }

    @Override
    public boolean isEmpty() {
            return list.isEmpty();
        }

    @Override
    public void enqueue(E e) {
           list.addLast(e);
        }

    @Override
    public E dequeue() {
            return list.removeFirst();
        }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return list.getFirst();
      }

    @Override
    public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("Queue: front ");
            res.append(list);
            res.append(" tail");
            return res.toString();
        }

}
