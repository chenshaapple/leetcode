package leetcode;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterleavingString {
	class Option {
		int s1;
		int s2;
		boolean isS1;

		public Option(int i1, int i2) {
			s1 = i1;
			s2 = i2;
		}
	}

	public class Solution {
		//������������
		public boolean isInterleave(String s1, String s2, String s3) {
			int s1Len = s1 != null ? s1.length() : 0;
			int s2Len = s2 != null ? s2.length() : 0;
			int s3Len = s3 != null ? s3.length() : 0;
			if (s3Len != s1Len + s2Len)
				return false;
			int i1 = 0, i2 = 0;
			Deque<Option> deque = new LinkedList<>();
			while (i1 < s1Len || i2 < s2Len) {
				boolean isS1 = i1 < s1Len ? s1.charAt(i1) == s3.charAt(i1 + i2)
						: false;
				boolean isS2 = i2 < s2Len ? s2.charAt(i2) == s3.charAt(i1 + i2)
						: false;
				if (isS1 || isS2) {
					if (isS1 && isS2) {
						deque.addLast(new Option(i1, i2 + 1));
						i1++;
					} else {
						if (isS1) {
							i1++;
						} else {
							i2++;
						}
					}
				} else {
					if(deque.isEmpty()) return false;
					Option opt = deque.pollLast();
					i1 = opt.s1;
					i2 = opt.s2;
				}
			}
			if (s3Len > 0
					&& i1 == s1Len
					&& i2 == s2Len
					&& (s1Len > 0
							&& s3.charAt(s3Len - 1) == s1.charAt(s1Len - 1) || s2Len > 0
							&& s3.charAt(s3Len - 1) == s1.charAt(s1Len - 1))) {
				return true;
			}
			return false;
		}
		
		public boolean isInterleave2(String s1, String s2, String s3) {
			int s1Len = s1 != null ? s1.length() : 0;
			int s2Len = s2 != null ? s2.length() : 0;
			int s3Len = s3 != null ? s3.length() : 0;
			if (s3Len != s1Len + s2Len)
				return false;
			if(s1Len == 0 && s2 != null) {
				return s2.equals(s3);
			}
			if(s2Len == 0 && s1 != null) {
				return s1.equals(s3);
			}
			boolean[][] opt = new boolean[s1Len + 1][s2Len + 1];
			for(int i = 0; i < s1Len; i++) {
				opt[i + 1][0] = s1.charAt(i) == s3.charAt(i);
			}
			for(int i = 0; i < s2Len; i++) {
				opt[0][i + 1] = s2.charAt(i) == s3.charAt(i);
			}
			for(int i1 = 1; i1 <= s1Len; i1++) {
				for(int i2 = 1; i2 <= s2Len; i2++) {
					opt[i1][i2] = opt[i1 -1][i2] && s1.charAt(i1 - 1) == s3.charAt(i1 + i2 - 1)
							|| opt[i1][i2 - 1] && s2.charAt(i2 - 1) == s3.charAt(i1 + i2 - 1);
				}
			}
			return opt[s1Len][s2Len];
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		assertEquals(sln.isInterleave(s1, s2, s3), sln.isInterleave2(s1, s2, s3));
	}
	
	@Test
	public void test1() {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "aaba";
		assertEquals(sln.isInterleave(s1, s2, s3), sln.isInterleave2(s1, s2, s3));
	}
	
	@Test
	public void test2() {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "abaa";
		assertEquals(sln.isInterleave(s1, s2, s3), sln.isInterleave2(s1, s2, s3));
	}
}
