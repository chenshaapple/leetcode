package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/* 思路： 遍历一次，将为0的row, col记录下来，用两个Set存
 * 	然后根据这两个Set，更新matrix
 * 空间复杂度：O(m + n)
 * Follow up: 这个能用O(1)空间复杂度解决，
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
    	int rowSize = matrix.length, colSize = 0;
    	if(rowSize == 0) {
    		return;
    	}
    	colSize = matrix[0].length;
    	Set<Integer> rowZeroSet = new HashSet<>(rowSize);
    	Set<Integer> colZeroSet = new HashSet<>(colSize);
    	for(int row = 0; row < rowSize; row++) {
    		for(int col = 0; col < colSize; col++) {
    			if(matrix[row][col] == 0) {
    				rowZeroSet.add(row);
    				colZeroSet.add(col);
    			}
    		}
    	}
    	for(Integer row : rowZeroSet) {
    		for(int col = 0; col < colSize; col++) {
    			matrix[row][col] = 0;
    		}
    	}
    	for(Integer col : colZeroSet) {
    		for(int row = 0; row < rowSize; row++) {
    			matrix[row][col] = 0;
    		}
    	}
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
