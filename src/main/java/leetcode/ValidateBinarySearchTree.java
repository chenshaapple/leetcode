package leetcode;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

//BST鐨勪腑搴忛亶鍘嗘槸涓�涓�掑鐨勫簭鍒楋紝楠岃瘉杩欎釜灏辫浜�
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		long prev = Long.MIN_VALUE;//杩欐牱姣旇緝trick锛屽疄闄呬笂testCase鐢ㄧ殑Integer鐨勬渶灏忓��
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if (root.val <= prev) {
					return false;
				}
				prev = root.val;
				root = root.right;
			}
		}
		return true;
	}
	
	public class Solution {
	    public boolean isValidBST(TreeNode root) {
	        if(root == null) return true;
	        return validLeft(root.left, root.val) && validRight(root.right, root.val);
	    }
	    
	    private boolean validLeft(TreeNode root, int max) {
	        if(root == null) return true;
	        if(root.val >= max) return false;
	        return validLeft(root.left, root.val) && validRight(root.right, root.val);
	    }
	    
	    private boolean validRight(TreeNode root, int min) {
	        if(root == null) return true;
	        if(root.val <= min) return false;
	        return validLeft(root.left, root.val) && validRight(root.right, root.val); 
	    }
	}
	
//	public boolean isValidBSTRecursive(TreeNode root) {
//		return helper(root);
//	}
//	
//	private boolean helper(TreeNode root) {
//		if(root == null) {
//			return true;
//		}
//		if(root.left != null && root.left.val >= root.val) {
//			return false;
//		}
//		if(root.right != null && root.right.val <= root.val) {
//			return false;
//		}
//		return helper(root.left) && helper(root.right);
//	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		assertTrue(isValidBST(root));
	}

	@Test
	public void test1() {
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		root.right = new TreeNode(Integer.MAX_VALUE);
		assertTrue(isValidBST(root));
	}
}
