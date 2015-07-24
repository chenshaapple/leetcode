package leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchinRotatedSortedArray {

	public class Solution {
		public int search(int[] nums, int target) {
			if (nums.length == 0)
				return -1;
			int left = 0, right = nums.length - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target)
					return mid;
				if (target > nums[mid]) {
					// left = mid + 1;
					if (nums[left] > nums[mid] && target > nums[right])
						right = mid - 1;
					else
						left = mid + 1;
				} else {
					// right = mid - 1;
					if (nums[mid] > nums[right] && target < nums[left])
						left = mid + 1;
					else
						right = mid - 1;
				}
			}
			return -1;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(2, sln.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 6));
	}

	@Test
	public void test1() {
		assertEquals(1, sln.search(new int[] { 3, 1 }, 1));
	}
}
