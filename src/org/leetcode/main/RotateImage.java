package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 思路：这道题要求in-place，因为正四边形旋转，相关的只有4个元素，所以每次调整4个元素即可
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int rectangleCount = size / 2;
        for(int i = 0; i < rectangleCount; i++) {
        	int cornerBuf = matrix[i][i];
        	matrix[i][i] = matrix[size - 1 - i][i];
        	matrix[size - 1 - i][i] = matrix[size - 1 - i][size - 1 - i];
        	matrix[size - 1 - i][size - 1 - i] = matrix[i][size - 1 - i];
        	matrix[i][size - 1 - i] = cornerBuf;
        	for(int j = i + 1; j < size - i - 1; j++) {
            	int innerBuf = matrix[i][j];
            	matrix[i][j] = matrix[size - 1 - j][i];
            	matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
            	matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
            	matrix[j][size - 1 - i] = innerBuf;
        	}
        }
    }
	@Test
	public void test() {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		System.out.println(matrix);
	}
	
	@Test
	public void test1() {
	}
}
