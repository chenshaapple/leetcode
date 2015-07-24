package leetcode;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

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

	public class Solution {
	    private int[] preorder;
	    private int[] inorder;
	    private Map<Integer, Integer> map;
	    private int rootIndex;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        this.preorder = preorder;
	        this.inorder = inorder;
	        map = new HashMap<>();
	        int size = preorder.length;
	        for(int i = 0; i < size; i++)
	            map.put(inorder[i], i);
	        return buildTree(0, size);
	    }
	    
	    private TreeNode buildTree(int i1, int i2) {
	        if(i1 == i2) return null;
	        TreeNode root = new TreeNode(preorder[rootIndex]);
	        int index = map.get(preorder[rootIndex++]);
	        root.left = buildTree(i1, index);
	        root.right = buildTree(index + 1, i2);
	        return root;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		int[] preorder = new int[]{1,2,3,4,5};
		int[] inorder = new int[]{3,2,4,1,5};
		TreeNode root = buildTree(preorder, inorder);
		assertNotNull(root);
	}
	
	@Test
	public void case1() {
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		TreeNode root =  sln.buildTree(preorder, inorder);
		System.out.println(root);
	}

}
