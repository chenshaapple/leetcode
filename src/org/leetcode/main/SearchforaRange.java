package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * ˼·��
 * 	1.���ֲ��ҿ϶�������
 * 	2.two pointerʱ�临�Ӷ�O(n),���Ƿǳ���д
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int left = 0, right = A.length - 1, mid = 0;
		// find the equal index;
		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == target) {
				break;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// search the adjacent index
		if (A[mid] == target) {
			left = right = mid;
			while (left - 1 >= 0 && A[left - 1] == target) {
				left--;
			}
			while (right + 1 < A.length && A[right + 1] == target) {
				right++;
			}
			return new int[] { left, right };
		}
		return new int[] { -1, -1 };
	}

	public int[] searchRangeTwoPointer(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left < right && (A[left] != target || A[right] != target)) {
			if (A[left] < target) {
				left++;
			}
			if (A[right] > target) {
				right--;
			}
		}
		if (target == A[left]) {
			return new int[] { left, right };
		}
		return new int[] { -1, -1 };
	}

	@Test
	public void test() {
		System.out.println(searchRange(new int[] { 1, 4 }, 4));
	}

}
