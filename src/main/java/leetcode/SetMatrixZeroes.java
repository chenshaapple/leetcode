package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/* ˼·�� ����һ�Σ���Ϊ0��row, col��¼������������Set��
 * 	Ȼ�����������Set������matrix
 * �ռ临�Ӷȣ�O(m + n)
 * Follow up: �������O(1)�ռ临�ӶȽ����
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rowSize = matrix.length, colSize = 0;
		if (rowSize == 0) {
			return;
		}
		colSize = matrix[0].length;
		Set<Integer> rowZeroSet = new HashSet<>(rowSize);
		Set<Integer> colZeroSet = new HashSet<>(colSize);
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (matrix[row][col] == 0) {
					rowZeroSet.add(row);
					colZeroSet.add(col);
				}
			}
		}
		for (Integer row : rowZeroSet) {
			for (int col = 0; col < colSize; col++) {
				matrix[row][col] = 0;
			}
		}
		for (Integer col : colZeroSet) {
			for (int row = 0; row < rowSize; row++) {
				matrix[row][col] = 0;
			}
		}
	}

	public class Solution {
		public void setZeroes(int[][] matrix) {
			if (matrix.length == 0)
				return;
			int rowSize = matrix.length, colSize = matrix[0].length;
			boolean rowFlag = false, colFlag = false;
			for (int row = 0; row < rowSize; row++)
				if (matrix[row][0] == 0)
					colFlag = true;
			for (int col = 0; col < colSize; col++)
				if (matrix[0][col] == 0)
					rowFlag = true;
			for (int row = 1; row < rowSize; row++) {
				for (int col = 1; col < colSize; col++) {
					if (matrix[row][col] == 0) {
						matrix[row][0] = 0;
						matrix[0][col] = 0;
					}
				}
			}
			for (int row = 1; row < rowSize; row++) {
				if (matrix[row][0] == 0)
					Arrays.fill(matrix[row], 0);
			}
			for (int col = 1; col < colSize; col++) {
				if (matrix[0][col] == 0)
					for (int row = 0; row < rowSize; row++)
						matrix[row][col] = 0;
			}
			if (rowFlag)
				Arrays.fill(matrix[0], 0);
			if (colFlag)
				for (int row = 0; row < rowSize; row++)
					matrix[row][0] = 0;
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
