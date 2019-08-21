package com.nerosmith.java.Trie.Add_Delete;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class RandomizedSet_TrieR {

    private class TrieRMap{
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

            public TrieRMap(){
                    root = new Node();
                    size = 0;
                }

            public int getSize(){
                    return size;
                }

            public void add(String word, int val){
                    add(root, word, 0, val);
                }

            private void add(Node node, String word, int index, int val){

                    if(index == word.length()){
                            if(!node.isWord){
                                    node.isWord = true;
                                    size ++;
                                }
                            node.val = val;
                            return;
                        }

                    char c = word.charAt(index);
                    if(node.next.get(c) == null)
                        node.next.put(c, new Node());
                    add(node.next.get(c), word, index + 1, val);
                }

            public boolean contains(String word){
                    return contains(root, word, 0);
                }

            private boolean contains(Node node, String word, int index){
                    if(index == word.length())
                        return node.isWord;

                    char c = word.charAt(index);
                    if(node.next.get(c) == null)
                        return false;

                    return contains(node.next.get(c), word, index + 1);
                }

            public int get(String word){
                    return get(root, word, 0);
                }

            private int get(Node node, String word, int index){

                    if(index == word.length())
                        return node.val;

                    char c = word.charAt(index);
                    if(node.next.get(c) == null)
                        throw new RuntimeException("Can not get");

                    return get(node.next.get(c), word, index + 1);
                }

            public boolean remove(String word){
                    if(word.equals(""))
                        return false;
                    return remove(root, word, 0);
                }


            private boolean remove(Node node, String word, int index){

                    if(index == word.length()){
                            if(!node.isWord)
                                return false;
                            node.isWord = false;
                            size --;
                            return true;
                        }

                    char c = word.charAt(index);
                    if(!node.next.containsKey(c))
                        return false;

                    boolean ret = remove(node.next.get(c), word, index + 1);
                    Node nextNode = node.next.get(c);
                    if(!nextNode.isWord && nextNode.next.size() == 0)
                        node.next.remove(word.charAt(index));
                    return ret;
                }
        }

    TrieRMap map;
    ArrayList<Integer> nums;

    public RandomizedSet_TrieR(){
            map = new TrieRMap();
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

    public boolean remove(int val) {

            String key = Integer.toString(val);
            if(!map.contains(key))
                return false;

            int index = map.get(key);
            map.remove(key);

            int num = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);

            if(num != val) {
                nums.set(index, num);
                map.add(Integer.toString(num), index);
            }

            return true;
        }

    public int getRandom() {

            Random random = new Random();
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }
}
