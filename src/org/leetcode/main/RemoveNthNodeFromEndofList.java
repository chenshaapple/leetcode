package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode vhead = new ListNode(0);
		vhead.next = head;
		ListNode slow = vhead, fast = vhead;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		if (slow.next != null) {
			if(slow.next == head) {
				head = slow.next.next;
			}
			slow.next = slow.next.next;
		}
		
		return head;
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		removeNthFromEnd(head, 1);
	}

}
