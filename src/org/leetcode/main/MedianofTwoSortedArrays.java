package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 思路：
 * leetCode说复杂度应该为O(log(m +　n)),这肯定就是用二分查找了,还不能合并，因为合并已经是O(min(m,n))了
 * 先实现了Naive的，merge and find，能AC
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int[] mergedArray = new int[A.length + B.length];
        int aIndex = 0, bIndex = 0;
        while(aIndex < A.length && bIndex < B.length) {
        	if(A[aIndex] < B[bIndex]) {
        		mergedArray[aIndex + bIndex] = A[aIndex++];
        	} else {
        		mergedArray[aIndex + bIndex] = B[bIndex++];
        	}
        }
        if(aIndex < A.length) {
        	System.arraycopy(A, aIndex, mergedArray, aIndex + bIndex, A.length - aIndex);
        }
        if(bIndex < B.length) {
        	System.arraycopy(B, bIndex, mergedArray, aIndex + bIndex, B.length - bIndex);
        }
        if(mergedArray.length % 2 == 0) {
        	return (double)(mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
        } else {
        	return mergedArray[mergedArray.length / 2];
        }
    }
    
    public double findMedianSortedArraysWithBinarySearch(int A[], int B[]) {
    	
    }
	@Test
	public void test() {
		assertEquals(2.5, findMedianSortedArrays(new int[]{}, new int[]{2,3}), 0.1);
	}

}
