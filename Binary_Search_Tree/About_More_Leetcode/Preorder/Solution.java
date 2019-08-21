package com.nerosmith.java.Binary_Search_Tree.About_More_Leetcode.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if(root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()){
                    TreeNode curNode = stack.pop();
                    res.add(curNode.val);

                    if (curNode.right != null)
                        stack.push(curNode.right);
                    if (curNode.left != null)
                        stack.push(curNode.left);
                }
            return res;
        }
}
