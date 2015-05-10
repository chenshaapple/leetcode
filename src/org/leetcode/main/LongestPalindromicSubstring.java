package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String result = "";
		int maxLength = 0;
		for (int i = 0; i < s.length() * 2 - 1; i++) {
			String palindrome = longestPalindrome(s, i);
			if (palindrome.length() > maxLength) {
				maxLength = palindrome.length();
				result = palindrome;
			}
		}
		return result;
	}

	private String longestPalindrome(String s, int center) {
		int left = center / 2, right = left;
		if (center % 2 > 0) {
			right += 1;
		}
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	public class Solution {
		public String longestPalindrome(String s) {
			String res = "";
			for (int i = 0; i < 2 * s.length() - 1; i++) {
				String palindrome = longestPalindrome(s, i);
				if (palindrome.length() > res.length())
					res = palindrome;
			}
			return res;
		}

		private String longestPalindrome(String s, int core) {
			int left = core / 2, right = core % 2 > 0 ? left + 1 : left;
			while (left >= 0 && right < s.length()
					&& s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			return s.substring(left + 1, right);
		}
	}

	@Test
	public void test() {
		System.out.println(longestPalindrome("abcba"));
	}

}
