package com.nerosmith.java.Recursion.Debug_Recursive_Solution;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val){
            this.val = val;
        }

    // 鏈表節點的構造函數
    // 使用arr為參數，創建一個鏈表，當前的ListNode為鏈表頭結點
    public ListNode(int[] arr){
            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                    cur.next = new ListNode(arr[i]);
                    cur = cur.next;
                }
        }

    // 以當前節點為頭結點的鏈表信息字符串
    @Override
    public String toString() {
            StringBuffer res = new StringBuffer();
            ListNode cur = this;
            while(cur != null){
                    res.append(cur.val + " -> ");
                    cur = cur.next;
                }
            res.append("NULL");
            return res.toString();
        }

}
