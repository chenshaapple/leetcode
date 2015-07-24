package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;

/*
 * ����������ĸ�Ķ��壬��+��������ʵ���޷��жϴ������룬������AC������Leetcode��������
 */
public class RomantoInteger {
	private Map<Character, Integer> dict = new HashMap<>();
	{
		dict.put('I', 1);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('L', 50);
		dict.put('C', 100);
		dict.put('D', 500);
		dict.put('M', 1000);
	}

	public int romanToInt(String s) {
		int result = 0;
		if (s.length() < 1) {
			return 0;
		}
		int lastDigit = dict.get(s.charAt(s.length() - 1));
		result += lastDigit;
		int currentDigit;
		for (int i = s.length() - 2; i >= 0; i--) {
			char charAt = s.charAt(i);
			currentDigit = dict.get(charAt);
			result += currentDigit >= lastDigit ? currentDigit : -currentDigit;
			lastDigit = currentDigit;
		}
		return result;
	}

	public class Solution {
		private Map<Character, Integer> dict = new HashMap<>();
		{
			dict.put('I', 1);
			dict.put('V', 5);
			dict.put('X', 10);
			dict.put('L', 50);
			dict.put('C', 100);
			dict.put('D', 500);
			dict.put('M', 1000);
		}

		public int romanToInt(String s) {
			int res = 0, last = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				int curr = dict.get(s.charAt(i));
				res += curr >= last ? curr : -curr;
				last = curr;
			}
			return res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(2016, sln.romanToInt("MMXVI"));
	}

	@Test
	public void test1() {
		assertEquals(1997, sln.romanToInt("MCMXCVII"));
	}

}
