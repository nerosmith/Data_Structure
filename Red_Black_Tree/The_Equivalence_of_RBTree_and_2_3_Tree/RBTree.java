package com.nerosmith.java.Red_Black_Tree.The_Equivalence_of_RBTree_and_2_3_Tree;

public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
            public K key;
            public V value;
            public Node left,right;
            public boolean color;

            public Node(K key,V value){
                    this.key = key;
                    this.value = value;
                    left = null;
                    right = null;
                    color = RED;
                }
        }

    private Node root;
    private int size;

    public RBTree(){
            root = null;
            size = 0;
        }

    private int getSize(){
            return size;
        }

    // 判斷節點node的顏色
    private boolean isRed(Node node){
            if (node == null)
                return BLACK;
            return node.color;
        }

    // 向二分搜索樹中添加新的元素(key, value)
    public void add(K key,V value){
            root = add(root,key,value);
        }

    // 向以node為根的二分搜索樹中插入元素(key, value)，遞歸算法
    // 返回插入新節點後二分搜索樹的根
    private Node add(Node node, K key, V value) {
            if (node == null)
                return null;
            if (key.equals(node.key))
                return node;
            else if (key.compareTo(node.key) < 0)
                return getNode(node.left,key);
            else
                return getNode(node.right,key);
        }

    private Node getNode(Node node, K key) {

            if (node == null)
                return null;

            if (key.equals(node.key))
                return node;
            else if (key.compareTo(node.key) < 0)
                return getNode(node.left,key);
            else
                return getNode(node.right,key);
        }

    public boolean contains(K key){
            return getNode(root,key) != null;
        }

    public V get(K key){
            Node node = getNode(root,key);
            return node == null ? null : node.value;
        }

    public void set(K key,V newValue){
            Node node = getNode(root,key);
            if (node == null)
                throw new IllegalArgumentException(key + " doesn't exist!");

            node.value = newValue;
        }

    // 返回以node為根的二分搜索樹的最小值所在的節點
    private Node minimum(Node node){

            if (node.left == null)
                return node;
            return minimum(node.left);
        }

    // 刪除掉以node為根的二分搜索樹中的最小節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMin(Node node){

            if (node.left == null){
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;
                }

            node.left = removeMin(node.left);
            return node;
        }

    // 從二分搜索樹中刪除鍵為key的節點
    public V remove(K key){
            Node node = getNode(root,key);
            if (node != null){
                    root = remove(root,key);
                    return node.value;
                }
            return null;
        }

    private Node remove(Node node, K key) {

            if (node == null)
                return null;

            if (key.compareTo(node.key) < 0){
                    node.left = remove(node.left,key);
                    return node;
                }
            else if (key.compareTo(node.key) > 0){
                    node.left = remove(node.right,key);
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
                 Node successor = minimum(node.right);
                 successor.right = removeMin(node.right);
                 successor.left = node.left;

                 node.left = node.right = null;

                 return successor;

               }
        }


}
