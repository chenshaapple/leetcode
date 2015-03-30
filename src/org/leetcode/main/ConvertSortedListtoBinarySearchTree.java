package org.leetcode.main;

import static org.junit.Assert.*;

import java.awt.HeadlessException;

import org.junit.Test;

/*
 * ��������������<��<��
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

	private ListNode curt;
	
	public TreeNode sortedListToBSTBottomUp(ListNode head) {
		int size = 0;
		ListNode curt = head;
		while(curt != null) {
			curt = curt.next;
			size++;
		}
		this.curt = head;
		return bottomUp(0, size - 1);
	}
	
	private TreeNode bottomUp(int begin, int end) {
		if(begin > end) {
			return null;
		}
		int mid = (begin + end) / 2;
		TreeNode left = bottomUp(begin, mid - 1);
		TreeNode result = new TreeNode(curt.val);
		curt = curt.next;
		result.left = left;
		result.right = bottomUp(mid + 1, end);
		return result;
	}
	
	private void inorder(TreeNode head) {
		if(head == null) {
			return;
		}
		inorder(head.left);
		System.out.print(head.val + " ");
		inorder(head.right);
	}
	
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		inorder(sortedListToBSTBottomUp(head));
	}

}
