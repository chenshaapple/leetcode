package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	int opt[][] = new int[m + 1][n + 1];
    	opt[0][0] = 1;opt[0][1] = 1;
    	for(int col = 2; col <= n; col++) {
    		opt[0][col] = 0;
    	}
    	for(int row = 2; row <=m ; row++) {
    		opt[row][0] = 0;
    	}
    	for(int row = 1; row <= m; row++) {
    		for(int col = 1; col <= n; col++) {
    			opt[row][col] = opt[row][col - 1] + opt[row - 1][col];
    		}
    	}
    	return opt[m][n];
    }
	@Test
	public void test() {
		assertEquals(1, uniquePaths(1, 2));
	}

}
