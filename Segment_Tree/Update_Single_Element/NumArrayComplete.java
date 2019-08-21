package com.nerosmith.java.Segment_Tree.Update_Single_Element;

// 303. Range Sum Query

public class NumArrayComplete {
    private SegmentTree<Integer> segmentTree;

    public NumArrayComplete(int[] nums){
            if (nums.length > 0){
                    Integer[] data = new Integer[nums.length];
                    for (int i = 0; i < nums.length; i++)
                        data[i] = nums[i];
                    segmentTree = new SegmentTree<>(data,(a, b)-> a + b);
                }
        }

    public int sumRange(int i,int j){
            if(segmentTree == null)
                throw new IllegalArgumentException("Segment Tree is null");

                return segmentTree.query(i,j);
        }

   public void update(int i,int j){
           if(segmentTree == null)
               throw new IllegalArgumentException("Error");
           segmentTree.set(i,j);
        }
}
