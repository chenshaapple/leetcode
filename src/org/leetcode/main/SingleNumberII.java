package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberII {
	// 这是一种通用的方法
	public int singleNumber(int[] A) {
		int times = 3;
		int[] digits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				// digits[i] += (A[j] >> i) & 1;
				digits[i] += (A[j]) & 1;
				A[j] >>= 1;
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {

			res += (digits[i] % times) << i;
		}
		return res;
	}

	public int singleNumberFast(int[] A) {
		int one = 0, two = 0, three = 0;
		for (int num : A) {
			three = two & num;// 已经出现了两次，还出现了一次
			two = two | one & num;// 出现了1次又出现了1次，在加上以前已经出现了2次的，为新的出现了2次的
			one = one | num;// 出现了1次
			// 将出现3次的其出现1次2次全部抹去
			one = one & ~three;
			two = two & ~three;
		}
		return one;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
