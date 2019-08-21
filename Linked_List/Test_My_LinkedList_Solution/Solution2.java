package com.nerosmith.java.Linked_List.Test_My_LinkedList_Solution;

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

    public static void main(String[] args) {
            int[] nums = {1, 2, 6, 3, 4, 5, 6};
            ListNode head = new ListNode(nums);
            System.out.println(head);

            ListNode res = (new Solution()).removeElements(head, 6);
            System.out.println(res);
        }
}
