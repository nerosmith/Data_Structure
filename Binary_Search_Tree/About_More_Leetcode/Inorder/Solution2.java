package com.nerosmith.java.Binary_Search_Tree.About_More_Leetcode.Inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<Integer>();
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            while (cur != null || !stack.empty()){
                    if (cur != null){
                            stack.push(cur);
                            cur = cur.left;
                        }
                    else{
                        cur = stack.pop();
                        res.add(cur.val);
                        cur = cur.right;
                     }
                }
            return res;
        }
}
