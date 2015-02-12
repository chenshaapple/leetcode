package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 思路：二分查找显然最快
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while(left < right) {
        	int mid = (left + right) / 2;
        	if(A[mid] < target) {
        		left = mid + 1;
        	} else if(target < A[mid]) {
        		right = mid - 1;
        	} else {
        		return mid;
        	}
        }
        if(target <= A[left]) {
        	return left;
        } else {
        	return right + 1;
        }
    }
	@Test
	public void test() {
		assertEquals(0, searchInsert(new int[]{1,3,5}, 0));
	}
	
	@Test
	public void test1() {
		assertEquals(3, searchInsert(new int[]{1,3,5}, 6));
	}

	@Test
	public void test2() {
		assertEquals(0, searchInsert(new int[]{1}, 1));
	}
}
