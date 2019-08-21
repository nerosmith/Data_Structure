package com.nerosmith.java.Recursion.Recursive_LinkedList;

public class LinkedListRStack<E> implements Stack<E>{

    private LinkedListR<E> list;

    public LinkedListRStack(){
            list = new LinkedListR<>();
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
    public void push(E e) {
            list.addFirst(e);
        }

    @Override
    public E pop() {
            return list.removeFirst();
        }

    @Override
    public E peek() {
            return list.getFirst();
        }

    @Override
    public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("Stack: top ");
            res.append(list);
            return res.toString();
        }
}
