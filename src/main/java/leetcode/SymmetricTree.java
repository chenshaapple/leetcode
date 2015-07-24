package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SymmetricTree {
	public boolean isSymmetricRecursive(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			return left.val == right.val && helper(left.left, right.right)
					&& helper(left.right, right.left);
		}
		return false;
	}

	public class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if(root == null) return true;
	        Deque<TreeNode> deque = new LinkedList<>();
	        deque.addLast(root.left);
	        deque.addLast(root.right);
	        while(deque.size() > 1) {
	            TreeNode left = deque.pollFirst(), right = deque.pollFirst();
	            if(left == null && right == null) continue;
	            if(left == null ^ right == null) return false;
	            if(left.val != right.val) return false;
	            deque.addLast(left.left);
	            deque.addLast(right.right);
	            deque.addLast(left.right);
	            deque.addLast(right.left);
	        }
	        return true;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(sln.isSymmetric(root));
	}

}
