package com.nerosmith.java.Hash_Table.Hash_Table_Implementation;

import java.util.TreeMap;

public class HashTable<K,V> {

    private TreeMap<K,V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int M){
            this.M = M;
            size = 0;
            hashtable = new TreeMap[M];
            for (int i = 0; i < M; i++)
                hashtable[i] = new TreeMap<>();
        }

    public HashTable(){
            this(97);
        }

    private int hash(K key){
            // 0x7fffffff 是十六進制的整數,也是32-bit int 的最大值
            // 因為 hash 是要做為數組的 index , 這樣做可避免負數出現
            return (key.hashCode() & 0x7fffffff) % M;
        }

    public void add(K key,V value){
            TreeMap<K,V> map = hashtable[hash(key)];
            if (map.containsKey(key))
                map.put(key,value);
            else {
                map.put(key,value);
                size++;
              }
        }

    public V remove(K key){
            V ret = null;
            TreeMap<K,V> map = hashtable[hash(key)];
            if (map.containsKey(key)){
                    ret = map.remove(key);
                    size--;
                }
            return ret;
        }

    public void set(K key,V value){
            TreeMap<K,V> map = hashtable[hash(key)];
            if (!map.containsKey(key))
                throw new IllegalArgumentException(key + " doesn't exist!");

            map.put(key,value);
        }

    public boolean comtains(K key){
            return hashtable[hash(key)].containsKey(key);
        }

    public V get(K key){
            return hashtable[hash(key)].get(key);
        }


}
