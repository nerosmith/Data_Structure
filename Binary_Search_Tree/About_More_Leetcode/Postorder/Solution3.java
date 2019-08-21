package com.nerosmith.java.Binary_Search_Tree.About_More_Leetcode.Postorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            LinkedList<TreeNode> output = new LinkedList<>();

            TreeNode cur = root;

            while (cur != null || stack.isEmpty()){
                    if (cur != null){
                            stack.push(cur);
                            output.add(cur);
                            cur = cur.right;
                        }
                    else {
                        cur = stack.pop();
                        cur = cur.left;
                      }
                }

            ArrayList<Integer> res = new ArrayList<>();
            while (!output.isEmpty())
                res.add(output.pop().val);
            return res;
       }
}
