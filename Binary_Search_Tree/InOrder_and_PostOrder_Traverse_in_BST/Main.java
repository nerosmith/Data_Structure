package com.nerosmith.java.Binary_Search_Tree.InOrder_and_PostOrder_Traverse_in_BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

            /////////////////
            //      5      //
            //    /   \    //
            //   3    6    //
            //  / \    \   //
            // 2  4     8  //
            /////////////////
        bst.preOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
    }
}
