package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {
	public class Solution {
	    public int removeDuplicates(int[] nums) {
			if (nums.length == 0)
				return 0;
			int res = 1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != nums[i - 1])
					nums[res++] = nums[i];
			}
			return res;
	    }
	}
	
	private Solution sln = new Solution();
	
	@Test
	public void test() {
		int[] nums = new int[]{1, 1};
		assertEquals(1, sln.removeDuplicates(nums));
	}
	
	@Test
	public void test1() {
		int[] nums = new int[]{1,2};
		assertEquals(2, sln.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
