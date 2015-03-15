package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return helper(root, 0, sum);
	}

	private boolean helper(TreeNode root, int sum, int target) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			return (sum + root.val) == target;
		}
		int nextSum = sum + root.val;
		boolean res = false;
		if (root.left != null) {
			res = res || helper(root.left, nextSum, target);
		}
		if (root.right != null) {
			res = res || helper(root.right, nextSum, target);
		}
		return res;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(-1);
		root.left.right = new TreeNode(3);
		assertTrue(hasPathSum(root, 2));
	}

}
