package leetcode;

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
		while (aIndex < A.length && bIndex < B.length) {
			if (A[aIndex] < B[bIndex]) {
				mergedArray[aIndex + bIndex] = A[aIndex++];
			} else {
				mergedArray[aIndex + bIndex] = B[bIndex++];
			}
		}
		if (aIndex < A.length) {
			System.arraycopy(A, aIndex, mergedArray, aIndex + bIndex, A.length
					- aIndex);
		}
		if (bIndex < B.length) {
			System.arraycopy(B, bIndex, mergedArray, aIndex + bIndex, B.length
					- bIndex);
		}
		if (mergedArray.length % 2 == 0) {
			return (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
		} else {
			return mergedArray[mergedArray.length / 2];
		}
	}

	public class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;
			if (len % 2 == 1)
				return find(nums1, 0, nums1.length - 1, nums2, 0,
						nums2.length - 1, len / 2 + 1);
			else
				return (find(nums1, 0, nums1.length - 1, nums2, 0,
						nums2.length - 1, len / 2) + find(nums1, 0,
						nums1.length - 1, nums2, 0, nums2.length - 1,
						len / 2 + 1)) / 2.0;
		}

		private int find(int[] nums1, int begin1, int end1, int[] nums2,
				int begin2, int end2, int k) {
			if (end1 - begin1 > end2 - begin2)
				return find(nums2, begin2, end2, nums1, begin1, end1, k);
			if (begin1 > end1)
				return nums2[begin2 + k - 1];
			if (k == 1)
				return Math.min(nums1[begin1], nums2[begin2]);
			int ia = Math.min(k / 2, end1 - begin1 + 1);
			int ib = k - ia;
			if (nums1[begin1 + ia - 1] < nums2[begin2 + ib - 1])
				return find(nums1, begin1 + ia, end1, nums2, begin2, end2, k
						- ia);
			else if (nums1[begin1 + ia - 1] > nums2[begin2 + ib - 1])
				return find(nums1, begin1, end1, nums2, begin2 + ib, end2, k
						- ib);
			else
				return nums1[begin1 + ia - 1];
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(2.5,
				sln.findMedianSortedArrays(new int[] {}, new int[] { 2, 3 }),
				0.1);
	}

	@Test
	public void test1() {
		assertEquals(1,
				sln.findMedianSortedArrays(new int[] { 1 }, new int[] { 1 }),
				0.1);
	}

	@Test
	public void test2() {
		assertEquals(2.5, sln.findMedianSortedArrays(new int[] { 3 },
				new int[] { 1, 2, 4 }), 0.1);
	}
}
