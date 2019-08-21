package com.nerosmith.java.Binary_Search_Tree.Improved_Add_Elements_in_BST;

public class BST<E extends Comparable<E>> {

    private class Node{
            public E e;
            public Node left,right;

            public Node(E e){
                    this.e = e;
                    left = null;
                    right = null;
                }
        }

    private Node root;
    private int size;

    public BST(){
            root = null;
            size = 0;
        }

    public int size(){
            return size;
        }

    public boolean isEmpty(){
            return size == 0;
        }

    // 向二分搜索樹中添加新的元素 e
    public void add(E e){
           root = add(root,e);
        }

    // 向以node為根的二分搜索樹中插入元素e，遞歸算法
    private Node add(Node node,E e){
           if (node == null){
                    size++;
                    return new Node(e);
                }
           if (e.compareTo(node.e) < 0)
               node.left = add(node.left,e);
           else if (e.compareTo(node.e) > 0)
               node.right = add(node.right,e);
           return node;
        }

}
