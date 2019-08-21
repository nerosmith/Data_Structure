package com.nerosmith.java.Union_Find.Path_Compression;

// 第四版Union-Find
public class UnionFind4 implements UF {

    // rank[i]表示以i為根的集合所表示的樹的層數
    private int[] rank;
    // parent[i]表示第i個元素所指向的父節點
    private int[] parent;

    public UnionFind4(int size){
            rank = new int[size];
            parent = new int[size];

            for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
        }

    private int find(int p){
            if (p < 0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");

            // 不斷去查詢自己的父親節點, 直到到達根節點
            // 根節點的特點: parent[p] == p
            while (p != parent[p])
                p = parent[p];
            return p;
        }


    @Override
    public int getSize() {
            return parent.length;
        }

    @Override
    public boolean isConnected(int p, int q) {
            return  find(p) == find(q);
        }

    @Override
    public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            // 根據兩個元素所在樹的rank不同判斷合併方向
            // 將rank低的集合合併到rank高的集合上
            if (rank[pRoot] < rank[qRoot])
                parent[pRoot] = qRoot;
            else if (rank[pRoot] > rank[qRoot])
                parent[qRoot] = pRoot;
            else { // rank[pRoot] == rank[qRoot]
                 parent[pRoot] = qRoot;
                 rank[qRoot]+=1; // 此時,維護rank的值
               }

        }
}
