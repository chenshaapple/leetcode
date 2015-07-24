package leetcode;

public class HouseRobberII {
	public class Solution {
	    public int rob(int[] nums) {
	    		if(nums.length == 0) return 0;
	    		if(nums.length == 1) return nums[0];
	    		int slow0 = 0, slow1 = nums[0];
	    		int fast0 = 0, fast1 = nums[1];
	    		for(int i = 1; i < nums.length - 1; i++) {
	    			int slowTmp = slow0, fastTmp = fast0;
	    			slow0 = Math.max(slow0, slow1);
	    			slow1 = Math.max(slow1, slowTmp + nums[i]);
	    			fast0 = Math.max(fast0, fast1);
	    			fast1 = Math.max(fast1, fastTmp + nums[i + 1]);
	    		}
	        return Math.max(slow1, fast1);
	    }
	}
}
