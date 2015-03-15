package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<>();
		pathSum(res, root, new LinkedList<>(), 0, sum);
		return res;
	}

	private void pathSum(List<List<Integer>> res, TreeNode root, List<Integer> candidate, int sum,
			int target) {
		if(root == null) {
			return;
		}
		candidate.add(root.val);
		int nextSum = sum + root.val;
		if(root.left == null && root.right == null) {
			if(nextSum == target) {
				res.add(new LinkedList<>(candidate));
				candidate.remove(candidate.size() - 1);
				return;
			}
		}
		if(root.left != null) {
			pathSum(res, root.left, candidate, nextSum, target);
		}
		if(root.right != null) {
			pathSum(res, root.right, candidate, nextSum, target);
		}
		candidate.remove(candidate.size() - 1);
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<List<Integer>> res = pathSum(root, 2);
		assertEquals(0, res.size());
	}

}
