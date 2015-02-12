package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * ˼·��
 * leetCode˵���Ӷ�Ӧ��ΪO(log(m +��n)),��϶������ö��ֲ�����,�����ܺϲ�����Ϊ�ϲ��Ѿ���O(min(m,n))��
 * ��ʵ����Naive�ģ�merge and find����AC
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
