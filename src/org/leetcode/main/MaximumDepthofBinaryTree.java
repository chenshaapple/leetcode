package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
    		if (root == null) {
    			return 0;
    		}
    		int res = 0;
    		Deque<TreeNode> deque = new LinkedList<>();
    		deque.add(root);
    		while (!deque.isEmpty()) {
    			res++;
    			int size = deque.size();
    			for (int i = 0; i < size; i++) {
    				TreeNode node = deque.pollFirst();
    				if (node.left != null) {
    					deque.addLast(node.left);
    				}
    				if(node.right != null) {
    					deque.addLast(node.right);
    				}
    			}
    		}
    		return res;
    	}
    
    public int maxDepthRecursive(TreeNode root) {
    		return root == null ? 0 : 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		assertEquals(3, maxDepthRecursive(root));
	}

}
