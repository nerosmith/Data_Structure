package com.nerosmith.java.Binary_Search_Tree.About_More_Leetcode.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root){
           ArrayList<Integer> res = new ArrayList<>();
           if(root == null)
              return res;

           Stack<TreeNode> stack = new Stack<>();
           TreeNode cur = root;
           while (cur != null||!stack.empty()){
                 if (cur != null){
                        res.add(cur.val);
                        stack.push(cur);
                        cur = cur.left;
                    }
                 else {
                        cur = stack.pop();
                        cur = cur.right;
                   }
              }
           return res;
        }
}
