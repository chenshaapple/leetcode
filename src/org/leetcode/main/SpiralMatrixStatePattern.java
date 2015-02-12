package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/*
 * 思路：Naive，以element为单位进行遍历，尝试用状态模式去完成
 * 目前的move是去试探下一个点是否可以访问，如果可以，则标记为已访问，否则改变方向
 * 	存在的问题：因为不访问当前点，所以需要在初始化的时候标记第一个点
 * 更好的方式是先尝试标记当前点，再移动到下一个点，如果当前方向不存在，则改变方向 
 */
public class SpiralMatrixStatePattern {
	int[][] matrix;
	int row, col, rowSize, colSize, count;
	boolean[][] map;
	Direction direction;
	List<Integer> result = new LinkedList<>();
	enum Direction {
		Right() {
			@Override
			void move(SpiralMatrixStatePattern matrix) {
				if(matrix.col == matrix.colSize - 1) {
					matrix.direction = Down;
				} else {
					if(!matrix.map[matrix.row][matrix.col + 1]) {
						matrix.col++;
						matrix.count++;
						matrix.result.add(matrix.matrix[matrix.row][matrix.col]);
						matrix.map[matrix.row][matrix.col] = true;
					} else {
						matrix.direction = Down;
					}
				}
			}
			
		}, Down() {

			void move(SpiralMatrixStatePattern matrix) {
				if(matrix.row == matrix.rowSize - 1) {
					matrix.direction = Left;
				} else {
					if(!matrix.map[matrix.row + 1][matrix.col]) {
						matrix.row++;
						matrix.count++;
						matrix.result.add(matrix.matrix[matrix.row][matrix.col]);
						matrix.map[matrix.row][matrix.col] = true;
					} else {
						matrix.direction = Left;
					}
				}
			}
			
		}, Left() {

			@Override
			void move(SpiralMatrixStatePattern matrix) {
				if(matrix.col == 0) {
					matrix.direction = Up;
				} else {
					if(!matrix.map[matrix.row][matrix.col - 1]) {
						matrix.col--;
						matrix.count++;
						matrix.result.add(matrix.matrix[matrix.row][matrix.col]);
						matrix.map[matrix.row][matrix.col] = true;
					} else {
						matrix.direction = Up;
					}
				}
			}
			
		}, Up() {

			@Override
			void move(SpiralMatrixStatePattern matrix) {
				if(matrix.row == 0) {
					matrix.direction = Right;
				} else {
					if(!matrix.map[matrix.row - 1][matrix.col]) {
						matrix.row--;
						matrix.count++;
						matrix.result.add(matrix.matrix[matrix.row][matrix.col]);
						matrix.map[matrix.row][matrix.col] = true;
					} else {
						matrix.direction = Right;
					}
				}
				
			}
			
		};
		abstract void move(SpiralMatrixStatePattern matrix);
	}
	
	private void move() {
		direction.move(this);
	}
    public List<Integer> spiralOrder(int[][] matrix) {
    	this.rowSize = matrix.length;
    	if(rowSize == 0) {
    		return result;
    	}
    	this.colSize = matrix[0].length;
    	this.matrix = matrix;
    	this.map = new boolean[rowSize][colSize];
    	this.row = this.col = 0;
    	this.count = 1;
    	this.result.add(matrix[row][col]);
    	map[row][col] = true;
    	this.direction = Direction.Right;
    	
    	while(count < rowSize * colSize) {
    		move();
    	}

    	return result;
    }
	@Test
	public void test() {
		System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
	}

}
