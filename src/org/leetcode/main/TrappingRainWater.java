package org.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrappingRainWater {
	public static int trap(int[] A) {
		if (A.length < 1)
			return 0;
		int result = 0;
		int maxIndex = 0;
//		for (int i = 1; i < A.length; i++) {
//			if(A[i] > A[maxIndex]) {
//				maxIndex = i;
//			}
//		}
		
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if(A[i] > A[maxIndex]) {
				maxIndex = i;
				max = A[i];
			} else {
				result += (max - A[i]);
			}
		}
		
		
		for(int i = 1; i < maxIndex; i++) {
			if(A[i] > max) {
				max = A[i];
			} else {
				result += (max - A[i]);
			}
		}
		max = A[A.length - 1];
		for(int i = A.length - 2; i > maxIndex; i--) {
			if(A[i] > max) {
				max = A[i];
			} else {
				result += (max - A[i]);
			}
		}
		return result;
	}
	
	public static int anotherTrap(int[] A) {
		if(A.length < 2) {
			return 0;
		}
		int result = 0;
		int left = 0, right = A.length - 1, leftMax = A[left], rightMax = A[right];
		while(left < right) {
			if(leftMax < rightMax) {
				if(A[left] > leftMax) {
					leftMax = A[left];
				} else {
					result += (leftMax - A[left]);
				}
				left++;
			} else {
				if(A[right] > rightMax) {
					rightMax = A[right];
				} else {
					result += (rightMax - A[right]);
				}
				right--;
			}
			if(left == right) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(TrappingRainWater.anotherTrap(new int[] { 5, 4, 1, 2 }));
		System.out.println(TrappingRainWater.anotherTrap(new int[] { 0, 1, 0, 2, 1, 0,
				1, 3, 2, 1, 2, 1 }));
		System.out.println(TrappingRainWater.anotherTrap(new int[] { 2, 0, 2 }));
		System.out.println(TrappingRainWater.anotherTrap(new int[] {}));
		
	}
}
