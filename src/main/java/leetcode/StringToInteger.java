package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringToInteger {

	public class Solution {
		public int myAtoi(String str) {
			int res = 0;
			str = str.trim();
			if (str.length() == 0)
				return 0;
			char[] chars = str.toCharArray();
			int i = 0;
			boolean isPositive = true;
			if (chars[i] == '+' || chars[i] == '-') {
				isPositive = chars[i++] == '+';
			}
			while (i < chars.length) {
				char curr = chars[i++];
				if (res == Integer.MIN_VALUE / 10 && curr >= '8' ||
						res < Integer.MIN_VALUE / 10 && curr >= '0' && curr <= '9')
					return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				if (curr >= '0' && curr <= '9') {
					res = res * 10 - (curr - '0');
				} else
					break;
			}
			return isPositive ? -res : res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void testPositiveOverflow() {
		assertEquals(Integer.MAX_VALUE,
				sln.myAtoi("  " + ((long) Integer.MAX_VALUE + 1)));
	}

	@Test
	public void testNegativeOverflow() {
		assertEquals(Integer.MIN_VALUE, sln.myAtoi("  " + Integer.MIN_VALUE));
	}

	@Test
	public void testInvalid() {
		assertEquals(0, sln.myAtoi("+-12"));
		assertEquals(0, sln.myAtoi("+   sdfj+"));
		assertEquals(0, sln.myAtoi("b12345"));
	}

	@Test
	public void testPartInvalid() {
		assertEquals(12, sln.myAtoi("0012as"));
	}

	@Test
	public void testLongMaxValue() {
		assertEquals(Integer.MIN_VALUE, sln.myAtoi("-11919730356x"));
	}
	
	@Test
	public void test() {
		assertEquals(-1010023630, sln.myAtoi("-1010023630o4"));
	}
}
