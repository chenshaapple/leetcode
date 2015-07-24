package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			List<Integer> level = new LinkedList<>();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = list.pollFirst();
				level.add(node.val);
				if (node.left != null) {
					list.addLast(node.left);
				}
				if (node.right != null) {
					list.addLast(node.right);
				}
			}
			res.addFirst(level);
		}
		return res;
	}

	private void print(List<List<Integer>> res) {

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
