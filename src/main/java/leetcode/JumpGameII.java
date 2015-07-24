package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameII {
	/**
	 * ��I�е�ԭ�������ݻ����ģ�ά��һ����ǰ�������ܵ��������
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
        if(A.length == 1) return 0;
		int res = 1;
		int position = 0, step = A[0];
		while(position < A.length && step != position) {
			if(step >= A.length - 1) return res;
			int nextStep = 0;
			for(int i = position + 1; i < A.length && i <= step; i++) {
				nextStep = Math.max(nextStep, i + A[i]);
			}
			position = step;
			step = nextStep;
			res++;
		}
		return res;
	}
	
	
	/**
	 * ���񽲵�
	 */
	public int jump2(int[] A) {
		int cur = 0, last = 0, res = 0;
		for(int i = 0; i < A.length; i++) {
			if(i > last) {
				res++;
				last = cur;
			}
			cur = Math.max(cur, i + A[i]);
		}
		return res;
	}
	
	public class Solution {
	    public int jump(int[] nums) {
	        int res = 0, curr = 0, last = 0;
	        for(int i = 0; i < nums.length; i++) {
	        		if(i > last) {
	        			res++;
	        			last = curr;
	        		}
	        		curr = Math.max(curr, i + nums[i]);
	        }
	        return res;
	    }
	}
	@Test
	public void test() {
		assertEquals(0, jump(new int[]{1}));
	}

	@Test
	public void test1() {
		assertEquals(2, jump(new int[]{1,2,3}));
	}
	
	@Test
	public void test2() {
		assertEquals(1, jump(new int[]{1,2}));
	}
}
