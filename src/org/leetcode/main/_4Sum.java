package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(num);
        int last = num.length;
        Set<List<Integer>> tmp = new HashSet<>();
        for(int i = 0; i < last - 3; i++) {
        	for(int j = i + 1; j < last - 2; j++) {
        		int begin = i + 1, end = last - 1;
        		while(begin < end) {
        			int sum = num[i] + num[j] + num[begin] + num[end];
        			if(sum == target) {
        				tmp.add(Arrays.asList(num[i], num[j], num[begin], num[end]));
        				begin++;
        				end--;
        			} else if(sum < target) {
        				begin++;
        			} else {
        				end--;
        			}
        		}
        	}
        }
        for(List<Integer> list : tmp) {
        	result.add(list);
        }
        return result;
    }
    
    public class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new LinkedList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++) {
            		if(i > 0 && nums[i] == nums[i - 1]) continue;
            		for(int j = i + 1; j < nums.length; j++) {
            			if(j > i + 1 && nums[j] == nums[j - 1]) continue;
            			for(int k = j + 1, l = nums.length - 1; k < l;) {
            				if(k > j + 1 && nums[k] == nums[k - 1]) {
            					k++;
            					continue;
            				}
            				int sum = nums[i] + nums[j] + nums[k] + nums[l];
            				if(sum == target) {
            					res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            					k++;l--;
            				} else if(sum < target) {
            					k++;
            				} else {
            					l--;
            				}
            			}
            		}
            }
            return res;
        }
    }
	@Test
	public void test() {
		fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
	}

	@Test
	public void test2() {
		fourSum(new int[]{-3,-1,0,2,4,5}, 0);
	}
}
