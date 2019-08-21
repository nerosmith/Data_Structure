package com.nerosmith.java.AVL_Tree.Map_and_Set_in_AVL_Tree;

public class BSTSet <E extends Comparable<E>> implements Set<E>{

    private BST<E,Object> bst;

    public BSTSet(){
            bst = new BST<>();
        }

    @Override
    public void add(E e) {
            bst.add(e,null);
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
            return bst.getSize();
        }

    @Override
    public boolean isEmpty() {
            return bst.isEmpty();
        }
}
