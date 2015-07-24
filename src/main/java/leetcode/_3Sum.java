package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.junit.Test;

public class _3Sum {
	public class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> res = new LinkedList<>();
			Set<List<Integer>> set = new HashSet<>();
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = i + 1, k = nums.length - 1; j < k;) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> list = Arrays.asList(nums[i], nums[j],
								nums[k]);
						if (set.add(list))
							res.add(list);
						j++;
						k--;
					} else if (sum > 0) {
						k--;
					} else {
						j++;
					}
				}
			}
			return res;
		}

		public List<List<Integer>> threeSum2(int[] nums) {
			List<List<Integer>> res = new LinkedList<>();
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				if (i > 0 && nums[i] == nums[i - 1])
					continue;
				int rest = -nums[i];
				int left = i + 1, right = nums.length - 1;
				while (left < right) {
					if (left > i + 1 && nums[left] == nums[left - 1]) {
						left++;
						continue;
					}
					int twoSum = nums[left] + nums[right];
					if (twoSum < rest) {
						left++;
					} else if (twoSum > rest) {
						right--;
					} else {
						res.add(Arrays.asList(nums[i], nums[left], nums[right]));
						left++;
						right--;
					}
				}
			}
			return res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		int[] nums = new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14,
				-4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6,
				11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1,
				-9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12,
				14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12,
				13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
		List<List<Integer>> res = sln.threeSum(nums);
		Set<List<Integer>> set = new HashSet<>(res);
		assertEquals(set.size(), res.size());
	}

}
