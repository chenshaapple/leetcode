package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 思路：这种解法思路明确，从尾向前，依次比较邻近两个，然后从升序的尾部，找一个最接近的更大值交换过去
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		for (int end = num.length - 1; end > 0; end--) {
			if (num[end - 1] < num[end]) {
				Arrays.sort(num, end, num.length);
				for(int begin = end; begin < num.length; begin++) {
					if(num[begin] > num[end - 1]) {
						int tmp = num[end - 1];
						num[end - 1] = num[begin];
						num[begin] = tmp;
						return;
					}
				}
			}
		}
		Arrays.sort(num);
	}

	@Test
	public void test() {
		int[] num = new int[] { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(num);
		assertEquals(Arrays.asList(new int[] { 4, 2, 0, 3, 0, 2, 2 }),
				Arrays.asList(num));
	}
	
	@Test
	public void testXor() {
		int a, b;
		a = b = Integer.MAX_VALUE;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		assertEquals(a, b);
		assertEquals(0, a);
	}

}
