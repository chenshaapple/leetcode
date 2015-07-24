package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;
		boolean positive = x > 0;
		char[] digits = getDigits(x);
		int overflowEdge = Integer.MIN_VALUE / 10;
		for (int i = digits.length - 1; i >= 0 && digits[i] != 0; i--) {
			if (result < overflowEdge) {
				return 0;
			}
			result = result * 10 - (digits[i] - '0');
		}
		return positive ? -result : result;
	}

	private char[] getDigits(int x) {
		char[] digits = new char[10];
		int i = 9;
		int lastDigit = x % 10;
		lastDigit = lastDigit > 0 ? lastDigit : -lastDigit;
		digits[i--] = (char) (lastDigit + '0');
		x /= 10;
		x = x > 0 ? x : -x;
		while (x > 0) {
			digits[i--] = (char) ((x % 10) + '0');
			x /= 10;
		}
		return digits;
	}

	public class Solution {
		public int reverse(int x) {
			int res = 0;
			boolean isPositive = x >= 0;
			int tmp = -Math.abs(x);
			x = tmp;
			int digits = 0;
			while (tmp < 0) {
				digits++;
				tmp /= 10;
			}
			while (digits > 0) {
				tmp = (int) (x % 10 * Math.pow(10, digits-- - 1));
				if (res < Integer.MIN_VALUE - tmp)
					return 0;
				res += tmp;
				x /= 10;
			}
			return isPositive ? -res : res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		System.out.println(Integer.MAX_VALUE);
		assertEquals(-321, sln.reverse(-123));
	}

	@Test
	public void testDigits() {
		int x = -123;
		int digits = 0;
		while (x < 0) {
			digits++;
			x /= 10;
		}
		assertEquals(3, digits);
	}
}
