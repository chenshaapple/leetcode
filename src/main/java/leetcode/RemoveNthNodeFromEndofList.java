package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveNthNodeFromEndofList {
	public class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	    		ListNode vhead = new ListNode(-1), prev = vhead, slow = head, fast = head;
	    		vhead.next = head;
	    		for(int i = 1; i < n; i++, fast = fast.next);
	    		while(fast.next != null) {
	    			fast = fast.next;
	    			prev = slow;
	    			slow = slow.next;
	    		}
	    		prev.next = slow.next;
	    		return vhead.next;
	    }
	}
}
