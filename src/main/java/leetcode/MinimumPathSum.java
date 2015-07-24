package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * ˼·����̬�滮
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int rowSize = grid.length, colSize = 0;
		if (rowSize == 0) {
			return 0;
		}
		colSize = grid[0].length;

		int[][] opt = new int[rowSize + 1][colSize + 1];
		// init
		for (int row = 2; row <= rowSize; row++) {
			opt[row][0] = Integer.MAX_VALUE;
		}
		for (int col = 2; col <= colSize; col++) {
			opt[0][col] = Integer.MAX_VALUE;
		}
		opt[1][0] = opt[1][0] = 0;
		for (int row = 1; row <= rowSize; row++) {
			for (int col = 1; col <= colSize; col++) {
				int lastPos = Math.min(opt[row - 1][col], opt[row][col - 1]);
				opt[row][col] = lastPos + grid[row - 1][col - 1];
			}
		}

		return opt[rowSize][colSize];
	}
	
	public class Solution {
	    public int minPathSum(int[][] grid) {
	        if(grid.length == 0) return 0;
	        int rowSize = grid.length, colSize = grid[0].length;
	        int[][] opt = new int[rowSize][colSize];
	        opt[0][0] = grid[0][0];
	        for(int row = 1; row < rowSize; row++)
	        		opt[row][0] = opt[row - 1][0] + grid[row][0];
	        for(int col = 1; col < colSize; col++)
	        		opt[0][col] = opt[0][col - 1] + grid[0][col];
	        for(int row = 1; row < rowSize; row++)
	        		for(int col = 1; col < colSize; col++) {
	        			opt[row][col] = Math.min(opt[row - 1][col], opt[row][col - 1]) + grid[row][col];
	        		}
	        return opt[rowSize - 1][colSize - 1];
	    }
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
