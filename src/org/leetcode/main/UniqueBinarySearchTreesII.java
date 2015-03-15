package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import java.util.*;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new ArrayList<>();
		if (left > right) {
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftNodes = helper(left, i - 1);
			List<TreeNode> rightNodes = helper(i + 1, right);
			for (TreeNode leftNode : leftNodes) {
				for (TreeNode rightNode : rightNodes) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					res.add(root);
				}
			}
		}
		return res;
	}

	@Test
	public void test1() {
		List<TreeNode> res = generateTrees(1);
		assertEquals(1, res.size());
	}

	@Test
	public void test2() {
		List<TreeNode> res = generateTrees(2);
		assertEquals(2, res.size());
	}
}
