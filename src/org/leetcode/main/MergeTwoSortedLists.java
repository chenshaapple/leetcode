package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), curt = result, left = l1, right = l2;
        while(left != null && right != null) {
            if(left.val < right.val) {
                curt.next = left;
                left = left.next;
            } else {
                curt.next = right;
                right = right.next;
            }
            curt = curt.next;
        }
        if(left != null) {
            curt.next = left;
        }
        if(right != null) {
            curt.next = right;
        }
        return result.next;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
