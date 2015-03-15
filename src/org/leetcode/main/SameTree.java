package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
    		if(p == null && q == null) {
    			return true;
    		} else if(p != null && q != null) {
    			return p.val == q.val && helper(p.left, q.left) && helper(p.right, q.right);
    		}
    		return false;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
