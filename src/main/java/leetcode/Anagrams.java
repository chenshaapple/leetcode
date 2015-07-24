package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import javax.swing.text.DefaultEditorKit.CutAction;

public class Anagrams {
	public class Solution {
		private List<String> res = new LinkedList<>();
		private HashMap<Integer, String> dict = new HashMap<>();
		private Set<String> used = new HashSet<>();

		public List<String> anagrams(String[] strs) {
			for (String str : strs) {
				char[] chars = str.toCharArray();
				Arrays.sort(chars);
				int hashCode = String.valueOf(chars).hashCode();
				if (dict.containsKey(hashCode)) {
					if (!used.contains(dict.get(hashCode))) {
						res.add(dict.get(hashCode));
						used.add(dict.get(hashCode));
					}
					res.add(str);
				} else
					dict.put(hashCode, str);
			}
			return res;
		}

		public List<String> anagramsLambda(String[] strs) {
			List<String> res = new LinkedList<>();
			Arrays.asList(strs)
					.parallelStream()
					.collect(
							Collectors.groupingBy(str -> {
								char[] chars = str.toCharArray();
								Arrays.sort(chars);
								return String.valueOf(chars);
							}))
					.forEach((key, value) -> {
						if (value.size() > 1)
							res.addAll(value);
					});
			;
			return res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		String[] strs = new String[] { "", "" };
		assertEquals(Arrays.toString(strs), sln.anagrams(strs).toString().trim());
	}
	
	@Test
	public void test1() {
		String string = "c80b6531021b809dcf2de90a3bdf6e45493197c2305c64698b80562b3ee01d40";
		System.out.println(UUID.fromString(string));
		System.out.println(string.length());
		
	}
}
