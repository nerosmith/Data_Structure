package com.nerosmith.java.Heap_and_Queue.Add_and_Sift_Up_in_Heap;

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

    // 向堆中添加元素
    public void add(E e){
            data.addLast(e);
            siftUp(data.getSize()-1);
        }

    private void siftUp(int k) {
            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
                    data.swap(k,parent(k));
                    k = parent(k);
                }
        }
}
