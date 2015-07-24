package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveElement {
	public class Solution {
	    public int removeElement(int[] nums, int val) {
	        int len = 0;
	        for(int i = 0; i < nums.length; i++) {
	        		if(nums[i] != val)
	        			nums[len++] = nums[i];
	        }
	        return len;
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		sln.removeElement(new int[]{4,5}, 4);
	}

	@Test
	public void test1() {
		sln.removeElement(new int[]{2,2,5}, 2);
	}
}
