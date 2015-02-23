package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}

	private boolean solveSudoku(char[][] board, int row, int col) {
		if (row == board.length) {
			return true;
		}
		int nextRow = col < 8 ? row : row + 1;
		int nextCol = col < 8 ? col + 1 : 0;
		if (board[row][col] != '.') {
			return solveSudoku(board, nextRow, nextCol);
		}
		List<Character> options = getAvailable(board, row, col);
		for (Character c : options) {
			board[row][col] = c;
			if(solveSudoku(board, nextRow, nextCol)) {
				return true;
			}
			board[row][col] = '.';
		}
		return false;
	}
	
	//本来以为这个方法的出现是一种优化，没想到更慢。。
	//直接尝试1-9再检测是否valid更快
	private List<Character> getAvailable(char[][] board, int row, int col) {
		List<Character> result = new ArrayList<>();
		BitSet bitSet = new BitSet(9);
		for (int i = 0; i < 9; i++) {
			char current = board[row][i];
			if (current == '.') {
				continue;
			}
			bitSet.set(current - '1');
		}
		// check this column
		for (int i = 0; i < 9; i++) {
			char current = board[i][col];
			if (current == '.') {
				continue;
			}
			bitSet.set(current - '1');
		}
		// check this matrix
		for (int _row = row / 3 * 3; _row < row / 3 * 3 + 3; _row++) {
			for (int _col = col / 3 * 3; _col < col / 3 * 3 + 3; _col++) {
				char current = board[_row][_col];
				if (current == '.') {
					continue;
				}
				bitSet.set(current - '1');
			}
		}
		for (int i = 0; i < 9; i++) {
			if (!bitSet.get(i)) {
				result.add((char) (i + '1'));
			}
		}
		return result;
	}


	@Test
	public void test() {
		char[][] board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solveSudoku(board);
		print(board);
	}

	private void print(char[][] board) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				System.out.print(board[row][col]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
