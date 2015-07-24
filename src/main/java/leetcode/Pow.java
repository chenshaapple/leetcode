package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Pow {
	private double delta = 0.0001;

	public double pow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double half = pow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else if (n > 0) {
			return half * half * x;
		} else {
			return half * half / x;
		}
	}
	
	public class Solution {
	    public double myPow(double x, int n) {
	    		if(n == 0) return 1.0;
	    		double res = myPow(x, n / 2);
	    		res *= res;
	    		if(n % 2 != 0)
	    			res *= n > 0 ? x : 1/x;
	    		return res;
	    }
	}

	private Solution sln = new Solution();
	
	@Test
	public void test() {
		assertEquals(1, sln.myPow(1, 0), delta);
	}

	@Test
	public void test2() {
		assertEquals(4, sln.myPow(2, 2), delta);
	}

	@Test
	public void testMath() {
		System.out.println(Math.pow(0.00001, Integer.MAX_VALUE));
	}
}
