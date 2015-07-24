package leetcode;

public class NumbsersOfIslands {
	public class Solution {
		int res, rowSize, colSize;
		int[] rowDir = { -1, +0, +1, +0 };
		int[] colDir = { +0, +1, +0, -1 };
		char[][] grid;
		public int numIslands(char[][] grid) {
			this.grid = grid;
			rowSize = grid.length;
			colSize = 0;
			if (rowSize != 0)
				colSize = grid[0].length;
	        for(int row = 0; row < rowSize; row++) 
        			for(int col = 0; col < colSize; col++) {
        			if(grid[row][col] == '1') {
        				//bfs
        				bfs(row, col);
        				res++;
        			}
        		}
			return res;
		}
		
		private void bfs(int row, int col) {
			if(grid[row][col] != '1') return;
			grid[row][col] = '0';
			for(int i = 0; i< rowDir.length; i++) {
				int adjRow = row + rowDir[i];
				int adjCol = col + colDir[i];
				if(adjRow >= 0 && adjRow < rowSize && adjCol >= 0 && adjCol < colSize)
					bfs(adjRow, adjCol);
			}
		}
	}
}
