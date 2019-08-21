package com.nerosmith.java.AVL_Tree.The_Implementation_of_Left_Rotation_and_Right_Rotation;

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

       public boolean isBST(){
                 ArrayList<K> keys = new ArrayList<>();
                 inOrder(root,keys);
                 for (int i = 1; i < keys.size(); i++)
                     if (keys.get(i-1).compareTo(keys.get(i)) > 0)
                         return false;
                 return true;
            }


       private void inOrder(Node node, ArrayList<K> keys) {
                if (node == null)
                    return;

                inOrder(node.left,keys);
                keys.add(node.key);
                inOrder(node.right,keys);
           }


        // 判斷該二叉樹是否是一棵平衡二叉樹
       public boolean isBalanced(){
               return isBalanced(root);
          }

       // 判斷以No​​de為根的二叉樹是否是一棵平衡二叉樹，遞歸算法
       private boolean isBalanced(Node node) {
               if (node == null)
                   return true;

               int balanceFactor = getBalanceFactor(node);
               if (Math.abs(balanceFactor) > 1)
                   return false;
               return isBalanced(node.left) && isBalanced(node.right);
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

       // 對節點y進行向右旋轉操作，返迴旋轉後新的根節點 x
       //        y                              x
       //       / \                           /   \
       //      x   T4     向右旋轉 (y)        z     y
       //     / \       - - - - - - - ->    / \   / \
       //    z   T3                       T1  T2 T3 T4
       //   / \
       // T1   T2
       private Node rightRotate(Node y){
                Node x = y.left;
                Node T3 = x.right;

                // 向右旋轉過程
                x.right = y;
                y.left = T3;

                // 更新height
                y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
                x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

                return x;
            }

       // 對節點y進行向左旋轉操作，返迴旋轉後新的根節點 x
       //    y                             x
       //  /  \                          /   \
       // T1   x     向左旋轉 (y)       y     z
       //     / \   - - - - - - - ->   / \   / \
       //   T2  z                     T1 T2 T3 T4
       //      / \
       //     T3 T4
       private Node leftRotate(Node y){
                Node x  = y.right;
                Node T2 = x.left;

                // 向左旋轉過程
                x.left = y;
                y.right = T2;

                // 更新height
                y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
                x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

                return x;
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

                // 平衡維護
                if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
                    return rightRotate(node);
                if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
                    return leftRotate(node);

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
