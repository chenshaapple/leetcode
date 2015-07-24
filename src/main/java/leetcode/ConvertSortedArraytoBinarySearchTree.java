package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] num, int begin, int end) {
		if (begin > end) {
			return null;
		}
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, begin, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
