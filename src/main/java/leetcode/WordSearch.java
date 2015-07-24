package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int rowSize = board.length, colSize = board[0].length;
		boolean[][] map = new boolean[rowSize][colSize];
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (search(board, word, 0, row, col, map)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, String word, int index, int row,
			int col, boolean[][] map) {
		if (index == word.length()) {
			return true;
		}
		boolean result = false;
		if (row < board.length && row >= 0 && col >= 0
				&& col < board[row].length) {
			if (!map[row][col] && board[row][col] == word.charAt(index)) {
				map[row][col] = true;
				result = search(board, word, index + 1, row + 1, col, map)
						|| search(board, word, index + 1, row, col + 1, map)
						|| search(board, word, index + 1, row - 1, col, map)
						|| search(board, word, index + 1, row, col - 1, map);
				map[row][col] = false;
			}
		}
		return result;
	}

	public class Solution {
		private char[][] board;
		private char[] chars;
		private boolean[][] visited;
		private int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, };

		public boolean exist(char[][] board, String word) {
			if (word == null)
				return false;
			this.board = board;
			visited = new boolean[board.length][board[0].length];
			chars = word.toCharArray();
			for (int row = 0; row < board.length; row++)
				for (int col = 0; col < board[0].length; col++)
					if (exist(row, col, 0))
						return true;
			return false;
		}

		private boolean exist(int row, int col, int index) {
			if (index == chars.length)
				return true;
			if (row >= 0 && row < board.length && col >= 0
					&& col < board[0].length && !visited[row][col]
					&& board[row][col] == chars[index]) {
				visited[row][col] = true;
				for (int[] dir : dirs) {
					if (exist(row + dir[0], col + dir[1], index + 1))
						return true;
				}
				visited[row][col] = false;
			}
			return false;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(false, sln.exist(new char[][] { { 'a' } }, "ab"));
	}

	@Test
	public void test1() {
		assertEquals(false, sln.exist(new char[][] { { 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' } },
				"aaaaaaaaaaaaa"));
	}

	@Test
	public void test2() {
		assertTrue(sln.exist(new char[][] { { 'a' } }, "a"));
	}

	@Test
	public void test3() {
		assertTrue(sln.exist(new char[][] { { 'a', 'a' } }, "aa"));
	}
}
