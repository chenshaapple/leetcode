package leetcode;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class ContainsDuplicateIII {
	public class Solution {
	    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        TreeSet<Long> set = new TreeSet<>();
	        for(int i = 0; i < nums.length; i++) {
	            if(i > k) set.remove(Long.valueOf(nums[i - k - 1]));
	            long upperBound = (long)nums[i] + t;
	            long lowerBound = (long)nums[i] - t;
	            Long lower = set.lower(upperBound + 1);
	            if(lower != null && lower >= lowerBound) return true;
	            set.add(Long.valueOf(nums[i]));
	        }
	        return false;
	    }
	}
	
	Solution sln = new Solution();
	@Test
	public void case1() {
		int[] nums = {-1, -1};
		int k = 1, t = 0;
		assertEquals(true, sln.containsNearbyAlmostDuplicate(nums, k, t));
	}
	
	@Test
	public void case2() {
		int[] nums = {0, Integer.MAX_VALUE};
		int k = 1, t = Integer.MAX_VALUE;
		assertEquals(true, sln.containsNearbyAlmostDuplicate(nums, k, t));
	}
}
