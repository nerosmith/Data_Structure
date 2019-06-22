package com.nerosmith.java.Arrays.Generic_Data_Structures;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.addIndex(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
