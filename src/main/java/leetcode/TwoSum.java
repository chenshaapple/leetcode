package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public class Solution {
		public int[] twoSum(int[] nums, int target) {
			int[] res = new int[2];
			Map<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < nums.length; i++) {
				int rest = target - nums[i];
				if(map.containsKey(rest)) {
					res[0] = i + 1;
					res[1] = map.get(rest);
					break;
				}
				map.put(nums[i], i + 1);
			}
			Arrays.sort(res);
			return res;
		}
	}
}
