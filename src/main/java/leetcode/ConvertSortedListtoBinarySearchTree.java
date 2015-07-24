package leetcode;

import static org.junit.Assert.*;

import java.awt.HeadlessException;

import org.junit.Test;

/*
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

	public class Solution {
		private ListNode curr;
	    public TreeNode sortedListToBST(ListNode head) {
	        int len = 0;
	        ListNode tmpCurr = head;
	        while(tmpCurr != null) {
	        		tmpCurr = tmpCurr.next;
	        		len++;
	        }
	        curr = head;
	        return sortedListToBST(0, len - 1);
	    }
	    
	    private TreeNode sortedListToBST(int begin, int end) {
	    		if(begin > end) {
	    			return null;
	    		}
	    		int mid = (begin + end) / 2;
	    		TreeNode left = sortedListToBST(begin, mid - 1);
	    		TreeNode root = new TreeNode(curr.val);
	    		curr = curr.next;
	    		root.right = sortedListToBST(mid + 1, end);
	    		root.left = left;
	    		return root;
	    }
	}
}
