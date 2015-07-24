package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTwoNumbers {
	public class Solution {
		private ListNode empty = new ListNode(0);

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode vhead = new ListNode(-1), curr = vhead, c1 = l1, c2 = l2;
			boolean overflow = false;
			while (c1 != null || c2 != null) {
				curr.next = add(c1 != null ? c1 : empty, c2 != null ? c2 : empty, overflow);
				curr = curr.next;
				overflow = normalise(curr);
				c1 = c1 != null ? c1.next : c1;
				c2 = c2 != null ? c2.next : c2;
			}
			if (overflow)
				curr.next = add(empty, empty, overflow);
			return vhead.next;
		}

		private ListNode add(ListNode n1, ListNode n2, boolean overflow) {
			return new ListNode(n1.val + n2.val + (overflow ? 1 : 0));
		}

		private boolean normalise(ListNode node) {
			if (node.val >= 10) {
				node.val = node.val % 10;
				return true;
			}
			return false;
		}
	}
}
