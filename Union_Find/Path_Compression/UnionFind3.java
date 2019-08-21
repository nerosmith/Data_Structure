package com.nerosmith.java.Union_Find.Path_Compression;

// 第三版Union-Find
public class UnionFind3 implements UF {

    private int[] parent;
    // sz[i]表示以i為根的集合中元素個數
    private int[] sz;

    public UnionFind3(int size){
            parent = new int[size];
            sz = new int[size];

            // 初始化, 每一個parent[i]指向自己, 表示每一個元素自己自成一個集合
             for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    sz[i] = 1;
                 }
        }

    @Override
    public int getSize() {
            return parent.length;
        }

    private int find(int p){
            if (p < 0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");
            while (p != parent[p])
                p = parent[p];
            return p;
        }


    @Override
    public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }


    // 根據兩個元素所在樹的元素個數不同判斷合併方向
    // 將元素個數少的集合合併到元素個數多的集合上
    @Override
    public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            if (sz[pRoot] < sz[qRoot]){
                    parent[pRoot] = qRoot;
                    sz[qRoot] += sz[pRoot];
                }
            else{ // sz [qRoot] <= sz [pRoot]
                    parent[qRoot] = pRoot;
                    sz[pRoot]+=sz[qRoot];
              }
        }
}
