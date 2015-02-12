package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int rowSize = board.length, colSize = board[0].length;
		boolean[][] map = new boolean[rowSize][colSize];
		for(int row = 0; row < rowSize; row++) {
			for(int col = 0; col < colSize; col++) {
				if(search(board, word, 0, row, col, map)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean search(char[][] board, String word, int index, int row, int col, boolean[][] map) {
		if(index == word.length()) {
			return true;
		}
		boolean result = false;
		if(row < board.length && row >= 0 && col >=0 && col < board[row].length) {
			if(!map[row][col] && board[row][col] == word.charAt(index)) {
				map[row][col] = true;
				result = search(board, word, index + 1, row + 1, col, map) ||
						search(board, word, index + 1, row, col + 1, map) ||
						search(board, word, index + 1, row - 1, col, map) ||
						search(board, word, index + 1, row, col - 1, map);
				map[row][col] = false;
			}
		}
		return result;
	}

	@Test
	public void test() {
		assertEquals(false, exist(new char[][]{{'a'}}, "ab"));
	}

	@Test
	public void test1() {
		assertEquals(false, exist(new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}}, "aaaaaaaaaaaaa"));
	}
}
