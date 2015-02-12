package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int result = 0;
        for(int i = 0; i < height.length - 1; i++) {
        	for(int j = i + 1; j < height.length; j++) {
        		int area = (j - i) * Math.min(height[i], height[j]);
        		result = area > result ? area : result;
        	}
        	
        }
        return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
