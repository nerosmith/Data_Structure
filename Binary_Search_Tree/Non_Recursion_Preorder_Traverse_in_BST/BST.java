package com.nerosmith.java.Binary_Search_Tree.Non_Recursion_Preorder_Traverse_in_BST;

import java.util.Stack;

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
    // 返回插入新節點後二分搜索樹的根
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

    // 看二分搜索樹中是否包含元素 e
    public boolean  contains(E e){
            return contains(root,e);
        }

    // 看以node為根的二分搜索樹中是否包含元素e, 遞歸算法
    private boolean contains(Node node, E e) {
            if (node == null)
                return false;

            if (e.compareTo(node.e) == 0)
                return true;
            else if (e.compareTo(node.e) < 0)
                return contains(node.left,e);
            else
                return contains(node.right,e);
        }

    // 二分搜索樹的非遞歸前序遍歷
    public void preOrderNR() {
            if (root == null)
                return;
            Stack<Node> stack = new Stack();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.print(cur.e+" ");

                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }

    // 二分搜索樹的非遞歸中序遍歷
    public void inOrderNR(){
            if (root == null)
                return;
            Stack<Node> stack = new Stack();
            Node cur = root;
            while (cur != null || !stack.isEmpty()){
                    while (cur != null){
                            stack.push(cur);
                            cur = cur.left;
                        }
                    cur = stack.pop();
                    System.out.print(cur.e+" ");
                    cur = cur.right;
               }
         }

    // 二分搜索樹的非遞歸後序遍歷
    public void postOrderNR(){
            if (root == null)
                return;
            Stack<Node> stack = new Stack();
            stack.push(root);
            Node cur,pre = null;
            while (!stack.isEmpty()){
                    cur = stack.peek();
                    if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))){
                            Node temp = stack.pop();
                            System.out.print(temp.e+" ");
                            pre = temp;
                        }
                    else {
                          if (cur.right != null)
                             stack.push(cur.right);
                          if (cur.left != null)
                             stack.push(cur.left);
                        }
                }
        }

    @Override
    public String toString() {
            StringBuilder res = new StringBuilder();
            generateBSTString(root, 0, res);
            return res.toString();
        }

    // 生成以node為根節點，深度為depth的描述二叉樹的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
            if (node == null){
                    res.append(generateBSTString(depth)+"null\n");
                    return;
                }
            res.append(generateBSTString(depth)+node.e+"\n");
            generateBSTString(node.left,depth+1,res);
            generateBSTString(node.right,depth+1,res);
        }

    private String generateBSTString(int depth) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < depth; i++)
                res.append("--");
            return res.toString();
        }
}
