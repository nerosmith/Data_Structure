package com.nerosmith.java.Segment_Tree.Problems_in_Leetcode;

// 303. Range Sum Query - Immutable
public class NumArray2 {

    private int[] sum; //sum[i] 存儲前 i 個元素和，sum[0] = 0
                       // 即sum[i] 存儲 nums[0...i-1] 的和
                       // sum(i, j) = sum[j + 1] - sum[i]

    public NumArray2(int[] nums){
            sum = new int[nums.length+1];
            sum[0] = 0;
            for (int i = 1; i < sum.length ;i++)
                sum[i] = sum[i-1]+nums[i-1];
        }

    public int sumRange(int i,int j){
            return sum[j+1] - sum[i];
        }
}
