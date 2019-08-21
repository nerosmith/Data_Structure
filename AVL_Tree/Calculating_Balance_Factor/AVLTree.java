package com.nerosmith.java.AVL_Tree.Calculating_Balance_Factor;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>,V> {
       private class Node{
                public K key;
                public V value;
                public Node left,right;
                public int height;

                public Node(K key,V value){
                        this.key = key;
                        this.value = value;
                        left = null;
                        right = null;
                        height = 1;
                    }
            }

       private Node root;
       private int size;

       public AVLTree(){
                   root = null;
                   size = 0;
            }

       public int getSize(){
                return size;
            }

       public boolean isEmpty(){
                return size == 0;
            }

       // 獲得節點node的高度
       private int getHeight(Node node){
                if (node == null)
                    return 0;
                return node.height;
            }

       // 獲得節點node的平衡因子
       private int getBalanceFactor(Node node){
               if (node == null)
                   return 0;
               return getHeight(node.left) - getHeight(node.right);
            }

       // 向二分搜索樹中添加新的元素(key, value)
       public void add(K key,V value){
                root = add(root,key,value);
            }

       private Node add(Node node, K key, V value) {

                if (node == null){
                        size++;
                        return new Node(key,value);
                    }

                if (key.compareTo(node.key) < 0)
                    node.left = add(node.left,key,value);
                else if (key.compareTo(node.key) > 0)
                    node.right = add(node.right,key,value);
                else
                    node.value = value;

                // 更新height
                node.height = 1 + Math.max(getHeight(node.left),getBalanceFactor(node.right));

                //計算平衡因子
                int balanceFactor = getBalanceFactor(node);
                if (Math.abs(balanceFactor) > 1)
                    System.out.println("unbalanced : " + balanceFactor);

                return node;
           }

       // 返回以node為根節點的二分搜索樹中，key所在的節點
       private Node getNode(Node node, K key){
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
                if(node.left == null){
                        Node rightNode = node.right;
                        node.right = null;
                        size--;
                        return rightNode;
                    }

                node.left =removeMin(node.left);
                return node;
           }

       public V remove(K key){
               Node node = getNode(root,key);
               if (node != null){
                        root = remove(root,key);
                        return node.value;
                    }
               return null;
          }

       private Node remove(Node node,K key){
                if (node == null)
                    return null;

                if (key.compareTo(node.key) < 0){
                        node.left = remove(node.left,key);
                        return node;
                    }
                else if (key.compareTo(node.key) > 0){
                        node.right = remove(node.right,key);
                        return node;
                    }
                else {

                        // 待刪除節點左子樹空的的情況
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
