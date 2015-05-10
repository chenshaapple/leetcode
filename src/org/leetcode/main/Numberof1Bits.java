package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Numberof1Bits {
	public int hammingWeight(int n) {
		int res = 0, probe = 1;
		for (int i = 0; i < 32; i++, probe = probe << 1) {
			if ((probe & n) != 0) {
				res++;
			}
		}
		return res;
	}

	public int hammingWeightFast(int n) {
		int res = 0;
		while (n != 0) {
			res++;
			n &= n - 1;
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(hammingWeightFast(7));
	}

	@Test
	public void test1() {
		System.out.println(hammingWeightFast(Integer.MIN_VALUE));
	}
}
