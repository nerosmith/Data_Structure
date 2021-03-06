package com.nerosmith.java.Trie.Basics;

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
}
