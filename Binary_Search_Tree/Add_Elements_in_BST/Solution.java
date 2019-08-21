package com.nerosmith.java.Binary_Search_Tree.Add_Elements_in_BST;
// Leetcode 804. Unique Morse Code Words
public class Solution {
    public int uniqueMorseRepresentations(String[] words){
            String[] codes =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            BST<String> bst = new BST<>();
            for (String word : words){
                    StringBuilder res = new StringBuilder();
                    for (int i = 0; i < word.length(); i++)
                        res.append(codes[word.charAt(i) - 'a']);
                    bst.add(res.toString());
                }
            return bst.size();
        }
}
