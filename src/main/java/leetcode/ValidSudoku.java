package leetcode;

import static org.junit.Assert.assertTrue;

import java.util.BitSet;

import org.junit.Test;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //check by column
    		for(int row = 0; row < 9; row++){
    			char[] dictionary = new char[10];
    			for(int column = 0; column < 9; column++) {
    				char current = board[row][column];
    				if(current != '.') {
    					if(dictionary[current - '0'] == current) {
    						return false;
    					} else {
    						dictionary[current - '0'] = current;
    					}
    				}
    				
    			}
    		}
    		for(int column = 0; column < 9; column++){
    			char[] dictionary = new char[10];
    			for(int row = 0; row < 9; row++) {
    				char current = board[row][column];
    				if(current != '.') {
    					if(dictionary[current - '0'] == current) {
    						return false;
    					} else {
    						dictionary[current - '0'] = current;
    					}
    				}
    				
    			}
    		}
    		//check by slice
    		for(int i = 0; i < 9; i++) {
    			char[] dictionary = new char[10];
    			for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
    				for(int column = (i % 3) * 3; column < (i % 3) * 3 + 3; column++){
    					char current = board[row][column];
        				if(current != '.') {
        					if(dictionary[current - '0'] == current) {
        						return false;
        					} else {
        						dictionary[current - '0'] = current;
        					}
        				}
    				}
    		}
    		return true;
    }
    
    public class Solution {
        public boolean isValidSudoku(char[][] board) {
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
    
	@Test
	public void test() {
		System.out.println((char)('0' + 9));
		assertTrue(isValidSudoku(new char[][]{
				{'.','.','5','.','.','.','.','.','6'},
				{'.','.','.','.','1','4','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','9','2','.','.'},
				{'5','.','.','.','.','2','.','.','.'},
				{'.','.','.','.','.','.','.','3','.'},
				{'.','.','.','5','4','.','.','.','.'},
				{'3','.','.','.','.','.','4','2','.'},
				{'.','.','.','2','7','.','6','.','.'}
		}));
	}

}
