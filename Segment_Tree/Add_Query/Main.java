package com.nerosmith.java.Segment_Tree.Add_Query;

public class Main {
    public static void main(String[] args) {
        Integer[] nums ={0,1,2};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b) -> a+b);
        System.out.println(segTree);

        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(1,2));

    }
}
