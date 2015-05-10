package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveLinkedListElements {
	public class Solution {
	    public ListNode removeElements(ListNode head, int val) {
	        ListNode vhead = new ListNode(-1), curr = head, prev = vhead;
	        vhead.next = head;
	        while(curr != null) {
	        		if(curr.val == val) {
	        			prev.next = curr.next;
	        			curr = curr.next;
	        			continue;
	        		}
	        		prev = curr;
	        		curr = curr.next;
	        }
	        return vhead.next;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		System.out.println(sln.removeElements(head, 1));
	}

}
