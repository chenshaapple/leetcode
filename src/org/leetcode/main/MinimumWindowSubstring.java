package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		String res = "";
		Map<Character, Integer> dict = new HashMap<>();
		for (Character c : T.toCharArray()) {
			if (dict.containsKey(c)) {
				dict.put(c, dict.get(c) + 1);
			} else {
				dict.put(c, Integer.valueOf(1));
			}
		}
		int count = 0, minWidth = Integer.MAX_VALUE, lStart = 0;
		// 遍历所有的窗口可能
		for (int end = 0; end < S.length(); end++) {
			Character curt = S.charAt(end);
			if (dict.containsKey(curt)) {
				if (dict.get(curt) > 0) {
					count++;
				}
				dict.put(curt, dict.get(curt) - 1);
				// 从左端开始缩小窗口，找到当前最小的窗口
				while (count == T.length() && lStart <= (end - T.length() + 1)) {
					Character begin = S.charAt(lStart);
					if ((end - lStart + 1) <= minWidth) {
						res = S.substring(lStart, end + 1);
						minWidth = res.length();
					}
					if (dict.containsKey(begin)) {
						dict.put(begin, dict.get(begin) + 1);
						if(dict.get(begin) > 0) {
							count--;
						}
					}
					lStart++;
				}
			}
		}
		return res;
	}

	public String minWindowRecursive(String S, String T) {
		return getWindow(S, T.toCharArray());
	}

	private String getWindow(String S, char[] T) {
		if (S.length() < T.length) {
			return "";
		}
		boolean flag = true;
		for (char t : T) {
			if (!S.contains(String.valueOf(t))) {
				flag = false;
				break;
			}
		}
		if (flag) {
			String right = getWindow(S.substring(1), T);
			String left = getWindow(S.substring(0, S.length() - 1), T);
			if (left.equals("") && right.equals("")) {
				return S;
			}
			if (left.equals("")) {
				return right;
			} else if (right.equals("")) {
				return left;
			}
			return left.length() < right.length() ? left : right;
		}
		return "";
	}

	public String minWindowDeprecated(String S, String T) {
		int left = 0, right = 0;
		List<String> windows = new LinkedList<>();
		char[] chars = T.toCharArray();
		// boolean[] map = new boolean[256];
		Map<Character, Boolean> map = new HashMap<>();
		String result = "";
		int min = Integer.MAX_VALUE;
		for (char character : chars) {
			map.put(character, true);
		}
		int rightBorder = S.length() - T.length();
		for (; left < rightBorder; left++) {
			if (!map.containsKey(S.charAt(left))) {
				continue;
			}
			String match = "";
			for (right = left + T.length() - 1; right < S.length(); right++) {
				if (!map.containsKey(S.charAt(right))) {
					continue;
				}
				match = S.substring(left, right + 1);
				if (checkWindow(match, chars)) {
					windows.add(match);
					break;
				}
			}
		}

		for (String window : windows) {
			System.out.println(window);
			if (window.length() < min) {
				min = window.length();
				result = window;
			}
		}
		return result;
	}

	private boolean checkWindow(String s, char[] chars) {
		for (char character : chars) {
			boolean tmp = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == character) {
					tmp = true;
					break;
				}
			}
			if (!tmp) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		assertEquals(
				"sk_not_what_your_c",
				minWindow(
						"ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country",
						"ask_country"));
	}

	@Test
	public void testEasy() {
		assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
	}
	
	@Test
	public void testA() {
		assertEquals("a", minWindow("a", "a"));
	}

}
