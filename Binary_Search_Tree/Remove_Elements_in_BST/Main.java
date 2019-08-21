package com.nerosmith.java.Binary_Search_Tree.Remove_Elements_in_BST;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
            BST<Integer> bst = new BST<>();
            Random random = new Random();

            int n = 10000;

            for (int i = 0; i < n; i++)
                bst.add(random.nextInt(n));

            Integer[] order = new Integer[n];
            for (int i = 0 ; i < n ; i ++)
                order[i] = i;
            // 打亂order數組的順序
            shuffle(order);

            // 亂數刪除[0...n)範圍裡的所有元素
            for (int i = 0; i < n; i++) {
                  if (bst.contains(order[i]))
                        bst.remove(order[i]);
                  System.out.println("After remove " + order[i] + ", size = " + bst.size());
                }

            System.out.println(bst.size());
         }

    // 打亂數組順序
   private static void shuffle(Object[] arr) {
            for (int i = arr.length-1; i >= 0 ; i--) {
                    int pos = (int)(Math.random()*(i+1));
                    Object t = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = t;
                }
        }

}
