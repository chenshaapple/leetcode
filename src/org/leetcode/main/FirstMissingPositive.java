package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
/*
 * 先说要排序的，一开始思路有问题，常试通过不连续来找到结果，结果剪枝处理的非常头疼。然后就用下面第一个方法了，因为
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        Arrays.sort(A);
        int result = 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == result) {
                result ++;
            }
        }
        return result;
    }
    
    //用A作缓存，交换
    public int firstMissingPositiveFast(int[] A) {
    	int result = 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    	int positiveCount = 0;
    	for(int num : A) {
    		if(num > 0) {
    			positiveCount++; 
        		min = Math.min(min, num);
        		max = Math.max(max, num);
    		}
    	}
    	result = min > 1 ? min - 1 : 1;
    	for(int num : A) {
    		if(num == result) {
    			result++;
    		}
    	}
    	return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
