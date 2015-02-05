package org.leetcode.main;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = null, curNode = head;
        ListNode lastUnique = head = null;
        while(curNode != null) {
        		if((preNode == null || curNode.val != preNode.val) && (curNode.next == null || curNode.val != curNode.next.val)) {
    				if(lastUnique != null) {
    					lastUnique.next = curNode;
    				}
    				lastUnique = curNode;
        		}
			if(head == null) {
				head = lastUnique;
			}
        		preNode = curNode;
			curNode = curNode.next;
			if(lastUnique != null) {
				lastUnique.next = null;
			}
        }
        return head;
    }
	
	@Test
	public void testStartWithDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		assertTrue(deleteDuplicates(head).val == 2);
	}

	@Test
	public void testContainOnlyDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		assertTrue(deleteDuplicates(head) == null);
	}

	@Test
	public void testContainOnlyOneElement() {
		ListNode head = new ListNode(1);
		deleteDuplicates(head);
		assertTrue(head.val == 1);
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		deleteDuplicates(head);
		assertTrue(head.val == 1 && head.next == null);
	}
	
	@Test
	public void testTwoCoupleDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		assertTrue(deleteDuplicates(head) == null);
	}
}
