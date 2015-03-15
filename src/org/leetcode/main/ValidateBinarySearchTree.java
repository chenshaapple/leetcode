package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

//BST的中序遍历是一个递增的序列，验证这个就行了
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		long prev = Long.MIN_VALUE;//这样比较trick，实际上testCase用的Integer的最小值
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if (root.val <= prev) {
					return false;
				}
				prev = root.val;
				root = root.right;
			}
		}
		return true;
	}
	
//	public boolean isValidBSTRecursive(TreeNode root) {
//		return helper(root);
//	}
//	
//	private boolean helper(TreeNode root) {
//		if(root == null) {
//			return true;
//		}
//		if(root.left != null && root.left.val >= root.val) {
//			return false;
//		}
//		if(root.right != null && root.right.val <= root.val) {
//			return false;
//		}
//		return helper(root.left) && helper(root.right);
//	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		assertTrue(isValidBST(root));
	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		root.right = new TreeNode(Integer.MAX_VALUE);
		assertTrue(isValidBST(root));
	}
}
