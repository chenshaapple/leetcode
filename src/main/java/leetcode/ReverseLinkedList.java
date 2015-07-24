package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class ReverseLinkedList {
	public class Solution {
		public ListNode reverseList(ListNode head) {
			ListNode curr = head, prev = null;
			while (curr != null) {
				ListNode next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			return prev;
		}
	}
}
