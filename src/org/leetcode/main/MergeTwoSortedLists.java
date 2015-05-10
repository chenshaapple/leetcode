package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    		ListNode vhead = new ListNode(0), curr = vhead, lCurr = l1, rCurr = l2;
    		while(lCurr != null && rCurr != null) {
    			if(lCurr.val < rCurr.val) {
    				curr.next = lCurr;
    				lCurr = lCurr.next;
    			} else {
    				curr.next = rCurr;
    				rCurr = rCurr.next;
    			}
    			curr = curr.next;
    		}
    		curr.next = lCurr != null ? lCurr : rCurr;
    		return vhead.next;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
