package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) {
			return new LinkedList<List<Integer>>();
		}
		Deque<TreeNode> currentLevel = new LinkedList<>();
		Deque<TreeNode> nextLevel = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();
		boolean leftToRight = true;
		
		currentLevel.push(root);
		LinkedList<Integer> currentList = new LinkedList<Integer>();
		result.add(currentList);
		while(!currentLevel.isEmpty()) {
			TreeNode current = currentLevel.pop();
			if(leftToRight) {
				currentList.addLast(current.val);
			} else {
				currentList.addFirst(current.val);
			}
			if(current.left != null) {
				nextLevel.addLast(current.left);
			}
			if(current.right != null) {
				nextLevel.addLast(current.right);
			}
			
			if(currentLevel.isEmpty()) {
				if(!nextLevel.isEmpty()){
					currentList = new LinkedList<>();
					result.add(currentList);
				}
				leftToRight = !leftToRight;
				Deque<TreeNode> tmp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = tmp;
			}
		}
		return result;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		List<List<Integer>> result = zigzagLevelOrder(root);
		System.out.println(result.size());
	}

}
