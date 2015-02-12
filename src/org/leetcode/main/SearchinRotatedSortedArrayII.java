package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        
    	
    	return false;
    }
    
    //Ö±½Ó±éÀú
    public boolean searchNaive(int[] A, int target) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                return true;
            }
        }
        return false;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
