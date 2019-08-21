package com.nerosmith.java.Set_and_Map.BSTMap;
import java.util.ArrayList;

// Leetcode 350. Intersection of Two Arrays II
public class Solution {
    public int[] intersect(int[] nums1,int[] num2){
            BSTMap<Integer,Integer> map = new BSTMap<>();
            for (int num : nums1){
                    if (!map.contains(num))
                        map.add(num,1);
                    else
                        map.set(num,map.get(num)+1);
                }

            ArrayList<Integer> res = new ArrayList<>();
            for (int num : num2){
                    if (map.contains(num)){
                            res.add(num);
                            map.set(num,map.get(num)-1);
                            if (map.get(num) == 0)
                                map.remove(num);
                        }
                }

            int[] ret = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ret[i] = res.get(i);
            return ret;
        }
}
