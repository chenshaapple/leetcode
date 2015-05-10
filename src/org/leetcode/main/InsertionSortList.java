package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode curt = head, result = null;
		while (curt != null) {
			ListNode tmp = curt.next;
			curt.next = null;
			result = insert(result, curt);
			curt = tmp;
		}
		return result;
	}

	private ListNode insert(ListNode head, ListNode aNode) {
		if (head == null) {
			return aNode;
		}
		ListNode prev = null, curt = head;
		while (curt != null) {
			if (aNode.val < curt.val) {
				aNode.next = curt;
				if (prev != null) {
					prev.next = aNode;
					return head;
				} else {
					return aNode;
				}

			}
			prev = curt;
			curt = curt.next;
		}
		if (prev != null) {
			prev.next = aNode;
		}
		return head;
	}

	private ListNode convert(int[] values) {
		ListNode result = new ListNode(0), curt = result;
		for (int val : values) {
			curt.next = new ListNode(val);
			curt = curt.next;
		}
		return result.next;
	}

	public class Solution {
		public ListNode insertionSortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			for (ListNode curr = head.next; curr != null; curr = curr.next) {
				int insert = curr.val;
				for(ListNode node = head; node != curr; node = node.next) {
					if(insert < node.val) {
						int curVal = node.val;
						for(ListNode swap = node; swap != curr; swap = swap.next) {
							int tmp = swap.next.val;
							swap.next.val = curVal;
							curVal = tmp;
						}
						node.val = insert;
						break;
					}
				}
			}
			return head;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		sln.insertionSortList(head);
		System.out.println(head);
	}

	@Test
	public void test1() {
		ListNode head = convert(new int[] { 4, 19, 14, 5, -3, 1, 8, 5, 11, 15 });
		sln.insertionSortList(head);
		System.out.println(head);
	}

}
