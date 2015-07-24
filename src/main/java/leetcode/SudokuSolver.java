package leetcode;

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
	
	//������Ϊ��������ĳ�����һ���Ż���û�뵽��������
	//ֱ�ӳ���1-9�ټ���Ƿ�valid����
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

	public class Solution {
		private char[][] board;
		
	    public void solveSudoku(char[][] board) {
	    		this.board = board;
	        solveSudoku(0);
	    }
	    
	    private boolean solveSudoku(int begin) {
	    		if(begin == 81) return true;
	    		int row = begin / 9, col = begin % 9;
	    		if(board[row][col] != '.') return solveSudoku(begin + 1);
	    		for(char opt = '1'; opt <= '9'; opt++) {
	    			board[row][col] = opt;
	    			if(isValidSudoku(board) && solveSudoku(begin + 1))
	    				return true;
	    			board[row][col] = '.'; 
	    		}
	    		return false;
	    }
	    
        private boolean isValidSudoku(char[][] board) {
            for(int row = 0; row < 9; row++) {
            		BitSet rowSet = new BitSet(9);
            		BitSet colSet = new BitSet(9);
            		for(int col = 0;col < 9; col++) {
            			if(board[row][col] != '.') {
	            			int colCurr = board[row][col] - '1';
	            			if(colSet.get(colCurr))
	            				return false;
	            			colSet.set(colCurr);
            			}
            			if(board[col][row] != '.') {
	            			int rowCurr = board[col][row] - '1';
	            			if(rowSet.get(rowCurr))
	            				return false;
	            			rowSet.set(rowCurr);
            			}
            		}
            }
            for(int block = 0; block < 9; block++) {
            		BitSet blockSet = new BitSet(9);
            		for(int row = (block / 3) * 3; row < (block / 3) * 3 + 3; row++) {
            			for(int col = (block % 3) * 3; col < (block % 3) * 3 + 3; col++) {
            				if(board[row][col] == '.') continue;
            				int blockCurr = board[row][col] - '1';
            				if(blockSet.get(blockCurr))
            					return false;
            				blockSet.set(blockCurr);
            			}
            		}
            }
            return true;
        }
	}
	
	private Solution sln = new Solution();
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
		sln.solveSudoku(board);
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
