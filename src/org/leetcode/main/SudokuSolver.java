package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		Map<Integer, List<Character>> matrixLeft = new HashMap<>();
		Map<Integer, List<Character>> rowLeft = new HashMap<>();
		Map<Integer, List<Character>> colLeft = new HashMap<>();
		int left = 81;
		for (int row = 0; row < 9; row++) {
			boolean[] bitSet = new boolean[9];
			List<Character> list = new ArrayList<>();
			for (int col = 0; col < 9; col++) {
				char current = board[row][col];
				if (current != '.') {
					bitSet[current - '1'] = true;
					left--;
				}
			}
			for (int i = 0; i < 9; i++) {
				if (!bitSet[i]) {
					list.add((char) ('1' + i));
				}
			}
			rowLeft.put(row, list);
		}

		for (int col = 0; col < 9; col++) {
			boolean[] bitSet = new boolean[9];
			List<Character> list = new ArrayList<>();
			for (int row = 0; row < 9; row++) {
				char current = board[row][col];
				if (current != '.') {
					bitSet[current - '1'] = true;
				}
			}
			for (int i = 0; i < 9; i++) {
				if (!bitSet[i]) {
					list.add((char) ('1' + i));
				}
			}
			colLeft.put(col, list);
		}

		for (int i = 0; i < 9; i++) {
			boolean[] bitSet = new boolean[9];
			List<Character> list = new ArrayList<>();
			for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
				for (int column = (i % 3) * 3; column < (i % 3) * 3 + 3; column++) {
					char current = board[row][column];
					if (current != '.') {
						bitSet[current - '1'] = true;
					}
				}
			}
			for (int index = 0; index < 9; index++) {
				if (!bitSet[index]) {
					list.add((char) ('1' + index));
				}
			}
			matrixLeft.put(i, list);
		}
		
		while(left > 0) {
			//find the most possible next number
			List<Character> options = null;
			int size = Integer.MAX_VALUE;
			for(int row = 0; row < 9; row++) {
				for(int col = 0; col < 9; col++) {
					char current = board[row][col];
					if(current == '.') {
						List<Character> tmp = getIntersect(rowLeft.get(row), colLeft.get(col));
						tmp = getIntersect(tmp, matrixLeft.get((row / 3) * 3 + (col / 3)));
						if(tmp.size() < size) {
							size = tmp.size();
							options = tmp;
						}
						if(tmp.size() == 1) {
   						}
					}
				}
			}
			
			
		}
	}

	private List<Character> getIntersect(List<Character> list1, List<Character> list2) {
		List<Character> result = new ArrayList<>();
		int[] count = new int[9];
		for(int i = 0; i < 9; i++) {
			count[list1.get(i) - '1']++;
			count[list2.get(i) - '1']++;
		}
		for(int i = 0; i < 9; i++) {
			if(count[i] == 2) {
				result.add((char) ('1' + i));
			}
		}
		return result;
	}
	@Test
	public void test() {
		System.out.println((char) ('1' + 0));
	}

}
