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
		if(rowSize == 0) {
			return result;
		}
		colSize = matrix[0].length;
		
		//make sure that, there is a 0-height rectangle
		int rectangleCount = Math.max(rowSize / 2 + 1, colSize / 2);
		for(int i = 0; i < rectangleCount; i++) {
			//right
			for(int col = i; col < colSize - i; col++) {
				result.add(matrix[i][col]);
			}
			//down
			for(int row = i + 1; row < rowSize - 1 - i; row++) {
				result.add(matrix[row][colSize - 1 - i]);
			}
			//left
			for(int col = colSize - 1 - i; col >= i && (rowSize - 1 - i != i); col--) {
				result.add(matrix[rowSize - 1 - i][col]);
			}
			//up
			for(int row = rowSize - 2 - i; row > i && (colSize - 1 - i != i); row--) {
				result.add(matrix[row][i]);
			}
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
	}

}
