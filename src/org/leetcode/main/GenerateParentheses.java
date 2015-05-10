package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class GenerateParentheses {
	public class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> res = new LinkedList<>();
			generateParenthesis(res, new StringBuilder(), n, n);
			return res;
		}

		private void generateParenthesis(List<String> res, StringBuilder item,
				int left, int right) {
			if(right == 0) {
				res.add(item.toString());
				return;
			}
			if(left > 0) {
				item.append('(');
				generateParenthesis(res, item, left - 1, right);
				item.deleteCharAt(item.length() - 1);
			}
			if(left < right) {
				item.append(')');
				generateParenthesis(res, item, left, right - 1);
				item.deleteCharAt(item.length() - 1);
			}
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		List<String> result = sln.generateParenthesis(3);
		System.out.println(result);
		assertEquals(5, result.size());
	}
}
