package com.nerosmith.java.Arrays.Query_and_Update_Element;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.addIndex(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
