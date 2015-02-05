package org.leetcode.main;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    		if(head == null || head.next == null) {
    			return head;
    		}
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode curNode = head.next, lastNode = head;
        lastNode.next = null;
        while(curNode != null) {
        		if(curNode.val != lastNode.val) {
        			lastNode.next = curNode;
        			lastNode = curNode;
        			curNode = curNode.next;
        			lastNode.next = null;
        			continue;
        		}
        		curNode = curNode.next;
        }
        return vHead.next;
    }
}
