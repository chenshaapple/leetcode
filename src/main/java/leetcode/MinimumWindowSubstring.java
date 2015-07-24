package leetcode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MinimumWindowSubstring {
	public class Solution {
		public String minWindow(String s, String t) {
			Map<Character, Integer> dict = new HashMap<>();
			for (Character c : t.toCharArray()) {
				dict.computeIfPresent(c, (k, v) -> v + 1);
				dict.putIfAbsent(c, 1);
			}
			int start = 0, minSize = Integer.MAX_VALUE, count = 0, lStart = 0;
			StringBuilder res = new StringBuilder(s);
			for (int end = 0; end < s.length(); end++) {
				Character curr = s.charAt(end);
				if (dict.containsKey(curr)) {
					if (dict.get(curr) > 0)
						count++;
					dict.put(curr, dict.get(curr) - 1);
					while (count == t.length() && lStart <= end) {
						Character cStart = s.charAt(lStart);
						if (dict.containsKey(cStart)) {
							if (end - lStart < minSize) {
								start = lStart;
								minSize = end - lStart;
							}
							if (dict.get(cStart) == 0)
								count--;
							dict.put(cStart, dict.get(cStart) + 1);
						}
						lStart++;
					}
				}
			}
			if (minSize > s.length())
				return "";
			return res.substring(start, start + minSize + 1);
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals("sk_not_what_your_c",
				sln.minWindow(
						"ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country",
						"ask_country"));
	}

	@Test
	public void testEasy() {
		assertEquals("BANC", sln.minWindow("ADOBECODEBANC", "ABC"));
	}

	@Test
	public void testA() {
		assertEquals("a", sln.minWindow("a", "a"));
	}

	@Test
	public void case1() {
		assertEquals("ab", sln.minWindow("bdab", "ab"));
	}
}
