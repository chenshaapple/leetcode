package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClimbingStairs {
	//这一看就发现是斐波那契数列了，所以有更快的算法
    public int climbStairs1(int n) {
    		if(n < 1) {
    			return 0;
    		}
        int[] opt = new int[n + 1];
        opt[0] = 1;
        opt[1] = 1;
        for(int i = 2; i <= n; i++) {
        		opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n];
    }
    
    public int climbStairs(int n) {
    		if(n < 1) {
    			return 0;
    		}
    		double sqrt5 = Math.sqrt(5);
    		double factor1 = sqrt5 / 5;
    		double factor2 = Math.pow((1 + sqrt5) / 2, n + 1);
    		double factor3 = Math.pow((1 - sqrt5) / 2, n + 1);
    		return (int)(factor1 * (factor2 - factor3));
    }
	@Test
	public void test0() {
		assertEquals(0, climbStairs(0));
	}

	@Test
	public void test1() {
		assertEquals(1, climbStairs(1));
	}
	
	@Test
	public void test2() {
		assertEquals(2, climbStairs(2));
	}
	
	@Test
	public void test3() {
		assertEquals(3, climbStairs(3));
	}
}
