package com.nerosmith.java.Trie.Add_Delete;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

public class RandomizedSet_Trie {

    private class TrieMap{
            public class Node{
                    public boolean isWord;
                    public TreeMap<Character,Node> next;
                    public int val;

                    public Node(boolean isWord,int val){
                            this.isWord = isWord;
                            next = new TreeMap<>();
                            this.val = val;
                        }

                    public Node(){
                            this(false,-1);
                        }
                }

            private Node root;
            private int size;

            public TrieMap(){
                    root = new Node();
                    size = 0;
                }

            public int getSize(){
                    return size;
                }

            public void add(String word, int val){

                    Node cur = root;
                    for(int i = 0 ; i < word.length() ; i ++){
                            char c = word.charAt(i);
                            if(cur.next.get(c) == null)
                                cur.next.put(c, new Node());
                            cur = cur.next.get(c);
                        }

                    if(!cur.isWord){
                            cur.isWord = true;
                            size ++;
                        }
                    cur.val = val;
                }

            public boolean contains(String word){

                    Node cur = root;
                    for(int i = 0 ; i < word.length() ; i ++){
                            char c = word.charAt(i);
                            if(cur.next.get(c) == null)
                                return false;
                            cur = cur.next.get(c);
                        }
                    return cur.isWord;
                }

            public int get(String word){
                    Node cur = root;
                    for (int i = 0; i < word.length(); i++) {
                            char c = word.charAt(i);
                            if (cur.next.get(c) == null)
                                throw new RuntimeException("Can not get");
                            cur = cur.next.get(c);
                        }
                    return cur.val;
                }

            public boolean remove(String word){
                    Stack<Node> stack = new Stack<>();
                    stack.push(root);
                    for (int i = 0; i < word.length(); i++) {
                            if (!stack.peek().next.containsKey(word.charAt(i)))
                                return false;
                            stack.push(stack.peek().next.get(word.charAt(i)));
                        }

                    if (!stack.peek().isWord)
                        return false;

                    stack.peek().isWord = false;
                    size--;

                    if (stack.peek().next.size() > 0)
                        return true;
                    else
                        stack.pop();

                    for(int i = word.length() - 1; i >= 0; i --){
                            stack.peek().next.remove(word.charAt(i));
                            if(stack.peek().isWord || stack.peek().next.size() > 0)
                                return true;
                        }
                    return true;
                }
        }

    TrieMap map;
    ArrayList<Integer> nums;

    public RandomizedSet_Trie(){
            map = new TrieMap();
            nums = new ArrayList<>();
        }

    public boolean insert(int val){
            String key = Integer.toString(val);
            if (map.contains(key))
                return false;

            nums.add(val);
            int index = nums.size()-1;
            map.add(key,index);
            return true;
        }

    public boolean remove(int val){
            String key = Integer.toString(val);
            if (!map.contains(key))
                return false;

            int index = map.get(key);
            map.remove(key);

            int num = nums.get(nums.size()-1);
            nums.remove(nums.size()-1);

            if (num != val){
                    nums.set(index,num);
                    map.add(Integer.toString(num),index);
                }
            return true;
        }

    public int getRandom() {
            Random random = new Random();
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }
}
