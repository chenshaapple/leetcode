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
	
	//思路跟上次男神讲LargestRectangleArea一样
	//最大子数组一定在左边，右边，或者横跨这两个区域
	public int maxSubArrayDivideAndConquer(int[] A) {
		if(A.length == 0) {
			return 0;
		}
		return find(A, 0, A.length - 1);
	}
	
	private int find(int[] A, int left, int right) {
		if(left == right) {
			return A[left];
		}
		int mid = (left + right) / 2;
		return Math.max(Math.max(find(A, left, mid), find(A, mid + 1, right)), findThrough(A, left, right));
	}
	
	private int findThrough(int[] A, int left, int right) {
		int m = (left + right) / 2;
		int sum = 0;
		  // Include elements on left of mid.
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= left; i--)
	    {
	        sum = sum + A[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }

	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= right; i++)
	    {
	        sum = sum + A[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }

	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	@Test
	public void test() {
		assertEquals(6,
				maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
	
	@Test
	public void testDaQ() {
		assertEquals(6,
				maxSubArrayDivideAndConquer(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
