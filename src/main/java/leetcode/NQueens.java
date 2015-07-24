package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class NQueens {
	public class Solution {
		private List<String[]> res = new LinkedList<>();
		private int n;

		public List<String[]> solveNQueens(int n) {
			this.n = n;
			solveNQueens(new ArrayList<>(n));
			return res;
		}

		private void solveNQueens(List<Integer> solution) {
			if (solution.size() == n) {
				res.add(printSolution(solution));
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

		private String[] printSolution(List<Integer> sln) {
			String[] res = new String[n];
			for (int i = 0; i < sln.size(); i++) {
				char[] line = new char[n];
				Arrays.fill(line, '.');
				line[sln.get(i)] = 'Q';
				res[i] = String.valueOf(line);
			}
			return res;
		}
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		List<String[]> result = sln.solveNQueens(4);
		for (String[] solution : result) {
			System.out.println("solution:");
			for (String line : solution) {
				System.out.println(line);
			}
		}
		assertEquals(2, result.size());
	}
}
