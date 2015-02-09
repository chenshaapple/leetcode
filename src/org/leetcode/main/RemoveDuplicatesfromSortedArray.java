package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
    	if(A.length == 0) {
    		return 0;
    	}
		int result = 1;
		int elem = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] != elem) {
				A[result++] = A[i];
				elem = A[i];
			}
		}
		return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
