package com.nerosmith.java.Binary_Search_Tree.About_More_Leetcode.Postorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<Integer>();
            if(root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> output = new Stack<>();

            stack.push(root);

            while (!stack.empty()){
                    TreeNode cur = stack.pop();
                    output.push(cur.val);

                    if (cur.left != null)
                        stack.push(cur.left);
                    else
                        stack.push(cur.right);
                }

            while (!output.empty())
                res.add(output.pop());

            return res;
        }
}
