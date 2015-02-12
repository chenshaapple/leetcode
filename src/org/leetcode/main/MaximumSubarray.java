package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A.length <= 0) {
			return 0;
		}
		int localSum = A[0];
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			localSum = Math.max(localSum + A[i], A[i]);
			result = Math.max(result, localSum);
		}
		return result;
	}
	
	public int maxSubArrayDivideAndConquer(int[] A) {
		
	}

	@Test
	public void test() {
		assertEquals(6,
				maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
