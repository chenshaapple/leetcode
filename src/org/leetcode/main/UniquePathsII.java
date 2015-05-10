package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rowSize = obstacleGrid.length, colSize = 0;
		if (rowSize == 0) {
			return 0;
		}
		colSize = obstacleGrid[0].length;
		int[][] opt = new int[rowSize + 1][colSize + 1];
		opt[0][0] = 1;
		opt[0][1] = 1;
		for (int col = 2; col <= colSize; col++) {
			opt[0][col] = 0;
		}
		for (int row = 2; row <= rowSize; row++) {
			opt[row][0] = 0;
		}
		for (int row = 1; row <= rowSize; row++) {
			for (int col = 1; col <= colSize; col++) {
				if(obstacleGrid[row - 1][col - 1] == 1) {
					opt[row][col] = 0;
				} else {
					opt[row][col] = opt[row][col - 1] + opt[row - 1][col];
				}
			}
		}
		return opt[rowSize][colSize];
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
