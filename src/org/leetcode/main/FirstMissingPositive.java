package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
/*
 * ��˵Ҫ����ģ�һ��ʼ˼·�����⣬����ͨ�����������ҵ�����������֦����ķǳ�ͷ�ۡ�Ȼ����������һ�������ˣ���Ϊ
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
    
    //��A�����棬����
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
