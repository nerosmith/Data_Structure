package com.nerosmith.java.Heap_and_Queue.Add_and_Sift_Up_in_Heap;


public class Array<E> {
    private E[] data;
    private int size;
    private static int Record_Index = -1;

    // 構造函數，傳入數組的容量 capacity 構造 Array
    public Array(int capacity){
            data = (E[])new Object[capacity];
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

    // 向所有元素後添加一個新元素
    public void addLast(E e){
            add(size,e);
        }

    // 在所有元素前添加一個新元素
    public void addFirst(E e){
            add(0,e);
        }

    // 在指定位置添加一個元素
    public void addIndex(int index,E e){
            add(index,e);
        }

    // 在index索引的位置插入一个新元素 e
    private void add(int index, E e) {

            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
            if (size == data.length)
                resize(2*data.length);
            for (int i = size - 1 ; i >= index;i--)
                data[i+1] = data[i];
            data[index] = e;
            size++;
        }

    // 獲取index索引位置的元素
    public E get(int index){
            if (index < 0 || index >= size )
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

    // 修改index索引位置的元素為e
    public void set(int index, E e){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            data[index] = e;
        }

    // 查找數組中是否有元素e
    public boolean contains(E e){
            for (int i = 0; i < size; i++) {
                   if (data[i] == e){
                        Record_Index = i;
                        return true;
                     }
                }
            Record_Index = -1;
            return false;
        }

    // 查找數組中元素e所在的索引，如果不存在元素e，則返回-1
    public int find(E e){
            if (contains(e))
                return Array.Record_Index;
            return Array.Record_Index;
        }

    // 從數組中刪除第一個元素, 返回刪除的元素
    public E removeFirst(){
            return remove(0);
        }

    // 從數組中刪除最後一個元素, 返回刪除的元素
    public E removeLast(){
            return remove(size-1);
        }

    // 從數組中刪除元素e
    public void removeElement(E e){
            int index = find(e);
            if (index != -1)
                remove(index);
        }

    // 從數組中刪除index位置的元素, 返回刪除的元素
    private E remove(int index) {
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            E ret = data[index];
            for (int i = index+1; i < size; i++)
                data[i-1] = data[i];
            size--;
            data[size] = null; // loitering objects != memory leak
            if (size == data.length/2)
                resize(data.length/2);
            return ret;
        }

    public void swap(int i,int j){
            if (i < 0 || i >= size || j < 0 || j >= size)
                throw new IllegalArgumentException("Index is illegal.");
            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

    @Override
    public String toString() {
           StringBuffer res = new StringBuffer();
           res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
           res.append('[');
            for (int i = 0; i < size; i++) {
                   res.append(data[i]);
                   if (i != size-1)
                       res.append(", ");
                }
            res.append(']');
            return res.toString();
        }

    // 將數組空間的容量變成 newCapacity 大小
    private void resize(int newCapacity){
            E[] newData = (E[])new Object[newCapacity];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
}

