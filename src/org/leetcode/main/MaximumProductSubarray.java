package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
    	int max = A[0], min = A[0], result = A[0];
    	for(int i = 1; i < A.length; i++) {
    		int tmpMin = min * A[i], tmpMax = max * A[i];
    		max = Math.max(Math.max(A[i], tmpMax), tmpMin);
    		min = Math.min(Math.min(A[i], tmpMin), tmpMax);
    		result = Math.max(result, max);
    	}
    	return result;
    }
	@Test
	public void test() {
		assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
	}

	@Test
	public void test1() {
		assertEquals(16 , maxProduct(new int[]{2,-2, 2, -2,}));
	}
	
	@Test
	public void testIncludeZero() {
		assertEquals(2, maxProduct(new int[]{0,2}));
	}
	
	@Test
	public void testOneElement() {
		int[] input = new int[]{2};
		assertEquals(input[0], maxProduct(input));
	}
	
	@Test
	public void testNegative() {
		assertEquals(12, maxProduct(new int[]{-4,-3,-2}));
	}
}
