package com.nerosmith.java.Linked_List.Linked_List_Basics;

public class LinkedList<E> {

    private class Node{
            public E e;
            public Node next;

            public Node(E e,Node next){
                    this.e = e;
                    this.next = next;
                }

            public Node(E e){
                    this(e,null);
                }

            public Node(){
                    this(null,null);
                }

            @Override
            public String toString() {
                return super.toString();
            }
    }
}
