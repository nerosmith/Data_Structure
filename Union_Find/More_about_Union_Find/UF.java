package com.nerosmith.java.Union_Find.More_about_Union_Find;

public interface UF {
        int getSize();
        boolean isConnected(int p, int q);
        void unionElements(int p, int q);
    }
