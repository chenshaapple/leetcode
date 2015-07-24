package leetcode;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class MaximumSubarray {
	public int maxSubArrayDivideAndConquer(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		return find(A, 0, A.length - 1);
	}

	private int find(int[] A, int left, int right) {
		if (left == right) {
			return A[left];
		}
		int mid = (left + right) / 2;
		return Math.max(Math.max(find(A, left, mid), find(A, mid + 1, right)),
				findThrough(A, left, right));
	}

	private int findThrough(int[] A, int left, int right) {
		int m = (left + right) / 2;
		int sum = 0;
		// Include elements on left of mid.
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= left; i--) {
			sum = sum + A[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements on right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= right; i++) {
			sum = sum + A[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left and right of mid
		return left_sum + right_sum;
	}
	
	public class Solution {
	    public int maxSubArray(int[] nums) {
	        if(nums.length == 0) return 0;
	        int local = nums[0];
	        int res = nums[0];
	        for(int i = 1; i < nums.length; i++) {
	        		local = Math.max(local + nums[i], nums[i]);
	        		res = Math.max(res, local);
	        }
	        return res;
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		assertEquals(6,
				sln.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	@Test
	public void testDaQ() {
		assertEquals(6, maxSubArrayDivideAndConquer(new int[] { -2, 1, -3, 4,
				-1, 2, 1, -5, 4 }));
	}
}
