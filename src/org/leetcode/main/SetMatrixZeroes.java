package org.leetcode.main;

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
