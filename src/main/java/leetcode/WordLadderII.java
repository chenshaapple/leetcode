package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WordLadderII {
	public class Solution {
		private List<List<String>> res = new ArrayList<>();
		private String end;
		private int len;
		private int distance = Integer.MAX_VALUE;

		public List<List<String>> findLadders(String start, String end, Set<String> dict) {
			len = start.length();
			this.end = end;
			dict.add(end);
			findLadders(start, new ArrayList<>(), dict);
			res.forEach(l -> l.add(0, start));
			return res;
		}

		private void findLadders(String curr, List<String> item, Set<String> dict) {
			if (item.size() > distance || dict.isEmpty())
				return;
			if (curr.equals(end)) {
				if (res.size() == 0)
					distance = item.size();
				if (item.size() < distance) {
					res.clear();
					distance = item.size();
				}
				res.add(item);
				return;
			}

			char[] chars = curr.toCharArray();
			for (int i = 0; i < len; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != chars[i]) {
						chars[i] = c;
						String next = String.valueOf(chars);
						if (dict.contains(next)) {
							Set<String> nextDict = new HashSet<>(dict);
							nextDict.remove(next);
							List<String> nextItem = new ArrayList<>(item);
							nextItem.add(next);
							findLadders(next, nextItem, nextDict);
						}
					}
				}
			}
		}
	}

	private Solution sln = new Solution();

	@Test
	public void case1() {
		String start = "qa", end = "sq";
		Set<String> dict = new HashSet<>(Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt",
				"db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti",
				"ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re",
				"or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
				"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
				"hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc",
				"ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa",
				"he", "lr", "sq", "ye"));
		List<List<String>> ladder = sln.findLadders(start, end, dict);
		System.out.println(ladder.size());
		ladder.forEach(l -> System.out.println(l));
	}
}
