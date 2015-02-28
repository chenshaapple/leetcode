package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 1) {
			return strs[0];
		} else if(strs.length == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}
		for (int i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i) != c) {
					return result.toString();
				}
			}
			result.append(c);
		}
		return result.toString();
	}

	@Test
	public void test() {
		assertEquals("ab", longestCommonPrefix(new String[]{"abc", "abd"}));
	}

	@Test
	public void test115() {
		assertEquals("", longestCommonPrefix(new String[]{"aca", "cba"}));
	}
}
