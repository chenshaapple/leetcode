package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalancedBinaryTree {
	private boolean result = true;
	
    public boolean isBalanced(TreeNode root) {
    		getDepth(root);
    		return result;
    }
    
    private int getDepth(TreeNode root) {
		if(result == false) {
			return -1;
		}
    		if(root == null) {
    			return 0;
    		}
    		int left = getDepth(root.left);
    		int right = getDepth(root.right);
    		if(Math.abs(left - right) > 1) {
    			result = false;
    		}
    		return 1 + Math.max(left, right);
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
