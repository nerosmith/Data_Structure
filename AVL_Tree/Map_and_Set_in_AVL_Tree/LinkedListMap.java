package com.nerosmith.java.AVL_Tree.Map_and_Set_in_AVL_Tree;

public class LinkedListMap <K, V> implements Map<K, V>{

    private LinkedList<K,V> list;

    public LinkedListMap(){
            list = new LinkedList<>();
        }

    @Override
    public void add(K key, V value) {
            list.add(key,value);
        }

    @Override
    public V remove(K key) {
            return list.remove(key);
        }

    @Override
    public boolean contains(K key) {
            return list.contains(key);
        }

    @Override
    public V get(K key) {
            return list.get(key);
        }

    @Override
    public void set(K key, V newValue) {
        list.set(key,newValue);
        }

    @Override
    public int getSize() {
            return list.getSize();
        }

    @Override
    public boolean isEmpty() {
            return list.isEmpty();
        }
}
