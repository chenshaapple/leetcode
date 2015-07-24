package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int COUNT_LIMIT = 2;
		if (A.length == 0) {
			return 0;
		}
		int result = 1;
		int elem = A[0];
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != elem) {
				count = 0;
				elem = A[i];
			} else {
				count++;
			}
			if (count < COUNT_LIMIT) {
				A[result++] = A[i];
			}
		}
		return result;
	}
	
	public class Solution {
	    public int removeDuplicates(int[] nums) {
	        int k = 2;
	        if(nums.length <= k) return nums.length;
	        int res = 1, last = nums[0], count = 1;
	        for(int i = 1; i < nums.length; i++) {
	            int curr = nums[i];
	            if(curr == last) {
	                count++;
	                if(count <= k)
	                    nums[res++] = curr;
	            } else {
	                nums[res++] = curr;
	                count = 1;
	                last = curr;
	            }
	        }
	        return res;
	    }
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
