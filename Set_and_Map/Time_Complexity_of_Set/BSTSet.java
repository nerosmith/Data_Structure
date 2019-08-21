package com.nerosmith.java.Set_and_Map.Time_Complexity_of_Set;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
            bst = new BST<>();
        }

    @Override
    public void add(E e) {
            bst.add(e);
        }

    @Override
    public boolean contains(E e) {
            return bst.contains(e);
        }

    @Override
    public void remove(E e) {
            bst.remove(e);
        }

    @Override
    public int getSize() {
            return bst.size();
        }

    @Override
    public boolean isEmpty() {
            return bst.isEmpty();
        }
}
