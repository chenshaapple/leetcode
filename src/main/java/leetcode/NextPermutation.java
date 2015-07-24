package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * ˼·�����ֽⷨ˼·��ȷ����β��ǰ�����αȽ��ڽ�������Ȼ��������β������һ����ӽ��ĸ���ֵ������ȥ
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
	
	public class Solution {
	    public void nextPermutation(int[] nums) {
	    		int i = -1, larger = -1;
	    		for(i = nums.length - 1; i > 0; i--) {
	    			if(nums[i - 1] < nums[i]) break;
	    		}
	    		Arrays.sort(nums, i, nums.length);
	    		if(i == 0) return;
	    		for(larger = i; larger < nums.length; larger++) {
	    			if(nums[larger] > nums[i - 1]) break;
	    		}
	    		int tmp = nums[i - 1];
	    		nums[i - 1] = nums[larger];
	    		nums[larger] = tmp;
	    }
	}

	private Solution sln = new Solution();
	
	@Test
	public void test() {
		int[] num = new int[] { 4, 2, 0, 2, 3, 2, 0 };
		sln.nextPermutation(num);
		assertEquals(Arrays.toString(new int[] { 4, 2, 0, 3, 0, 2, 2 }),
				Arrays.toString(num));
	}
}
