package leetcode;

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

	public class Solution {
		private int[] nums;

		public void rotate(int[] nums, int k) {
			if (nums.length == 0)
				return;
			k = k % nums.length;
			this.nums = nums;
			reverse(0, nums.length - k - 1);
			reverse(nums.length - k, nums.length - 1);
			reverse(0, nums.length - 1);
		}

		private void reverse(int begin, int end) {
			while (begin < end) {
				int tmp = nums[begin];
				nums[begin] = nums[end];
				nums[end] = tmp;
				begin++;
				end--;
			}
		}
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayCopy(nums, 10);
		System.out.println(Arrays.toString(nums));
	}

}
