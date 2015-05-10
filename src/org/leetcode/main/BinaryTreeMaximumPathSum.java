package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeMaximumPathSum {
	private int max;
	public int maxPathSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		max = root.val;
		int tmp = visit(root);
		return Math.max(max, tmp);
	}
	
	private int visit(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(0, visit(root.left));
		int right = Math.max(0, visit(root.right));
		max = Math.max(max, left + right + root.val);
		return left > right ? left + root.val : right + root.val;
	}

	//这种超时了
	public int maxPathSumDaC(TreeNode root) {
		return divide(root);
	}

	private int divide(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int res = 0;
		int left = divide(root.left);
		int right = divide(root.right);
		res = Math.max(left, right);
		int withRoot = combine(res, root);
		return Math.max(res, withRoot);
	}

	private int combine(int max, TreeNode root) {
		int res = max;
		if (root == null) {
			return res;
		}
		int sum = root.val;
		if(root.left != null) {
			sum = Math.max(sum, sum + findPathFromRoot(root.left, 0, 0));
		}
		if(root.right != null) {
			sum = Math.max(sum, sum + findPathFromRoot(root.right, 0, 0));
		}
		return Math.max(res, sum);
	}

	private int findPathFromRoot(TreeNode root, int sum, int max) {
		if (root == null) {
			return Math.max(sum, max);
		}
		sum += root.val;
		max = Math.max(max, sum);
		int left = findPathFromRoot(root.left, sum, max);
		max = Math.max(max, left);
		int right = findPathFromRoot(root.right, sum, max);
		return Math.max(max, right);
	}

	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
		
		assertEquals(12, maxPathSumDaC(root));
	}

	
	@Test
	public void test1() {
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(1);
		
		assertEquals(1, maxPathSum(root));
	}
}
