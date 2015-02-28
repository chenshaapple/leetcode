package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sqrtx {
    public int sqrt(int x) {
    	if(x <=0 ) {
    		return 0;
    	}
    	double result = 1;
    	double delta = 0.05;
    	while(true) {
    		double tmp = (result + x / result) / 2;
    		if(Math.abs(tmp - result) <= delta) {
    			return (int) tmp;
    		}
    		result = tmp;
    	}
    }
	@Test
	public void test() {
		assertEquals(1, sqrt(1));
		assertEquals(2, sqrt(5));
	}

	@Test
	public void test1() {
		assertEquals(1, sqrt(3));
	}
	
	@Test
	public void test2() {
		assertEquals(46339, sqrt(2147395599));
	}
}
