package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int left = 0, right = A.length - 1, mid = 0;
		// find the equal index;
		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == target) {
				break;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// search the adjacent index
		if (A[mid] == target) {
			left = right = mid;
			while (left - 1 >= 0 && A[left - 1] == target) {
				left--;
			}
			while (right + 1 < A.length && A[right + 1] == target) {
				right++;
			}
			return new int[] { left, right };
		}
		return new int[] { -1, -1 };
	}

	public int[] searchRangeTwoPointer(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left < right && (A[left] != target || A[right] != target)) {
			if (A[left] < target) {
				left++;
			}
			if (A[right] > target) {
				right--;
			}
		}
		if (target == A[left]) {
			return new int[] { left, right };
		}
		return new int[] { -1, -1 };
	}

	public class Solution {
		/**
		 * time: O(n)
		 * 
		 * @param nums
		 * @param target
		 * @return
		 */
		public int[] searchRange(int[] nums, int target) {
			int left = -1, right = -1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target && left == -1)
					left = i;
				if (nums[i] == target)
					right = i;
			}
			return new int[] { left, right };
		}

		/**
		 * time: O(log(n))
		 */
		public int[] searchRange2(int[] nums, int target) {
			int left = Arrays.binarySearch(nums, target), right = left;
			if (left < 0)
				return new int[] { -1, -1 };
			while (left > 0 && nums[left - 1] == target)
				left--;
			while (right < nums.length - 1 && nums[right + 1] == target)
				right++;
			return new int[] { left, right };
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test1() {
		int[] nums = { 2, 2 };
		assertEquals(Arrays.toString(new int[] { -1, -1 }),
				Arrays.toString(sln.searchRange2(nums, 3)));
	}

	@Test
	public void test2() {
		int[] nums = { 2, 2 };
		assertEquals(Arrays.toString(new int[] { 0, 1 }),
				Arrays.toString(sln.searchRange2(nums, 2)));
	}
}
