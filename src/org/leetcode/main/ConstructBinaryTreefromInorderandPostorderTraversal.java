package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return construct(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] postorder, int postEnd, int[] inorder, int begin, int end) {
    	if(postEnd < 0) {
    		return null;
    	}
    	int rootValue = postorder[postEnd];
    	int index = findIndex(inorder, rootValue, begin, end);
    	TreeNode result = null;
    	if(index != -1) {
    		result = new TreeNode(rootValue);
    		result.left = construct(postorder, postEnd - 1 - (end - index), inorder, begin, index -1);
    		result.right = construct(postorder, postEnd - 1, inorder, index + 1, end);
    	}
    	return result;
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
	@Test
	public void test() {
		int[] inorder = new int[]{3,2,4,1,5};
		int[] postorder = new int[]{3,4,2,5,1};
		TreeNode root = buildTree(inorder, postorder);
		assertNotNull(root);
	}

}
