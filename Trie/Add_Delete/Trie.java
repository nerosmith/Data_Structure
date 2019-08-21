package com.nerosmith.java.Trie.Add_Delete;

import java.util.Stack;
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

    public int getSize(){
            return size;
        }

    public void add(String word){
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

    public boolean isPrefix(String prefix){

            Node cur = root;
            for(int i = 0 ; i < prefix.length() ; i ++){
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }

            return true;
        }

    // 刪除word, 返回是否刪除成功
    public boolean remove(String word){

            // 將搜索沿路的節點放入棧中
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            for (int i = 0; i < word.length(); i++) {
                    if (!stack.peek().next.containsKey(word.charAt(i)))
                        return false;
                    stack.push(stack.peek().next.get(word.charAt(i)));
                }

            if (!stack.peek().isWord)
                return false;

            // 將該單詞結尾 isWord 置空
            stack.peek().isWord = false;
            size--;

            // 如果單詞最後一個字母的節點的 next 非空，
            // 說明 trie 中還存儲了其他以該單詞為前綴的單詞，直接返回
            if (stack.peek().next.size() > 0)
                return true;

            // 因為已經沒有以該單詞為前綴的單詞 , 所以才執行 stack.pop()
            // 這樣子做主要是執行 stack.pop() 後 , top 位置產生改變
            // 被改變的 top 紀錄下個節點訊息 , 在加上述原因寫這行代碼
            // 執行後 , 會跟要刪除的 word 的字母一樣 ,剛好就能配合自底向上刪除
            else
                stack.pop();

            // 自底向上刪除
            for (int i = word.length()-1; i >= 0 ; i--) {
                    stack.peek().next.remove(word.charAt(i));
                    // 如果一個節點的 isWord 為 true，或者是其他單詞的前綴，則直接返回
                    if (stack.peek().isWord || stack.peek().next.size() > 0)
                        return true;
                    stack.pop();
                }
            return true;
        }
}
