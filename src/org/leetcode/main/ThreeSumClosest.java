package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
    	  	Arrays.sort(num);
    	  	int result = 0;
    	  	int minGap = Integer.MAX_VALUE;
    	  	int currentGap = 0;
    	  	int currentTwoSum = 0;
    	  	for(int i = 0; i < num.length; ++i) {
    	  		int twoSumTarget = target - num[i];
    	  		int left = i + 1;
    	  		int right = num.length - 1;
    	  		while(left < right) {
    	  			currentTwoSum = num[left] + num[right];
    	  			currentGap = Math.abs(currentTwoSum - twoSumTarget);
    	  			if(currentGap < minGap) {
    	  				result = currentTwoSum + num[i];
    	  				minGap = currentGap;
    	  			}
    	  			if(currentTwoSum < twoSumTarget) {
    	  				left++;
    	  			} else {
    	  				right--;
    	  			}
    	  		}
    	  	}
    	  	return result;
    }
	@Test
	public void test() {
		assertEquals(0, threeSumClosest(new int[]{0,0,0}, 1) );
	}
	
}
