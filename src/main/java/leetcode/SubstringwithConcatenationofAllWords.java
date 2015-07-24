package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SubstringwithConcatenationofAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new LinkedList<>();
		int wordLength = L[0].length();
		int gap = wordLength * L.length;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < L.length; i++) {
			if (!map.containsKey(L[i])) {
				map.put(L[i], 1);
			} else {
				map.put(L[i], map.get(L[i]) + 1);
			}
		}
		Map<String, Integer> visitMap = new HashMap<>(map);
		int index = 0;
		while (index <= (S.length() - gap)) {
			for (int i = 0; i < L.length; i++) {
				String word = S.substring(index + i * wordLength, index
						+ (i + 1) * wordLength);
				if (visitMap.containsKey(word)) {
					if (visitMap.get(word) > 1) {
						visitMap.put(word, visitMap.get(word) - 1);
					} else {
						visitMap.remove(word);
					}
				} else {
					break;
				}
			}
			if (visitMap.isEmpty()) {
				result.add(index);
			}
			visitMap = new HashMap<>(map);
			index++;
		}
		return result;
	}

	public class Solution {
		private int wordLen;
		private int size;

		public List<Integer> findSubstring(String s, String[] words) {
			List<Integer> res = new LinkedList<>();
			if (words.length == 0)
				return res;
			wordLen = words[0].length();
			size = words.length;
			Map<String, Integer> dict = new HashMap<>();
			for (String word : words) {
				int value = dict.get(word) != null ? dict.get(word)
						: initValue();
				dict.put(word, value + 1);
			}
			for (int i = 0; i <= s.length() - wordLen * size; i++) {
				if (isSubstring(s.substring(i, i + wordLen * size), dict))
					res.add(i);
			}
			return res;
		}

		private int initValue() {
			return -1;
		}

		private boolean isSubstring(String s, Map<String, Integer> dict) {
			Map<String, Integer> tmp = new HashMap<>(dict);
			for (int i = 0; i < size; i++) {
				String word = s.substring(i * wordLen, i * wordLen + wordLen);
				if (!tmp.containsKey(word) || tmp.get(word) <= initValue())
					return false;
				tmp.put(word, tmp.get(word) - 1);
			}
			return true;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(
				Arrays.asList(0, 9),
				sln.findSubstring("barfoothefoobarman", new String[] { "foo",
						"bar" }));
	}

	@Test
	public void test1() {
		assertEquals(Arrays.asList(0),
				sln.findSubstring("a", new String[] { "a" }));
	}

	@Test
	public void test2() {
		assertEquals(Arrays.asList(0, 2, 4),
				sln.findSubstring("abababab", new String[] { "a", "b", "a" }));
	}

}
