package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Swap Nodes in Pairs的follow up,这是一个通用的解法，肯定可以过那道题
 */
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		ListNode result = head;
		for (int i = 1; i < k && result != null; i++) {
			result = result.next;
		}
		result = result != null ? result : head;
		ListNode first = head, last = first;
		ListNode lastFirst = null;
		while (first != null) {
			for (int i = 1; i < k && last != null; i++) {
				last = last.next;
			}
			ListNode tmp = last != null ? last.next : null;
			if (last != null) {
				reverse(first, last);
			}
			if (lastFirst != null) {
				lastFirst.next = last != null ? last : first;
			}
			lastFirst = first;
			first = last = tmp;
		}
		return result;
	}
	private void reverse(ListNode begin, ListNode end) {
		ListNode prev = null, curt = begin;
		while (curt != end) {
			ListNode tmp = curt.next;
			curt.next = prev;
			prev = curt;
			curt = tmp;
		}
		end.next = prev;
	}

	public ListNode reverseKGroup2(ListNode head, int k) {
		if(k == 1) return head;
		ListNode curr = head, vhead = new ListNode(0), vcurr = vhead;
		while(curr != null) {
			ListNode[] group = new ListNode[k];
			for(int i = 0; curr != null && i < k; i++, curr = curr.next) 
				group[k - 1 - i] = curr;
			if(group[0] != null) {
				for(ListNode node : group) {
					vcurr.next = node;
					vcurr = node;
					vcurr.next = null;
				}
			} else {
				vcurr.next = group[k -1];
			}
		}
		return vhead.next;
	}
	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode end = new ListNode(5);
		head.next.next.next.next = end;
		ListNode res = reverseKGroup2(head, 3);
		System.out.println(res);
	}

	@Test
	public void test2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode end = new ListNode(5);
		head.next.next.next.next = end;
		System.out.println(reverseKGroup2(head, 2));
	}

	@Test
	public void test3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(reverseKGroup2(head, 3));
	}
}
