package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
	}

	private boolean isMatch(char[] s, int index, char[] p, int offset) {
		if (offset == p.length) {
			return index == s.length;
		}
		if ((offset + 1 < p.length) && p[offset + 1] == '*') {
			while (index < s.length
					&& (s[index] == p[offset] || p[offset] == '.')) {
				if (isMatch(s, index, p, offset + 2)) {
					return true;
				}
				index++;
			}
			return isMatch(s, index, p, offset + 2);
		} else {
			if (index < s.length && (s[index] == p[offset] || p[offset] == '.')) {
				return isMatch(s, ++index, p, ++offset);
			}
		}
		return false;
	}

	public class Solution {
		public boolean isMatch(String s, String p) {
			boolean[][] opt = new boolean[s.length() + 1][p.length() + 1];
			opt[0][0] = true;
			for (int i = 1; i < p.length(); i++) {
				// means match 0 char
				if (p.charAt(i) == '*')
					opt[0][i + 1] = opt[0][i - 1];
			}
			for (int i = 1; i <= s.length(); i++) {
				for (int j = 1; j <= p.length(); j++) {
					char curr = p.charAt(j - 1);
					if (curr == '.') {
						opt[i][j] = opt[i - 1][j - 1];
					} else if (curr == '*') {
						// 0, 1, >1
						opt[i][j] = opt[i][j - 2]
								|| opt[i][j - 1]
								|| (opt[i - 1][j] && (p.charAt(j - 2) == '.' || s
										.charAt(i - 1) == p.charAt(j - 2)));
					} else {
						opt[i][j] = opt[i - 1][j - 1]
								&& s.charAt(i - 1) == curr;
					}
				}
			}
			return opt[s.length()][p.length()];
		}
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		assertEquals(true, sln.isMatch("aab", "c*a*b"));
	}

	@Test
	public void test6() {
		assertEquals(true, sln.isMatch("ab", ".*"));
	}

	@Test
	public void test5() {
		assertEquals(true, sln.isMatch("aa", ".*"));
	}

	@Test
	public void test4() {
		assertEquals(true, isMatch("aa", "a*"));
	}

	@Test
	public void test3() {
		assertEquals(false, sln.isMatch("aaa", "aa"));
	}

	@Test
	public void test2() {
		assertEquals(true, sln.isMatch("aa", "aa"));
	}

	@Test
	public void test1() {
		assertEquals(false, sln.isMatch("aa", "a"));
	}

	@Test
	public void test8() {
		assertEquals(true, sln.isMatch("a", "ab*"));
	}
}
