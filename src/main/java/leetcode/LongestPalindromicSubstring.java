package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubstring {

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

	public class ManacherSolution {
		public String longestPalindrome(String s) {
			char[] dummyChars = new char[2 * s.length() + 1];
			int[] p = new int[dummyChars.length];
			for (int i = 0; i < s.length(); i++) {
				dummyChars[i * 2] = '#';
				dummyChars[i * 2 + 1] = s.charAt(i);
			}
			dummyChars[dummyChars.length - 1] = '#';
			int bound = 0, center = 0, maxSize = 0, resCenter = 0;
			for (int i = 1; i < p.length - 1; i++) {
				int iMirror = 2 * center - i;
				p[i] = bound > i ? Math.min(bound - i, p[iMirror]) : 0;
				// try to increase p[i]
				while (i - 1 - p[i] >= 0 && i + 1 + p[i] < p.length
						&& dummyChars[i - 1 - p[i]] == dummyChars[i + 1 + p[i]]) 
					p[i]++;
				if (i + p[i] > bound) {
					bound = i + p[i];
					center = i;
				}
				if (p[i] > maxSize) {
					maxSize = p[i];
					resCenter = i;
				}
			}
			int start = (resCenter - maxSize) / 2;
			return s.substring(start, start + maxSize);
		}
	}
}
