package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class BinaryTreeInorderTraversal {

	// 这是利用右指针为空的话可以构造线索树,右指针永远是下一个遍历对象
	public List<Integer> inorderTraversalMorris(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		TreeNode curt = root, prev = null;
		while (curt != null) {
			if (curt.left == null) {
				result.add(curt.val);
				curt = curt.right;
			} else {
				prev = curt.left;
				// 去寻找前驱
				while (prev.right != null && prev.right != curt) {
					prev = prev.right;
				}
				// 构造线索
				if (prev.right == null) {
					prev.right = curt;
					curt = curt.left;// 继续遍历左子树
				} else {
					// 左子树已遍历完，还原树结构同时添加结果
					prev.right = null;
					result.add(curt.val);
					// 遍历右子树
					curt = curt.right;
				}
			}
		}
		return result;
	}

	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		while (root != null || !deque.isEmpty()) {
			if (root != null) {
				deque.push(root);
				root = root.left;
			} else {
				root = deque.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		helper(result, root);
		return result;
	}

	private void helper(List<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(result, root.left);
		result.add(root.val);
		helper(result, root.right);
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
		print(inorderTraversalMorris(root));
	}

}
