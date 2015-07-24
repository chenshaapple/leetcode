package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        System.arraycopy(A, 0, A, n, m);
        int i = 0, j = 0;
        while(i < m && j < n) {
        	if(A[n + i] < B[j]) {
        		A[i + j] = A[n + i++];
        	} else {
        		A[i + j] = B[j++];
        	}
        }
        if(j < n) {
        	System.arraycopy(B, j, A, i + j, n - j);
        }
    }
    
    public void mergeUsingSort(int A[], int m, int B[], int n) {
    	System.arraycopy(B, 0, A, m, n);
    	Arrays.sort(A);
    }
	@Test
	public void test() {
		int[] A = new int[9];
		System.arraycopy(new int[]{1,2,3,4,5}, 0, A, 0, 5);
		int[] B = new int[]{6,7,8,9};
		merge(A, 5, B, 4);
		assertEquals(new int[]{1,2,3,4,5,6,7,8,9}, A);
	}

}
