package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameII {
    public int jump(int[] A) {
        if(A.length == 1) {
            return 0;
        }
        int result = 0;
        int i = 0;
        while(i < A.length && A[i] != 0) {
        	int max = 0, jump = 0;
        	for(int j = 0; j <= A[i]; j++) {
        		if((i + j) >= A.length - 1) {
        			return result + 1;
        		}
        		int tmp = j + A[i + j];
        		if((tmp) > max) {
        			max = tmp;
        			jump = j;
        		}
        	}
        	i += jump == 0 ? A[i] : jump;
        	result++;
        }
        return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
