package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
	}

	@Test
	public void test2() {
		assertEquals(3, lengthOfLongestSubstring("dvdf"));
	}
}
