package leetcode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IsomorphicStrings {
	public class Solution {
		public boolean isIsomorphic(String s, String t) {
			return convert(s).equals(convert(t));
		}

		private String convert(String s) {
			StringBuilder res = new StringBuilder();
			Map<Character, Integer> dict = new HashMap<>();
			for (Character c : s.toCharArray()) {
				if (!dict.containsKey(c))
					dict.put(c, dict.size());
				res.append(dict.get(c));
			}
			return res.toString();
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		String s = "ab", t = "aa";
		assertEquals(false, sln.isIsomorphic(s, t));
	}
}
