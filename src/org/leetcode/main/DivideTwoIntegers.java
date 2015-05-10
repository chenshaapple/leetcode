package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 循环减去被除数是O(n)的算法，超时
 * 思路其实就是参考，数学除法
 */
public class DivideTwoIntegers {
	public class Solution {
		public int divide2(int dividend, int divisor) {
			if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0)
				return Integer.MAX_VALUE;
			boolean isPositive = (dividend ^ divisor) >= 0;
			dividend = dividend < 0 ? dividend : -dividend;
			divisor = divisor < 0 ? divisor : -divisor;
			int res = 0, digit = 0;
			while (divisor >= (dividend >> 1)) {
				digit++;
				divisor <<= 1;
			}
			while (digit >= 0) {
				if (dividend <= divisor) {
					res += 1 << digit;
					dividend -= divisor;
				}
				digit--;
				divisor >>= 1;
			}
			return isPositive ? res : -res;
		}

		public int divide(int dividend, int divisor) {
			if (dividend == Integer.MIN_VALUE && divisor == -1)
				return Integer.MAX_VALUE;
			boolean isPositive = (dividend ^ divisor) >= 0;
			dividend = -Math.abs(dividend);
			divisor = -Math.abs(divisor);
			int res = 0, digit = 0;
			while(divisor >= (dividend >> 1)) {
				divisor <<= 1;
				digit++;
			}
			while(digit >= 0) {
				if(dividend <= divisor) {
					res += 1 << digit;
					dividend -= divisor;
				}
				digit--;
				divisor >>= 1;
			}
			return isPositive ? res : -res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(2, sln.divide(-2, -1));
	}

	@Test
	public void test1() {
		assertEquals(1, sln.divide(-1, -1));
		assertEquals(-1, sln.divide(-1, 1));
	}

	@Test
	public void test2() {
		assertEquals(Integer.MAX_VALUE, sln.divide(Integer.MAX_VALUE, 1));
	}

	@Test
	public void test3() {
		assertEquals(-1010369383 / -2147483648,
				sln.divide(-1010369383, -2147483648));
	}

	@Test
	public void test4() {
		System.out.println((-2) << 1);
	}

	@Test
	public void test5() {
		assertEquals(5, sln.divide(-5, -1));
	}
}
