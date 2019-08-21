package com.nerosmith.java.Linked_List.Linked_List_Problems_in_Leetcode;

// Leetcode 203. Remove Linked List Elements
public class Solution {
    public ListNode removeElements(ListNode head,int val){

        while(head != null && head.val == val){
                    ListNode delNode = head;
                    head = head.next;
                    delNode.next = null;
                }

            if (head == null)
                return head;

            ListNode prev = head;

            while (prev.next != null){
                  if (prev.next.val == val){
                        ListNode delNode = prev.next;
                        prev.next = delNode.next;
                        delNode.next = null;
                      }
                   else
                       prev = prev.next;
                }
            return head;
        }
}
