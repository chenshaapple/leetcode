package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*
 * ˼·�������Ҫ��in-place����Ϊ���ı�����ת����ص�ֻ��4��Ԫ�أ�����ÿ�ε���4��Ԫ�ؼ���
 */
public class RotateImage {
	public class Solution {
		public void rotate(int[][] matrix) {
	        int n = matrix.length;
	        for(int i = 0; i < n / 2; i++) {
	        		for(int j = i; j < n - 1 - i; j++) {
	        			int tmp = matrix[i][j];
	        			matrix[i][j] = matrix[n - 1 - j][i];
	        			matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
	        			matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
	        			matrix[j][n - 1 - i] = tmp;
	        		}
	        }
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		sln.rotate(matrix);
		for(int[] row : matrix)
			System.out.println(Arrays.toString(row));
	}

}
