package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {
	public void rotateArrayCopy(int[] nums, int k) {
		if (k % nums.length == 0) {
			return;
		}
		k = k % nums.length;
		int[] buf = new int[k];
		System.arraycopy(nums, nums.length - k, buf, 0, k);
		System.arraycopy(nums, 0, nums, k, nums.length - k);
		System.arraycopy(buf, 0, nums, 0, k);
	}
	
	public void rotateArrayConstantSpace(int[] nums, int k) {
		if( k % nums.length == 0) {
			return;
		}
		k = k % nums.length;
		for(int i = 0; i < k; i++) {
			int tmp = nums[k];
			nums[k] = nums[nums.length - k];
			
		}
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayCopy(nums, 10);
		System.out.println(Arrays.toString(nums));
	}

}
