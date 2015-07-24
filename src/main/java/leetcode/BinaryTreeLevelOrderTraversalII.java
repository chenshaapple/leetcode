package leetcode;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
