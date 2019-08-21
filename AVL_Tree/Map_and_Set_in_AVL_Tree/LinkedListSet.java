package com.nerosmith.java.AVL_Tree.Map_and_Set_in_AVL_Tree;

public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E,Object> list;

    public LinkedListSet(){
            list = new LinkedList<>();
        }

    @Override
    public void add(E e) {
            list.add(e,null);
        }

    @Override
    public boolean contains(E e) {
            return list.contains(e);
        }

    @Override
    public void remove(E e) {
            list.remove(e);
        }

    @Override
    public int getSize() {
            return list.getSize();
        }

    @Override
    public boolean isEmpty() {
            return list.isEmpty();
        }
}
