package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrappingRainWater {
	public class Solution {
		public int trap(int[] height) {
			if(height.length < 2) return 0;
			int res = 0;
			int left = 0, right = height.length - 1, leftMax = height[left], rightMax = height[right];
			while (left <= right) {
				if (leftMax < rightMax) {
					if (height[left] > leftMax)
						leftMax = height[left];
					else
						res += leftMax - height[left];
					left++;
				} else {
					if (height[right] > rightMax)
						rightMax = height[right];
					else
						res += rightMax - height[right];
					right--;
				}
			}
			return res;
		}
	}
	
	private Solution sln = new Solution();
	
	@Test
	public void test1() {
		assertEquals(23, sln.trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
	}
	
}
