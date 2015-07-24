package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import java.util.*;

/*
 * ˼·���Ծ���Ϊ��λ�����ν��ĸ��ߵ�����ӵ���������Сһ�㣬������һ�����Σ�ֱ���������
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
			List<Integer> res = new ArrayList<>(matrix.length
					* matrix[0].length);
			int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int[] boarder = { matrix[0].length, matrix.length - 1 };
			int row = 0, col = 0;
			int index = 0;
			int dirIndex = 0;
			int boardIndex = 0;
			while (index < boarder[boardIndex]) {
				res.add(matrix[row][col]);
				index++;
				if (index == boarder[boardIndex]) {
					index = 0;
					boarder[boardIndex]--;
					boardIndex = (boardIndex + 1) % 2;
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
	public void test1() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertEquals(spiralOrder(matrix), sln.spiralOrder(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder(matrix));
	}

	@Test
	public void test3() {
		int[][] matrix = new int[][] { { 3 }, { 2 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder(matrix));
	}

	@Test
	public void test4() {
		int[][] matrix = new int[][] { { 2, 3 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder(matrix));
	}

	@Test
	public void test5() {
		int[][] matrix = new int[][] { { 6, 7, 8 }, };
		assertEquals(spiralOrder(matrix), sln.spiralOrder(matrix));
	}
}
