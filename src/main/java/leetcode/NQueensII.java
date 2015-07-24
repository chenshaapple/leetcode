package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NQueensII {
	public int totalNQueens(int n) {
		List<List<List<Integer>>> result = new ArrayList<>();
		solveNQueens(result, new ArrayList<>(), n, n);
		return result.size();
	}

	private void solveNQueens(List<List<List<Integer>>> result,
			List<List<Integer>> solution, int leftQ, int n) {
		if (leftQ == 0) {
			result.add(new ArrayList<>(solution));
			return;
		}
		List<Integer> queen = new ArrayList<>();
		int index = n - leftQ;
		queen.add(index);
		for (int i = 0; i < n; i++) {
			queen.add(i);
			solution.add(queen);
			if (isValid(solution)) {
				solveNQueens(result, solution, leftQ - 1, n);
			}
			solution.remove(index);
			queen.remove(1);
		}
	}

	private boolean isValid(List<List<Integer>> solution) {
		List<Integer> newQueen = solution.get(solution.size() - 1);
		int row = newQueen.get(0);
		int col = newQueen.get(1);
		for (int i = 0; i < solution.size() - 1; i++) {
			int prevQueenRow = solution.get(i).get(0);
			int prevQueenCol = solution.get(i).get(1);
			if (prevQueenRow == row
					|| prevQueenCol == col
					|| Math.abs(prevQueenCol - col) == Math.abs(prevQueenRow
							- row)) {
				return false;
			}
		}
		return true;
	}
	
	public class Solution {
		private int n;
		private int res;
	    public int totalNQueens(int n) {
	        this.n = n;
	        for(int i = 0; i < (n + 1) / 2; i++) {
	        		List<Integer> sln = new ArrayList<>(n);
	        		sln.add(i);
	        		solveNQueens(sln);
	        }
	        return res;
	    }
	    
		private void solveNQueens(List<Integer> solution) {
			if (solution.size() == n) {
				if(n % 2 != 0 && solution.get(0) == n / 2)
					res++;
				else
					res += 2;
				return;
			}
			for (int i = 0; i < n; i++) {
				solution.add(i);
				if (isValid(solution))
					solveNQueens(solution);
				solution.remove(solution.size() - 1);
			}
		}

		private boolean isValid(List<Integer> sln) {
			int row = sln.size() - 1, col = sln.get(row);
			for (int i = 0; i < row; i++) {
				if (sln.get(i) == col
						|| Math.abs(i - row) == Math.abs(sln.get(i) - col))
					return false;
			}
			return true;
		}
	}

	@Test
	public void test() {
		assertEquals(2, totalNQueens(4));
	}

}
