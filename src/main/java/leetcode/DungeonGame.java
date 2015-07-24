package leetcode;

import java.util.Optional;

import org.junit.Test;

public class DungeonGame {
	public class Solution {
	    public int calculateMinimumHP(int[][] dungeon) {
	    		int rowSize = dungeon.length, colSize = dungeon[0].length;
	    		int[][] opt = new int[rowSize][colSize];
	        for(int row = rowSize - 1; row >= 0; row--)
	        		for(int col = colSize - 1; col >= 0; col--) {
	        			int down = 0, right = 0, next = 1;
	        			opt[row][col] = Math.max(1, 1 - dungeon[row][col]);
	        			if(row + 1 < rowSize)
	        				down = opt[row + 1][col] - dungeon[row][col];
	        			if(col + 1 < colSize)
	        				right = opt[row][col + 1] - dungeon[row][col];
	        			if(down != 0 && right != 0)
	        				next = Math.min(down, right);
	        			else if(down != 0)
	        				next = down;
	        			else if(right != 0)
	        				next = right;
	        			next = Math.max(1, next);
	        			opt[row][col] = Math.max(1 - dungeon[row][col], next);
	        		}
	        return opt[0][0];
	    }
	}
	
	Solution sln = new Solution();
	@Test
	public void case1() {
		int[][] dungeon = {{0, -3}};
		System.out.println(sln.calculateMinimumHP(dungeon));
	}
}
