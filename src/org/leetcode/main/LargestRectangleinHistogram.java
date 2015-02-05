package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class LargestRectangleinHistogram {

	public int largestRectangleArea(int[] height) {
		int[] revisedHeight = new int[height.length + 1];
		System.arraycopy(height, 0, revisedHeight, 0, height.length);
		revisedHeight[height.length] = 0;
		Deque<Integer> stack = new LinkedList<>();
		int largest = 0;
		for(int i = 0; i < revisedHeight.length; i++) {
			if(stack.isEmpty() || revisedHeight[i] >= revisedHeight[stack.peek()]) {
				stack.push(i);
			} else {
				while(!stack.isEmpty() && revisedHeight[stack.peek()] >= revisedHeight[i]) {
					int preHeight = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					largest = Math.max(largest, revisedHeight[preHeight] * width);
				}
				stack.push(i);
			}
		}
		return largest;
    }

	public int largestRectanbleAreaForce(int[] heihgt) {
		return 0;
	}

	@Test
	public void test() {
		assertEquals(10, largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	@Test
	public void test2() {
		assertEquals(24, largestRectangleArea(new int[] { 2, 1, 6, 5, 4, 6, 5,
				4, 1, 2 }));
	}
}
