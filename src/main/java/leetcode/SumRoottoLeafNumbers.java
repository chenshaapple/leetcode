package leetcode;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class SumRoottoLeafNumbers {
	//won't pass
	public int sumNumbers(TreeNode root) {
		int res = 0, value = 0;
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			value = value * 10 + root.val;
			if (root.left == null && root.right == null) {
				res += value;
				value /= 10;
			}
			if (root.left != null) {
				stack.push(root.left);
			}
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		return res;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(sumNumbersRecursive(root));
	}
	
	public int sumNumbersRecursive(TreeNode root) {
		return helper(0, root, 0);
	}
	
	private int helper(int res, TreeNode root, int value) {
	    if(root == null) {
	        return 0;
	    } else if(root.left == null && root.right == null) {
			return res + (value * 10) + root.val;
		}
		int nextRes = res;
		if(root.left != null) {
			nextRes = helper(nextRes, root.left, value * 10 + root.val);
		}
		if(root.right != null) {
			nextRes = helper(nextRes, root.right, value * 10 + root.val);
		}
		return nextRes;
	}

	@Test
	public void test1() {
		//1,5,1,#,#,6
	}
}
