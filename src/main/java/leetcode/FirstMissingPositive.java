package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*
 * ��˵Ҫ����ģ�һ��ʼ˼·�����⣬����ͨ�����������ҵ�����������֦����ķǳ�ͷ�ۡ�Ȼ����������һ�������ˣ���Ϊ
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		Arrays.sort(A);
		int result = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == result) {
				result++;
			}
		}
		return result;
	}

	public class Solution {
		public int firstMissingPositive(int[] nums) {
			bucketSort(nums);
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] != i + 1)
					return i + 1;
			}
			return nums.length + 1;
		}

		private void bucketSort(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				while (nums[i] != i + 1) {
					if (nums[i] <= 0 || nums[i] > nums.length
							|| nums[i] == nums[nums[i] - 1])
						break;
					int tmp = nums[i];
					int index = nums[i] - 1;
					nums[i] = nums[index];
					nums[index] = tmp;
				}
			}
		}
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		System.out.println(sln.firstMissingPositive(new int[]{2, 1}));
	}

	
	@Test
	public void test1() {
		int[] nums = new int[]{5, 4, 3, 1};
		System.out.println(sln.firstMissingPositive(nums));
		System.out.println(Arrays.toString(nums));
	}
}
