package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				result.add(root.val);
				stack.push(root.right);
				root = root.left;
			} else {
				root = stack.pop();
			}
		}
		return result;
	}

	public List<Integer> preorderMorrisTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		TreeNode curt = root, prev = null;
		while(curt != null) {
			if(curt.left == null) {
				res.add(curt.val);
				curt = curt.right;
			} else {
				prev = curt.left;
				while(prev.right != null && prev.right != curt) {
					prev = prev.right;
				}
				if(prev.right == null) {
					res.add(curt.val);
					prev.right = curt;
					curt = curt.left;
				} else {//prev.right == curt
					prev.right = null;
					curt = curt.right;
				}
			}
		}
		return res;
	}
	
	private void print(List<Integer> list) {
		for (Integer num : list) {
			System.out.print(num + " ");
		}
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		print(preorderMorrisTraversal(root));
	}
}
