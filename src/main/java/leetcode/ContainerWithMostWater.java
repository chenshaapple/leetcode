package leetcode;

import java.util.stream.IntStream;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int result = 0, left = 0, right = height.length - 1;
		while (left < right) {
			result = Math.max(result,
					(right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	public class Solution {
		public int maxArea(int[] height) {
			int res = 0, left = 0, right = height.length - 1;
			while (left < right) {
				res = Math.max(res,
						(right - left) * Math.min(height[left], height[right]));
				if (height[left] < height[right]) {
					left++;
				} else {
					right--;
				}
			}
			return res;
		}
	}
}
