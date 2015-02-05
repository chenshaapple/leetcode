package org.leetcode.main;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchinRotatedSortedArrayNoDuplicate {
    public int search(int[] A, int target) {
//    		int left = 0, right = A.length -1;
//    		while(left <= right) {
//    			int mid = (left + right) >> 1;
//    			if(target == A[mid]) {
//    				return mid;
//    			}
//    			if(A[left] <= A[mid]) {
//    				if(target < A[mid]) {
//    					right = mid -1;
//    				} else {
//    					left = mid + 1;
//    				}
//    			} else  { // it is rotated
//    				if(target < A[mid])
//    			}
//    		}
//    		return -1;
    		if(A.length == 0) {
    			return -1;
    		}
    		int left = 0, right = A.length -1;
    		while(left <= right) {
    			int mid = (left + right) >> 1;
    			if(A[mid] == target) {
    				return mid;
    			}
    			if(target > A[mid]) {
    				if(A[left] > A[mid] && target > A[right]) {
    					right = mid - 1;
    				} else {
    					left = mid + 1;
    				}
    			} else {
    				if(A[right] < A[mid] && target < A[left]) {
    					left = mid + 1;
    				} else {
    					right = mid - 1;
    				}
    			}
    		}
    		return -1;
    }
	@Test
	public void test() {
		assertEquals(2, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
	}
}
