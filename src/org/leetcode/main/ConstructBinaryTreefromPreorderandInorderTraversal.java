package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return construct(preorder, 0, inorder, 0, inorder.length - 1);
	}

	private int findIndex(int[] order, int rootValue, int begin,
			int end) {
		for (int i = begin; i <= end; i++) {
			if (order[i] == rootValue) {
				return i;
			}
		}
		return -1;
	}

	private TreeNode construct(int[] preorder, int preOrderBegin,
			int[] inorder, int begin, int end) {
		if(preOrderBegin >= preorder.length) {
			return null;
		}
		int rootValue = preorder[preOrderBegin];
		TreeNode root = null;
		int mid = findIndex(inorder, rootValue, begin, end);
		if(mid != -1) {
			root = new TreeNode(rootValue);
			root.left = construct(preorder, preOrderBegin + 1, inorder, begin, mid - 1);
			root.right = construct(preorder, preOrderBegin + 1 + mid - begin, inorder, mid + 1, end);
		}
		return root;
	}

	@Test
	public void test() {
		int[] preorder = new int[]{1,2,3,4,5};
		int[] inorder = new int[]{3,2,4,1,5};
		TreeNode root = buildTree(preorder, inorder);
		assertNotNull(root);
	}

}
