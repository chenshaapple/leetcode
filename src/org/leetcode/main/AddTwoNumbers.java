package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode vhead = new ListNode(0), curr = vhead, l1Curr = l1, l2Curr = l2;
		boolean isOverFlow = false;
		while (l1Curr != null && l2Curr != null) {
			int sum = l1Curr.val + l2Curr.val;
			if (isOverFlow) sum++;
			if (sum > 9) {
				isOverFlow = true;
				sum = sum % 10;
			} else {
				isOverFlow = false;
			}
			curr.next = new ListNode(sum);
			curr = curr.next;
			l1Curr = l1Curr.next;
			l2Curr = l2Curr.next;
		}
		l1Curr = l1Curr != null ? l1Curr : l2Curr;
		while (l1Curr != null || isOverFlow) {
			int sum = 0;
			if(l1Curr != null) {
				sum += l1Curr.val;
				l1Curr = l1Curr.next;
			}
			if (isOverFlow) sum++;
			if(sum > 9) {
				isOverFlow = true;
				sum = sum % 10;
			} else {
				isOverFlow = false;
			}
			curr.next = new ListNode(sum);
			curr = curr.next;
		}
		return vhead.next;
	}
}
