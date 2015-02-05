package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode preNode1 = null, curNode1 = l1, preNode2 = null, curNode2 = l2, result;
		int overflow = 0;
		while (curNode1 != null || curNode2 != null || overflow > 0) {
			int sum = curNode1.val + curNode2.val + overflow;
			if (sum > 9) {
				sum = sum % 10;
				overflow = 1;
			} else {
				overflow = 0;
			}
			curNode1.val = curNode2.val = sum;
			preNode1 = curNode1;
			curNode1 = curNode1.next;
			preNode2 = curNode2;
			curNode2 = curNode2.next;
		}
		if(curNode2 != null) {
			curNode1 = curNode2;
			l1 = l2;
		}
		while(overflow > 0) {
			if(curNode1 == null) {
				curNode1 = new ListNode(0);
				preNode1.next = curNode1;
			}
			int sum = curNode1.val + overflow;
			if (sum > 9) {
				sum = sum % 10;
				overflow = 1;
			} else {
				overflow = 0;
			}
			curNode1.val = sum;
			preNode1 = curNode1;
			curNode1 = curNode1.next;
		}
		return l1;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		addTwoNumbers(l1, l2);
	}

}
