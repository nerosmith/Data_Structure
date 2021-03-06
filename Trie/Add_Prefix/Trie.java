package com.nerosmith.java.Trie.Add_Prefix;

import java.util.TreeMap;

public class Trie {

    private class Node{
            public boolean isWord;
            public TreeMap<Character,Node> next;

            public Node(boolean isWord){
                    this.isWord = isWord;
                    next = new TreeMap<>();
                }

            public Node(){
                    this(false);
                }
        }

    private Node root;
    private int size;

    public Trie(){
            root = new Node();
            size = 0;
        }

    // 獲得Trie中存儲的單詞數量
    public int getSize(){
            return size;
        }

    // 向Trie中添加一個新的單詞 word
    public void add(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next.get(c) == null)
                        cur.next.put(c,new Node());
                    cur = cur.next.get(c);
                }

            if (!cur.isWord){
                    cur.isWord = true;
                    size++;
                }
        }

    // 查詢單詞 word 是否在 Trie 中
    public boolean contains(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i++){
                    char c = word.charAt(i);
                    if (cur.next.get(c) == null)
                        return false;
                    cur = cur.next.get(c);
                }
            return cur.isWord;
        }

    // 查詢是否在 Trie 中有單詞以 refix 為前綴
    public boolean isPrefix(String prefix){
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                      char c = prefix.charAt(i);
                      if (cur.next.get(c) == null)
                          return false;
                      cur = cur.next.get(c);
                }
            return true;
        }
}
