package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	int rowSize = matrix.length, colSize = 0;
    	if(rowSize == 0) {
    		return 0;
    	} 
    	colSize = matrix[0].length;
//        int[][] opt = new int[rowSize + 1][colSize + 1];
//        for(int row = 1; row < rowSize; row++) {
//        	for(int col = 1; col < colSize; col++) {
//        		if(matrix[row - 1][col - 1] == 0) {
//        			
//        		} else {
//        			
//        		}
//        	}
//        }
//        return opt[rowSize][colSize];
    	int result = 0;
    	for(int row = 0; row < rowSize; row++) {
    		for(int col = 0; col < colSize; col++) {
    			if(matrix[row][col] == '1') {
    				Deque<Integer> widthStack = new LinkedList<>();
    				for(int i = 1; (col + i - 1) < colSize; i++) {
    					if(matrix[row][col + i - 1] == '1') {
    						widthStack.push(i);
    					}
    				}
    				for(Integer width : widthStack) {
    					int height = 1;
    					for(int vertical = 0 ; (row + vertical) < rowSize; vertical++) {
    						boolean flag = true;
    						for(int offset = 0; offset < width; offset++) {
    							if(matrix[row + height - 1][col + offset] != '1') {
    								flag = false;
    								break;
    							}
    						}
    						if(flag) {
    							height = vertical + 1;
    						}
    					}
    					result = Math.max(result, width * height);
    				}
    			}
    		}
    	}
    	return result;
   } 
	@Test
	public void test() {
		assertEquals(2, maximalRectangle(new char[][]{{'1','1'}}));
	}

}
