package com.nerosmith.java.AVL_Tree.LR_and_RL;
// Leetcode 804. Unique Morse Code Words
public class Solution {
    public int uniqueMorseRepresentations(String[] words){
            String[] code ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            AVLTree<String,Object> set = new AVLTree<>();
            for (String word : words) {
                    StringBuilder res = new StringBuilder();
                    for (int i = 0; i < word.length(); i++)
                        res.append(code[word.charAt(i) - 'a']);
                    set.add(res.toString(),null);
                }
            return set.getSize();
        }

}
