package com.nerosmith.java.Linked_List.Linked_List_Problems_in_Leetcode;

// Leetcode 203. Remove Linked List Elements
public class Solution2 {
    public ListNode removeElements(ListNode head,int val){

            if (head == null)
                return head;

            while(head != null && head.val == val)
                head = head.next;

            ListNode prev = head;
            while (prev.next != null){
                    if (prev.next.val == val)
                        prev.next = prev.next.next;
                    else
                        prev = prev.next;
                }
            return head;
        }
}
