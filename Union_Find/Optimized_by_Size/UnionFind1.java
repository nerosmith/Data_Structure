package com.nerosmith.java.Union_Find.Optimized_by_Size;

// Leetcode 547. Friend Circles

public class UnionFind1 implements UF {

    private int[] id; // 第一版 Union-Find 本質就是一個數組

    public UnionFind1(int size){
            id = new int[size];

            for (int i = 0; i < size; i++)
                    id[i] = i;
        }

    @Override
    public int getSize() {
            return id.length;
        }

    // 查找元素p所對應的集合編號
    // O(1)複雜度
    public int find(int p){
            if (p < 0 || p >= id.length)
                throw new IllegalArgumentException("p is out of bound.");
            return id[p];
        }

    // 查看元素p和元素q是否所屬一個集合
    // O(n) 複雜度
    @Override
    public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

    // 合併元素p和元素q所屬的集合
    // O(n) 複雜度
    @Override
    public void unionElements(int p, int q) {
            int pID = find(p);
            int qID = find(q);

            if (pID == qID)
                return;

            // 合併過程需要遍歷一遍所有元素, 將兩個元素的所屬集合編號合併
            for (int i = 0; i < id.length; i++)
                if (id[i] == pID)
                    id[i] = qID;
       }
}
