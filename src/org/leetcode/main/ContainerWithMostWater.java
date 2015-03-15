package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    		int result = 0, left = 0, right = height.length - 1;
    		while(left < right) {
    			result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
    			if(height[left] < height[right]) {
    				left++;
    			} else {
    				right++;
    			}
    		}
    		return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
