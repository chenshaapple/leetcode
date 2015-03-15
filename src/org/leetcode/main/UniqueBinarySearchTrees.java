package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
    		if(n <= 0) {
    			return 0;
    		}
    		int[] opt = new int[n + 1];
    		opt[0] = 1; opt[1] = 1;
    		for(int curt = 2; curt <= n; curt++) {
    			for(int root = 1; root <= curt; root++) {//当前根
    				opt[curt] += opt[root - 1] * opt[curt - root];//左子树的个数*右子树的个数
    			}
    		}
    		return opt[n];
    }
	@Test
	public void test() {
		for(int i = 1; i <= 3; i++) {
			System.out.println(numTrees(i));
		}
	}

}
