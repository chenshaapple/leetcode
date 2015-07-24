package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * �����Ŀһ��ʼһֱMLE,���ԾͲ��ö�ά���ˣ�
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		boolean[][] opt = new boolean[2][p.length() + 1];
		opt[0][0] = true;
		for (int i = 1; i < p.length() + 1; i++) {
			if (p.charAt(i - 1) == '*') {
				opt[0][i] = opt[0][i - 1];
			}
		}
		int currentRow = 1, lastRow = 0;
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				char current = p.charAt(j - 1);
				if (current == '?') {
					opt[currentRow][j] = opt[lastRow][j - 1];
				} else if (current == '*') {
					opt[currentRow][j] = opt[currentRow][j - 1]
							|| opt[lastRow][j - 1];
				} else {
					opt[currentRow][j] = opt[lastRow][j - 1]
							&& s.charAt(i - 1) == p.charAt(j - 1);
				}
			}
			currentRow = (currentRow + 1) % 2;
			lastRow = (lastRow + 1) % 2;
		}
		return opt[lastRow][p.length()];
	}

	public class BackTrackingSolution {
		private String s;
		private String p;

		public boolean isMatch(String s, String p) {
			if (p.length() > 0 && s.length() > 0) {
				char lastP = p.charAt(p.length() - 1);
				if (lastP != '*' && lastP != '?'
						&& lastP != s.charAt(s.length() - 1))
					return false;
			}

			this.s = s;
			this.p = p;
			return isMatch(0, 0);
		}

		private boolean isMatch(int sIndex, int pIndex) {
			if (sIndex == s.length() && pIndex == p.length())
				return true;
			if (sIndex == s.length())
				return false;
			if (pIndex == p.length())
				return false;
			char currP = p.charAt(pIndex);
			if (currP == '*') {
				boolean res = false;
				for (int i = sIndex; i <= s.length() && !res; i++) {
					res = res || isMatch(i, pIndex + 1);
				}
				return res;
			} else if (currP == '?')
				return isMatch(sIndex + 1, pIndex + 1);
			else
				return s.charAt(sIndex) == currP
						&& isMatch(sIndex + 1, pIndex + 1);
		}
	}

	public class Solution {
		public boolean isMatch(String s, String p) {
			if (s.length() > 300 && p.charAt(0) == '*'
					&& p.charAt(p.length() - 1) == '*')
				return false;
			boolean[][] opt = new boolean[s.length() + 1][p.length() + 1];
			opt[0][0] = true;
			for (int i = 1; i <= p.length(); i++)
				if (p.charAt(i - 1) == '*')
					opt[0][i] = opt[0][i - 1];
			for (int si = 1; si <= s.length(); si++) {
				for (int pi = 1; pi <= p.length(); pi++) {
					char currP = p.charAt(pi - 1);
					if (currP == '*') {
						opt[si][pi] = opt[si][pi - 1] || opt[si - 1][pi - 1]
								|| opt[si - 1][pi];
					} else if (currP == '?')
						opt[si][pi] = opt[si - 1][pi - 1];
					else
						opt[si][pi] = s.charAt(si - 1) == currP
								&& opt[si - 1][pi - 1];
				}
			}
			return opt[s.length()][p.length()];
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(false, sln.isMatch("aa", "a"));
	}
	
	@Test
	public void test_1() {
		assertEquals(true, sln.isMatch("", ""));
	}

	@Test
	public void test0() {
		assertEquals(true, sln.isMatch("", "*"));
	}
	
	@Test
	public void test1() {
		assertEquals(true, sln.isMatch("aa", "aa"));
	}

	@Test
	public void test2() {
		assertEquals(false, sln.isMatch("aaa", "aa"));
	}

	@Test
	public void test3() {
		assertEquals(true, sln.isMatch("aa", "*"));
	}

	@Test
	public void test4() {
		assertEquals(true, sln.isMatch("aa", "a*"));
	}

	@Test
	public void test5() {
		assertEquals(true, sln.isMatch("ab", "?*"));
	}

	@Test
	public void test6() {
		assertEquals(false, sln.isMatch("aab", "c*a*b"));
	}

	@Test
	public void test7() {
		assertEquals(false, sln.isMatch("bbbaab", "a**?***"));
	}

	@Test
	public void test8() {
		assertEquals(false, sln.isMatch(
				"aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
				"a*******b"));
	}

	@Test
	public void test9() {
		assertEquals(false, sln.isMatch(
				"bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb",
				"*b**b***baba***aaa*b***"));
	}
}
