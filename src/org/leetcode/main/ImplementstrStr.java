package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int i = 0, j = 0;
		int[] table = getNextArray(needle.toCharArray());
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else
                j = table[j]; // next[j]表示在j位置匹配出现不同的时候下一个匹配位置
        }

        return j == needle.length() ? i - j : -1;
	}

	private int[] getNextArray(char[] pattern) {
		int[] result = new int[pattern.length];
		result[0] = -1;
		int pos = 2;
		while (pos < pattern.length) {
			// the previous equals with its failure value
			if (pattern[pos - 1] == pattern[result[pos - 1]]) {
				result[pos] = result[pos - 1] + 1;
			} else {
				int jump = result[pos - 1];
				while (jump > 0 && pattern[pos - 1] != pattern[jump]) {
					jump = result[jump];
				}
				result[pos] = jump;
			}
			pos++;
		}
		return result;
	}

	private int[] kmp_table(char[] pattern) {
		int[] result = new int[pattern.length];
		result[0] = -1;
		if (pattern.length > 1) {
			result[1] = 0;
		}
		int pos = 2, cnd = 0;
		while (pos < pattern.length) {
			if (pattern[pos - 1] == pattern[cnd]) {
				cnd++;
				result[pos] = cnd;
				pos++;
			} else if (cnd > 0) {
				cnd = result[cnd];
			} else {
				result[pos] = 0;
				pos++;
			}
		}
		return result;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void test() {
	// assertTrue(Arrays.equals(new int[] { -1, 0, 0, 0, 0, 1, 2 },
	// kmp_table("ABCDABD".toCharArray())));
	// assertTrue(Arrays.equals(new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0,
	// 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0 },
	// kmp_table("PARTICIPATE IN PARACHUTE".toCharArray())));
	// }

	@Test
	public void testMyNext() {
		assertTrue(Arrays.equals(new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0,
				0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0 },
				getNextArray("PARTICIPATE IN PARACHUTE".toCharArray())));
	}

	@Test
	public void testMyNextEasyCase() {
		assertTrue(Arrays.equals(new int[] { -1, 0, 0, 0, 0, 1, 2 },
				getNextArray("ABCDABD".toCharArray())));
	}
}
