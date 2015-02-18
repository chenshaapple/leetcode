package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGame {
    public boolean canJump(int[] A) {
    	int i = 0;
        while(i < A.length && A[i] != 0) {
        	int max = 0, jump = 0;
        	for(int j = 0; j <= A[i]; j++) {
        		if((i + j) >= A.length - 1) {
        			return true;
        		}
        		int tmp = j + A[i + j];
        		if((tmp) > max) {
        			max = tmp;
        			jump = j;
        		}
        	}
        	i += jump == 0 ? A[i] : jump;
        }
        return i >= A.length - 1 ? true : false;
    }
	@Test
	public void test() {
		assertEquals(true, canJump(new int[]{2,5,0,0}));
	}

	
	@Test
	public void test1() {
		assertEquals(true, canJump(new int[]{4, 1, 2, 0, 4, 0, 0, 0}));
	}
	
	@Test
	public void test2() {
		assertEquals(false, canJump(new int[]{1,0,2}));
	}
	
	@Test
	public void test3() {
		assertEquals(true, canJump(new int[]{1,2,0,1}));
	}
	
	@Test
	public void test4() {
		assertEquals(false, canJump(new int[]{1, 0 , 2}));
	}
}
