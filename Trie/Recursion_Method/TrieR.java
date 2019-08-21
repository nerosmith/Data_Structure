package com.nerosmith.java.Trie.Recursion_Method;

import java.util.TreeMap;

// TrieR 使用遞歸的方式實現 Trie 的基本功能
public class TrieR {

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

    public TrieR(){
            root = new Node();
            size = 0;
        }

    public int getSize(){
            return size;
        }

    public void add(String word){
            add(root, word, 0);
        }

    private void add(Node node, String word, int index) {
            if (index == word.length()){
                    if (!node.isWord){
                            node.isWord = true;
                            size++;
                        }
                    return;
                }
            char c = word.charAt(index);
            if (node.next.get(c) == null)
                node.next.put(c,new Node());
            add(node.next.get(c),word,index+1);
        }

    public boolean contains(String word){
            return contains(root,word,0);
        }

    private boolean contains(Node node, String word, int index) {
            if (index == word.length())
                return node.isWord;

            char c = word.charAt(index);
            if (node.next.get(c) == null)
                return false;

            return contains(node.next.get(c),word,index+1);
        }

    public boolean isPrefix(String prefix){
            return isPrefix(root,prefix,0);
        }

    private boolean isPrefix(Node node, String prefix, int index) {
            if (index == prefix.length())
                return node.isWord;

            char c = prefix.charAt(index);
            if (node.next.get(c) == null)
                return false;

            return isPrefix(node.next.get(c),prefix,index);
        }

}
