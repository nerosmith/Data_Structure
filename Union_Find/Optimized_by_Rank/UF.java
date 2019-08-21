package com.nerosmith.java.Union_Find.Optimized_by_Rank;

public interface UF {
        int getSize();
        boolean isConnected(int p, int q);
        void unionElements(int p, int q);
    }
