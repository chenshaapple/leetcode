package leetcode;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
public class MinimumSizeSubarraySum {
	public class Solution {
		public int minSubArrayLen(int s, int[] nums) {
			int start = 0, end = 0, sum = 0, res = nums.length;
			while(end != nums.length) {
				sum += nums[end++];
				if(sum < s)
					continue;
				while(sum - nums[start] >= s)
					sum -= nums[start++];
				res = Math.min(res, end - start);
			}
			return sum < s ? 0 : res;
		}
	}
	
	private Solution sln = new Solution();
	
	@Test
	public void case1() {
		assertEquals(2, sln.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
	}
}
