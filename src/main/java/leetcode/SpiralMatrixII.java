package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return null;
		}
		int[][] res = new int[n][n];
		res[0][0] = 1;
		int rectangleCount = Math.max(n / 2, (n + 1) / 2);
		for (int i = 0; i < rectangleCount; i++) {
			// right
			for (int col = i; col < n - i; col++) {
				if (col > 0) {
					res[i][col] = res[i][col - 1] + 1;
				}
			}
			// down
			for (int row = i + 1; row < n - i; row++) {
				res[row][n - 1 - i] = res[row - 1][n - 1 - i] + 1;

			}
			// left
			for (int col = n - 1 - i; col >= i && (n - 1 - i != i); col--) {
				if (col < n - 1 - i) {
					res[n - 1 - i][col] = res[n - 1 - i][col + 1] + 1;
				}
			}
			// up
			for (int row = n - 2 - i; row > i && (n - 1 - i != i); row--) {
				res[row][i] = res[row + 1][i] + 1;
			}
		}
		return res;
	}

	public class Solution2 {
		public int[][] generateMatrix(int n) {
			if (n == 0)
				return new int[0][0];
			int[][] res = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int size = 1, cap = n * n, row = 0, col = 0, dir = 0;
			int[] dirRow = new int[] { 0, 1, 0, -1 };
			int[] dirCol = new int[] { 1, 0, -1, 0 };
			while (size < cap + 1) {
				if (!visited[row][col]) {
					res[row][col] = size++;
					visited[row][col] = true;
				} else {
					int nextRow = row + dirRow[dir];
					int nextCol = col + dirCol[dir];
					if (nextRow < n && nextCol < n && nextRow >= 0
							&& nextCol >= 0 && !visited[nextRow][nextCol]) {
						row = nextRow;
						col = nextCol;
					} else {
						dir = (dir + 1) % 4;
					}
				}
			}
			return res;
		}
	}
	
	public class Solution {
	    public int[][] generateMatrix(int n) {
	        if(n == 0) return new int[0][0];
	        int[][] res = new int[n][n];
	        int step = n;
	        int stepIndex = 1;
	        int row = 0, col = 0;
	        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	        int dirIndex = 0;
	        int count = 1;
	        for(int i = 0; i< step; ) {
	        		res[row][col] = count++;
	        		i++;
	        		if(i == step) {
	        			i = 0;
	        			stepIndex++;
	        			if(stepIndex == 2) {
	        				step--;
	        				stepIndex = 0;
	        			}
	        			dirIndex = (dirIndex + 1) % 4;
	        		}
	        		row += dirs[dirIndex][0];
	        		col += dirs[dirIndex][1];
	        }
	        return res;
	    }
	}

	private Solution sln = new Solution();
	
	@Test
	public void test2() {
		int[][] res = sln.generateMatrix(2);
		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
	}

	@Test
	public void test3() {
		int[][] res = sln.generateMatrix(3);
		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
	}

	@Test
	public void test4() {
		int[][] res = sln.generateMatrix(4);
		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
	}
}
