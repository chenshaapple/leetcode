package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImplementstrStr {

	/**
	 * implement the Sunday algorithm
	 * 
	 * @param haystack
	 * @param needle
	 *            the pattern string
	 * @return
	 */
	public int strStrSunday(String haystack, String needle) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int j = 0; j < needle.length(); j++) {
			Character c = needle.charAt(j);
			map.put(c, j);
		}
		int i = 0;
		while (i < haystack.length()) {
			char c = haystack.charAt(i);
			if (map.containsKey(c)) {
				int tmp = i - map.get(c);
				if (tmp >= 0 && tmp + needle.length() <= haystack.length()) {
					if (haystack.substring(tmp, tmp + needle.length()).equals(
							needle))
						return tmp;
				}
				i++;
			} else {
				i += Math.max(needle.length(), 1);
			}
		}
		return -1;
	}

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
				j = table[j];
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

	public class Solution {
	    public int strStr(String haystack, String needle) {
	    		if(needle.length() == 0) return 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i < needle.length(); i++)
	        		map.put(needle.charAt(i), i);
	        	for(int i = 0; i < haystack.length();) {
	        		Character curr = haystack.charAt(i);
	        		if(map.containsKey(curr)) {
	        			int tmp = i - map.get(curr);
	        			if(tmp >= 0 && tmp + needle.length() <= haystack.length()) {
	        				if(haystack.substring(tmp, tmp + needle.length()).equals(needle))
	        					return tmp;
	        			}
	        			i++;
	        		} else
	        			i += needle.length();
	        	}
	        return -1;
	    }
	}
	@Test
	public void test1() {
		String haystack = "aaa", needle = "aaa";
		assertEquals(strStr(haystack, needle), strStrSunday(haystack, needle));
	}

	@Test
	public void test2() {
		String haystack = "mississippi", needle = "issip";
		assertEquals(strStr(haystack, needle), strStrSunday(haystack, needle));
	}

	@Test
	public void test3() {
		String haystack = "mississippi", needle = "issi";
		assertEquals(strStr(haystack, needle), strStrSunday(haystack, needle));
	}
}
