package com.nerosmith.java.Trie.Add_Searching;

import java.util.LinkedList;
import java.util.Queue;

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

    // 二分搜索樹的前序遍歷
    public void preOrder(){
            preOrder(root);
        }

    // 前序遍歷以node為根的二分搜索樹, 遞歸算法
    private void preOrder(Node node) {
            if (node == null)
                return;

            System.out.print(node.e+" ");
            preOrder(node.left);
            preOrder(node.right);
        }

    // 二分搜索樹的中序遍歷
    public void inOrder(){
            inOrder(root);
        }

    // 中序遍歷以node為根的二分搜索樹, 遞歸算法
    private void inOrder(Node node) {
            if (node == null)
                return;
            inOrder(node.left);
            System.out.print(node.e+" ");
            inOrder(node.right);
        }

    // 二分搜索樹的後序遍歷
    public void postOrder(){
            postOrder(root);
        }

    // 後序遍歷以node為根的二分搜索樹, 遞歸算法
    private void postOrder(Node node) {
            if (node == null)
                return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.e+" ");
        }

    // 二分搜索樹的層序遍歷
    public void levelOrder(){
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                    Node cur = q.remove();
                    System.out.print(cur.e+" ");

                    if (cur.left != null)
                        q.add(cur.left);
                    if (cur.right != null)
                        q.add(cur.right);
                }
        }

    // 尋找二分搜索樹的最小元素
    public E mininum(){
            if (size == 0)
                throw new IllegalArgumentException("BST is empty");
            return  mininum(root).e;
        }

    // 返回以node為根的二分搜索樹的最小值所在的節點
    private Node mininum(Node node) {
            if (node.left == null)
                return node;
            return mininum(node.left);
        }

    // 尋找二分搜索樹的最大元素
    public E maxinum(){
            if (size == 0)
                throw new IllegalArgumentException("BST is empty");
            return  maxinum(root).e;
        }

    // 返回以node為根的二分搜索樹的最大值所在的節點
    private Node maxinum(Node node) {
            if (node.right == null)
                return node;
            return maxinum(node.right);
        }

    // 從二分搜索樹中刪除最小值所在節點, 返回最小值
    public E removeMin(){
            E ret = mininum();
            root = removeMin(root);
            return ret;
        }

    // 刪除掉以node為根的二分搜索樹中的最小節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMin(Node node) {
            if (node.left == null){
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;
                }
            node.left = removeMin(node.left);
            return node;
        }

    public E removeMax(){
            E ret = maxinum();
            root = removeMax(root);
            return ret;
        }

    // 刪除掉以node為根的二分搜索樹中的最大節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMax(Node node) {
            if (node.right == null){
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    return leftNode;
                }
            node.right = removeMax(node.right);
            return node;
        }

    // 從二分搜索樹中刪除元素為e的節點
    public void remove(E e){
            root = remove(root,e);
        }


    // 刪除掉以node為根的二分搜索樹中值為e的節點, 遞歸算法
    // 返回刪除節點後新的二分搜索樹的根
    private Node remove(Node node, E e) {
            if (node == null)
                return null;

            if (e.compareTo(node.e) < 0){
                    node.left = remove(node.left,e);
                    return node;
                }
            else if (e.compareTo(node.e) > 0){
                    node.right = remove(node.right,e);
                    return node;
                }
            else {
                    // 待刪除節點左子樹為空的情況
                    if (node.left == null){
                            Node rightNode = node.right;
                            node.right = null;
                            size--;
                            return rightNode;
                        }

                    // 待刪除節點右子樹為空的情況
                    if (node.right == null){
                            Node leftNode = node.left;
                            node.left = null;
                            size--;
                            return leftNode;
                        }

                    // 待刪除節點左右子樹均不為空的情況
                    // 找到比待刪除節點大的最小節點, 即待刪除節點右子樹的最小節點
                    // 用這個節點頂替待刪除節點的位置
                    Node successor = mininum(node.right);
                    successor.right = removeMin(node.right);
                    successor.left = node.left;

                    node.left = node.right = null;

                    return successor;
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
