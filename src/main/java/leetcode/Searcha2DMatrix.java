package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length, colSize = 0;
        if(rowSize == 0) {
        	return false;
        }
        colSize = matrix[0].length;
        int begin = 0, end = rowSize * colSize - 1;
        while(begin <= end) {
        	int mid = (begin + end) / 2;
        	int value = matrix[mid / colSize][mid % colSize];
        	if(value == target) {
        		return true;
        	} else if(value < target) {
        		begin = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
    	return false;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
