package com.nerosmith.java.Union_Find.Path_Compression;

// 第二版 Union-Find
public class UnionFind2 implements UF {

    // 第二版Union-Find, 使用一個數組構建一棵指向父節點的樹
    // parent[i]表示第 i 個元素所指向的父節點
    private int[] parent;

    public UnionFind2(int size){
            parent = new int[size];

            // 初始化, 每一個parent[i]指向自己, 表示每一個元素自己自成一個集合
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }


    @Override
    public int getSize() {
            return parent.length;
        }

    // 查找過程, 查找元素p所對應的集合編號
    // O(h)複雜度, h為樹的高度
    private int find(int p){
            if (p < 0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");

            // 不斷去查詢自己的父親節點, 直到到達根節點
            // 根節點的特點: parent[p] == p
            while (p != parent[p])
                p = parent[p];
            return p;
        }


    // 查看元素p和元素q是否所屬一個集合
    // O(h)複雜度, h為樹的高度
    @Override
    public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

    // 合併元素p和元素q所屬的集合
    // O(h)複雜度, h為樹的高度
    @Override
    public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            parent[pRoot] = qRoot;
        }
}
