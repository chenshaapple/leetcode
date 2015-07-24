package leetcode;

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
				if (obstacleGrid[row - 1][col - 1] == 1) {
					opt[row][col] = 0;
				} else {
					opt[row][col] = opt[row][col - 1] + opt[row - 1][col];
				}
			}
		}
		return opt[rowSize][colSize];
	}

	public class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid.length == 0)
				return 0;
			if (obstacleGrid[0][0] == 1)
				return 0;
			int rowSize = obstacleGrid.length, colSize = obstacleGrid[0].length;
			int[][] opt = new int[rowSize][colSize];
			opt[0][0] = 1;
			for (int i = 1; i < rowSize; i++)
				opt[i][0] = obstacleGrid[i][0] == 1 ? 0 : opt[i - 1][0];
			for (int i = 1; i < colSize; i++)
				opt[0][i] = obstacleGrid[0][i] == 1 ? 0 : opt[0][i - 1];
			for (int row = 1; row < rowSize; row++)
				for (int col = 1; col < colSize; col++) {
					opt[row][col] = obstacleGrid[row][col] == 1 ? 0
							: opt[row - 1][col] + opt[row][col - 1];
				}
			return opt[rowSize - 1][colSize - 1];
		}
	}

	Solution sln = new Solution();
	@Test
	public void test() {
		System.out.println(sln.uniquePathsWithObstacles(new int[][]{{0,1}}));
	}

}
