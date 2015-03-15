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
		for (int i = 0; i < revisedHeight.length; i++) {
			if (stack.isEmpty()
					|| revisedHeight[i] >= revisedHeight[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()
						&& revisedHeight[stack.peek()] >= revisedHeight[i]) {
					int preHeight = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					largest = Math.max(largest, revisedHeight[preHeight]
							* width);
				}
				stack.push(i);
			}
		}
		return largest;
	}

	public int largestRectargleAreaDaC(int[] height) {
		return divide(height, 0, height.length - 1);
	}

	private int divide(int[] height, int left, int right) {
		if (left == right) {
			return height[left];
		} else if (left > right) {
			return 0;
		}
		int mid = (left + right) / 2;
		int leftArea = divide(height, left, mid - 1);
		int rightArea = divide(height, mid + 1, right);
		int midArea = maxWithMid(height, mid, left, right);
		return Math.max(midArea, Math.max(leftArea, rightArea));
	}
	
	// the merge method is the most import in DaC
	private int maxWithMid(int[] height, int mid, int left, int right) {
		int i = mid, j = mid;
        int area = height[mid], h = height[mid];
        while (i >= left && j <= right) {
            h = Math.min(h, Math.min(height[i], height[j]));
            area = Math.max(area, (j - i + 1) * h);
            if (i == left) {
                ++j;
            } else if (j == right) {
                --i;
            } else {
                if (height[i - 1] > height[j + 1]) {
                    --i;
                } else {
                    ++j;
                }
            }
        }
        return area;
	}
	
	@Test
	public void testCombine() {
		assertEquals(8, maxWithMid(new int[]{5,4,1,2}, 1, 0, 3));
	}

	@Test
	public void test() {
		assertEquals(10,
				largestRectargleAreaDaC(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	@Test
	public void test2() {
		assertEquals(24, largestRectargleAreaDaC(new int[] { 2, 1, 6, 5, 4, 6,
				5, 4, 1, 2 }));
	}

	@Test
	public void test3() {
		assertEquals(4, largestRectargleAreaDaC(new int[] { 1, 2, 2 }));
	}

	@Test
	public void test4() {
		assertEquals(9, largestRectargleAreaDaC(new int[] { 1, 2, 3, 4, 5 }));
	}
	
	@Test
	public void test5() {
		assertEquals(9, largestRectargleAreaDaC(new int[]{9,0}));
	}
	
	@Test
	public void test6() {
		assertEquals(8, largestRectargleAreaDaC(new int[]{5,4,1,2}));
	}
}
