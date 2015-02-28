package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * ¶þ²éËÑË÷Ê÷£¬×ó<ÖÐ<ÓÒ
 */

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null, slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(prev != null) {
			prev.next = null;
		}
		TreeNode root = new TreeNode(slow.val);
		ListNode right = slow.next;
		slow.next = null;
		root.left = sortedListToBST(head == slow ? null : head);
		root.right = sortedListToBST(right);
		return root;
	}

	@Test
	public void test() {
		sortedListToBST(new ListNode(1));
	}

}
