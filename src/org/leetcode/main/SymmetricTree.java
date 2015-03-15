package org.leetcode.main;

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

	//这种内存不达标,要把null优化掉，能判断出结果就提前判断，不要推到下一层
	public boolean isSymmetricIterative(TreeNode root) {
        ArrayList<TreeNode> curt = new ArrayList<>(), prev = new ArrayList<>();
        curt.add(root);
        while(!curt.isEmpty()) {
        		for(int i = 0; i < curt.size() / 2; i++) {
        			TreeNode left = curt.get(i), right = curt.get(curt.size() - 1 - i);
        			if(left != null && right != null) {
        				if(left.val != right.val) {
        					return false;
        				}
        			} else if(left != null || right != null) {
        				return false;
        			}
        		}
        		for(TreeNode node : curt) {
        			if(node == null) {
        				prev.add(null);
        				prev.add(null);
        			} else {
        				prev.add(node.left);
        				prev.add(node.right);
        			}
        		}
        		curt.clear();
        		ArrayList<TreeNode> tmp = curt;
        		curt = prev;
        		prev = tmp;
        }
		return true;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
