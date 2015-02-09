package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				result--;
			} else {
				A[result++] = A[i];
			}
		}
		return result;
	}

	@Test
	public void test() {
		removeElement(new int[]{4,5}, 4);
	}

	@Test
	public void test1() {
		removeElement(new int[]{2,2,5}, 2);
	}
}
