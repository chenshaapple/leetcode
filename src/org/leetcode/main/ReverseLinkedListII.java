package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode preNode = null, curNode = head, preReverseNode = null;
		
		for (int i = 0; i < m - 1; i++) {
			preNode = curNode;		//m-1th node
			curNode = curNode.next;	//mth node
		}
		preReverseNode = preNode;
		preNode = curNode;
		curNode = curNode.next;
		
		ListNode tmp;
		for (int i = m; i < n; i++) {
			tmp = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = tmp;
		}
		
		if (preReverseNode != null) {
			preReverseNode.next.next = curNode;
			preReverseNode.next = preNode;
		} else {
			head.next = curNode;
			head = preNode;
		}
		return head;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("->");
			}
			node = node.next;
		}
		System.out.println();
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		printList(head);
		node2.next = null;
		reverseBetween(head, 1, 2);
		printList(head);
		node2.next = node3;
		reverseBetween(head, 2, 4);
		printList(head);
	}

}
