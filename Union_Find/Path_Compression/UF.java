package com.nerosmith.java.Union_Find.Path_Compression;

public interface UF {
        int getSize();
        boolean isConnected(int p, int q);
        void unionElements(int p, int q);
    }
