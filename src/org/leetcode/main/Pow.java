package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Pow {
	private double delta = 0.0001;

	public double pow(double x, int n) {
		if(n < 0) {
			n = -n;
			x = 1/x;
		}
		int result = 1;
		while (n != 0) {
			if ((n & 1) == 1)
				result *= x;
			n >>= 1;
			x *= x;
		}

		return result;
	}

	@Test
	public void test() {
		assertEquals(1, pow(1, 0), delta);
	}

	@Test
	public void test2() {
		assertEquals(4, pow(2, 2), delta);
	}

	@Test
	public void testMath() {
		System.out.println(Math.pow(0.00001, Integer.MAX_VALUE));
	}
}
