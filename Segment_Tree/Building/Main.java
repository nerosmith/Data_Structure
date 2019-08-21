package com.nerosmith.java.Segment_Tree.Building;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {0,1,2};
//        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
//                @Override
//                public Integer merger(Integer a, Integer b) {
//                    return a+b;
//                }
//            });

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b) -> a+b);
        System.out.println(segTree);
    }
}
