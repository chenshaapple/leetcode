package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 循环减去被除数是O(n)的算法，超时
 * 思路其实就是参考，数学除法
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if ((dividend == Integer.MIN_VALUE && divisor == -1) || divisor == 0) {
			return Integer.MAX_VALUE;
		}
		boolean positive = (dividend ^ divisor) >= 0;
		dividend = dividend < 0 ? dividend : -dividend;
		divisor = divisor < 0 ? divisor : -divisor;
		int result = 0, digit = 0;
		//这个很重要，避免了溢出造成的死循环
		while (divisor >= (dividend >> 1)) {
			divisor <<= 1;
			digit++;
		}
		while (digit >= 0) {
			if (dividend <= divisor) {
				result += 1 << digit;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return positive ? result : -result;
	}

	@Test
	public void test() {
		assertEquals(2, divide(-2, -1));
	}

	@Test
	public void test1() {
		assertEquals(1, divide(-1, -1));
		assertEquals(-1, divide(-1, 1));
		assertEquals(Integer.MAX_VALUE, divide(-1, 0));
	}

	@Test
	public void test2() {
		assertEquals(Integer.MAX_VALUE, divide(Integer.MAX_VALUE, 1));
	}
	
	@Test
	public void test3() {
		assertEquals(-1010369383 / -2147483648, divide(-1010369383, -2147483648));
	}
	
	@Test
	public void test4() {
		System.out.println((-2) << 1);
	}
}
