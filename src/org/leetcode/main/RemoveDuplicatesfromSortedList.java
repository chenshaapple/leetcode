package org.leetcode.main;

public class RemoveDuplicatesfromSortedList {
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
        		if(head == null || head.next == null) return head;
            ListNode curr = head, vhead = new ListNode(0), vcurr = null;
            vhead.next = head;
            vcurr = vhead.next;
            while(curr != null) {
            		if(curr.val != vcurr.val) {
            			vcurr.next = curr;
            			vcurr = curr;
            		}
            		curr = curr.next;
            }
            vcurr.next = null;
            return vhead.next;
        }
    }
}
