package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import java.util.*;

/*
 * 思路：以矩形为单位，依次将四个边的数添加到结果里，再缩小一层，构造下一个矩形，直到搜索完成
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		int rowSize = matrix.length, colSize = 0;
		if (rowSize == 0) {
			return result;
		}
		colSize = matrix[0].length;

		// make sure that, there is a 0-height rectangle
		int rectangleCount = Math.min(rowSize + 1, colSize + 1) / 2;
		for (int i = 0; i < rectangleCount; i++) {
			// right
			for (int col = i; col < colSize - i; col++) {
				result.add(matrix[i][col]);
			}
			// down
			for (int row = i + 1; row < rowSize - 1 - i; row++) {
				result.add(matrix[row][colSize - 1 - i]);
			}
			// left
			for (int col = colSize - 1 - i; col >= i && (rowSize - 1 - i != i); col--) {
				result.add(matrix[rowSize - 1 - i][col]);
			}
			// up
			for (int row = rowSize - 2 - i; row > i && (colSize - 1 - i != i); row--) {
				result.add(matrix[row][i]);
			}
		}
		return result;
	}

	public class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			List<Integer> res = new LinkedList<>();
			int rowSize = matrix.length;
			if (rowSize == 0)
				return res;
			int colSize = matrix[0].length;
			int[] dirRow = new int[] { 0, 1, 0, -1 };
			int[] dirCol = new int[] { 1, 0, -1, 0 };
			int rectCap = Math.min((rowSize + 1) / 2, (colSize + 1) / 2);
			for (int rect = 0; rect < rectCap; rect++) {
				int[] cap = new int[] { colSize - 2 * rect, rowSize - 2 * rect };
				int row = rect, col = rect, dir = 0;
				if (cap[0] + cap[1] <= 2)
					res.add(matrix[row][col]);
				else {
					for (dir = 0; dir < dirRow.length; dir++) {
						for (int i = 0; (dir < 2 || cap[(dir + 1) % 2] > 1)
								&& i < cap[dir % 2] - 1; i++, row += dirRow[dir], col += dirCol[dir])
							res.add(matrix[row][col]);
						if (dir < 2 && cap[dir] == 1) {
							res.add(matrix[row][col]);
							row += dirRow[dir + 1];
							col += dirCol[dir + 1];
						}
					}
				}
			}
			return res;
		}
		
		public List<Integer> spiralOrder2(int[][] matrix) {
			List<Integer> res = new LinkedList<>();
			int rowSize = matrix.length;
			if (rowSize == 0)
				return res;
			int colSize = matrix[0].length;
			int[] dirRow = new int[] { 0, 1, 0, -1 };
			int[] dirCol = new int[] { 1, 0, -1, 0 };
			boolean[][] visited = new boolean[rowSize][colSize];
			int row = 0, col = 0, dir = 0;
			while(res.size() < rowSize * colSize) {
				if(!visited[row][col]) {
					visited[row][col] = true;
					res.add(matrix[row][col]);
				} else {
					int nextRow = row + dirRow[dir];
					int nextCol = col + dirCol[dir];
					if(nextRow < rowSize && nextCol < colSize &&
							nextRow >= 0 && nextCol >= 0 &&
							!visited[nextRow][nextCol]) {
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

	private Solution sln = new Solution();

	@Test
	public void test1() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertEquals(spiralOrder(matrix), sln.spiralOrder2(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder2(matrix));
	}

	@Test
	public void test3() {
		int[][] matrix = new int[][] { { 3 }, { 2 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder2(matrix));
	}

	@Test
	public void test4() {
		int[][] matrix = new int[][] { { 2, 3 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder2(matrix));
	}

	@Test
	public void test5() {
		int[][] matrix = new int[][] { { 6, 7, 8 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder2(matrix));
	}
}
