package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class MaximalRectangle {
	public class Solution {
	    public int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0) return 0;
	        int rowSize = matrix.length, colSize = matrix[0].length;
	        int res = 0;
	        int[] left = new int[colSize], right = new int[colSize], height = new int[colSize];
	        Arrays.fill(right, colSize);
	        for(int row = 0; row < rowSize; row++) {
	        		int currLeft = 0, currRight = colSize;
	        		for(int col = 0; col < colSize; col++) {
	        			if(matrix[row][col] == '1') {
	        				left[col] = Math.max(currLeft, left[col]);
	        				height[col]++;
	        			} else {
	        				height[col] = 0;
	        				left[col] = 0;
	        				currLeft = col + 1;
	        			}
	        			if(matrix[row][colSize - 1 - col] == '1') {
	        				right[colSize - 1 - col] = Math.min(right[colSize - 1 - col], currRight);
	        			} else {
	        				right[colSize - 1 - col] = colSize;
	        				currRight = colSize - 1 - col;
	        			}
	        			
	        		}
	        		for(int i = 0; i < colSize; i++)
	        			res = Math.max(res, (right[i] - left[i]) * height[i]);
	        }
	        return res;
	    }
	}
	
	private Solution sln = new Solution();
	
	@Test
	public void case1() {
		char[][] matrix = new char[][]{
				{'1','0'}
		};
		System.out.println(sln.maximalRectangle(matrix));
	}
}
