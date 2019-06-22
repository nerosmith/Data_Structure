package com.nerosmith.java.Arrays.Create_Array;

public class Array {
    private int[] data;
    private int size;

    // 構造函數，傳入數組的容量 capacity 構造 Array
    public Array(int capacity){
            data = new int[capacity];
            size = 0;
        }

    // 無參數的構造函數，默認數組的容量 capacity = 10
    public Array(){
            this(10);
        }

    // 獲取數組的容量
    public int getCapacity(){
           return data.length;
        }

    // 獲取數組中的元素個數
    public int getSize(){
            return size;
        }

    // 返回數組是否為空
    public boolean isEmpty(){
            return size == 0;
        }
}

