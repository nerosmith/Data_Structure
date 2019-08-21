package com.nerosmith.java.Trie.Add_Delete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet_HashMap {

    HashMap<String,Integer> map;
    ArrayList<Integer>  nums;

    public RandomizedSet_HashMap(){
            map = new HashMap();
            nums = new ArrayList<>();
        }

    public boolean insert(int val){
            String key = Integer.toString(val);
            if (map.containsKey(key))
                return false;

            nums.add(val);
            int index = nums.size()-1;
            map.put(key,index);
            return true;
        }

    public boolean remove(int val){
            String key = Integer.toString(val);
            if (!map.containsKey(key))
                return false;

            int index = map.get(key);
            map.remove(key);

            int num = nums.get(nums.size()-1);
            nums.remove(nums.size()-1);

            if (num != val){
                    nums.set(index,num);
                    map.put(Integer.toString(num),index);
                }
            return true;
        }

    public int getRamdom(){
            Random random = new Random();
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }

}
