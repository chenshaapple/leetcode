package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveLinkedListElements {
	public class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode vhead = new ListNode(-1);
			vhead.next = head;
			for (ListNode prev = vhead, curr = head; curr != null; curr = curr.next) {
				if (curr.val == val)
					prev.next = curr.next;
				else
					prev = curr;
			}
			return vhead.next;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		System.out.println(sln.removeElements(head, 1));
	}

}
