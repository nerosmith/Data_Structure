package com.nerosmith.java.Union_Find.Path_Compression;

// 第五版Union-Find
public class UnionFind5 implements UF{

    // rank[i]表示以i為根的集合所表示的樹的層數
    // 在後續的代碼中, 並不會維護rank的語意,
    // 因為 rank 的值在路徑壓縮的過程中, 有可能不在是樹的層數值
    // 這也是 rank 不叫 height 或者 depth 的原因, 他只是作為比較的一個標準
    private int[] rank;
    private int[] parent;

    public UnionFind5(int size){
            rank = new int[size];
            parent = new int[size];

            for (int i = 0; i < size; i++) {
                     parent[i] = i;
                     rank[i] = 1;
                }
        }

    @Override
    public int getSize() {
            return parent.length;
        }

    protected int find(int p){
            if (p < 0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");

            while (p != parent[p]){
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
            return p;
        }

    @Override
    public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

    @Override
    public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            if (rank[pRoot] < rank[qRoot])
                parent[pRoot] = qRoot;
            else if (rank[pRoot] > rank[qRoot])
                parent[qRoot] = pRoot;
            else {
                    parent[pRoot] = qRoot;
                    rank[qRoot]+=1;
                }
        }
}
