package com.nerosmith.java.Heap_and_Queue.Heap_Basics;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
            data = new Array<>(capacity);
        }

    public MaxHeap(){
            data = new Array<>();
        }

    // 返回堆中的元素個數
    public int size(){
            return data.getSize();
        }

    // 返回一個布爾值, 表示堆中是否為空
    public  boolean isEmpty(){
            return data.isEmpty();
        }

    // 返回完全二叉樹的數組表示中，一個索引所表示的元素的父親節點的索引
    private int parent(int index){
            if (index == 0)
                throw new IllegalArgumentException("index-0 doesn't have parent.");
            return (index - 1)/2;
        }

    // 返回完全二叉樹的數組表示中，一個索引所表示的元素的左孩子節點的索引
    private int leftChild(int index){
            return index*2+1;
        }

    // 返回完全二叉樹的數組表示中，一個索引所表示的元素的右孩子節點的索引
    private int rightChild(int index){
            return index*2+2;
        }
}
