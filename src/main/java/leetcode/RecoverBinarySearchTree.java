package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class RecoverBinarySearchTree {
	/**
	 * O(n) space
	 * 
	 * @param root
	 */
	public void recoverTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(list, root);
		Collections.sort(list);
		construct(new LinkedList<>(list), root);
	}

	private void inorder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(list, root.left);
		list.add(root.val);
		inorder(list, root.right);
	}

	private void construct(Deque<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		construct(list, root.left);
		root.val = list.pollFirst();
		construct(list, root.right);
	}

	/**
	 * only use stack to recurse
	 */
	public void recoverTree2(TreeNode root) {
		List<TreeNode> res = new ArrayList<>(), prev = new ArrayList<>();
		prev.add(null);
		recoverTree2(root, prev, res);
		int tmp = 0;
		TreeNode node1 = res.get(0), node2 = res.size() > 2 ? res.get(2) : res
				.get(1);
		tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}

	private void recoverTree2(TreeNode root, List<TreeNode> prev,
			List<TreeNode> res) {
		if (root == null) {
			return;
		}
		recoverTree2(root.left, prev, res);
		if (prev.get(0) != null && prev.get(0).val > root.val) {
			if (res.size() == 0) {
				res.add(prev.get(0));
			}
			res.add(root);
		}
		prev.set(0, root);
		recoverTree2(root.right, prev, res);
	}

	public class Solution {
		public void recoverTree(TreeNode root) {
			Deque<TreeNode> stack = new LinkedList<>();
			TreeNode prev = new TreeNode(Integer.MIN_VALUE);
			int count = 0;
			TreeNode[] errs = new TreeNode[2];
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (root.val < prev.val) {
						if (count == 0) {
							errs[count++] = prev;
							errs[count] = root;
						} else {
							errs[count++] = root;
						}
					}
					prev = root;
					root = root.right;
				}
			}
			swap(errs[0], errs[1]);
		}

		private void swap(TreeNode n1, TreeNode n2) {
			int tmp = n1.val;
			n1.val = n2.val;
			n2.val = tmp;
		}
	}
}
