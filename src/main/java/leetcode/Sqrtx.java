package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sqrtx {
	public int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		double result = 1;
		double delta = 0.05;
		while (true) {
			double tmp = (result + x / result) / 2;
			if (Math.abs(tmp - result) <= delta) {
				return (int) tmp;
			}
			result = tmp;
		}
	}
	public class Solution {
	    public int mySqrt(int x) {
	        double res = 1;
	        double delta = 1 / Math.E; 
	        while(true) {
	            double tmp = (res + x / res) / 2;
	            if(Math.abs(res - tmp) < delta)
	            		return (int)res;
	            res = tmp;
	        }
	    }
	}
	/**
	 * 按位枚举
	 * 
	 * @return
	 */
	public int sqrt2(int x) {
		int res = 0;
		for (int i = 0; i < 16; i++) {
			int tmp = res | (1 << (16 - 1 - i));
			if (tmp <= x / tmp) {
				res = tmp;
			}
		}
		return res;
	}

	/**
	 * 二分
	 */
	public int sqrt3(int x) {
		if(x == 0) {
			return 0;
		}
		if(x < 4) {
			return 1;
		}
		int res = 0;
		int left = 0, right = x;
		while(left <= right) {
			int mid = left + ((right - left) >> 1);
			int tmp = x / mid;
			if(mid == tmp) {
				return mid;
			} else if(mid < tmp) {
				left = mid + 1;
				res = mid;//向下取整
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	@Test
	public void test() {
		assertEquals(1, sqrt3(1));
		assertEquals(2, sqrt3(5));
	}

	@Test
	public void test1() {
		assertEquals(1, sqrt3(3));
	}

	@Test
	public void test2() {
		assertEquals(46339, sqrt3(2147395599));
	}
}
