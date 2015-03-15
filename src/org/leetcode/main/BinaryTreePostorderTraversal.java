package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderRecursiveTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		helper(res, root);
		return res;
	}

	private void helper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(res, root.left);
		helper(res, root.right);
		res.add(root.val);
	}

	public List<Integer> postorderIterativeTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		do {
			while (root != null) {
				if(root.right != null) {
					stack.push(root.right);
				}
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.right != null && stack.peek() == root.right) {
				stack.pop();
				stack.push(root);
				root = root.right;
			} else {
				res.add(root.val);
				root = null;
			}
		} while (!stack.isEmpty());

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
		print(postorderIterativeTraversal(root));
	}

}
