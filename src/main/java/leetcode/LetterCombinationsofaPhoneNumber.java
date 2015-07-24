package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public class Solution {
		private Map<Integer, List<Character>> dict = new HashMap<>();
		{
			char init = 'a';
			for (int i = 2; i < 10; i++) {
				List<Character> list = new LinkedList<>();
				for (int j = 0; j < 3; j++)
					list.add(init++);
				if (i == 7 || i == 9)
					list.add(init++);
				dict.put(i, list);
			}
		}

		public List<String> letterCombinations(String digits) {
			List<String> res = new LinkedList<>();
			char[] chars = digits.toCharArray();
			List<List<Character>> list = new LinkedList<>();
			for (char c : chars)
				list.add(dict.get(c - '0'));
			letterCombinations(res, new StringBuilder(), list, 0);
			return res;
		}

		private void letterCombinations(List<String> res,
				StringBuilder builder, List<List<Character>> list, int index) {
			if (index == list.size()) {
				res.add(builder.toString());
				return;
			}
			for (Character c : list.get(index)) {
				builder.append(c);
				letterCombinations(res, builder, list, index + 1);
				builder.deleteCharAt(builder.length() - 1);
			}
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		List<String> result = sln.letterCombinations("23");
		for (String str : result) {
			System.out.println(str);
		}
	}

}
