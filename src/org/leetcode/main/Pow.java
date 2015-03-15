package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Pow {
	private double delta = 0.0001;

	public double pow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double half = pow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else if (n > 0) {
			return half * half * x;
		} else {
			return half * half / x;
		}
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
