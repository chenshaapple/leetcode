package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseInteger {
    public int reverse(int x) {
    	int result = 0;
    	boolean positive = x > 0;
    	char[] digits = getDigits(x);
    	int overflowEdge = Integer.MIN_VALUE / 10;
    	for(int i = digits.length - 1; i >= 0 && digits[i] != 0; i--) {
    		if(result < overflowEdge) {
    			return 0;
    		}
    		result = result * 10 - (digits[i] - '0');
    	}
     	return positive ? -result : result;
    }
    
    private char[] getDigits(int x) {
		char[] digits = new char[10];
		int i = 9;
		int lastDigit = x % 10;
		lastDigit = lastDigit > 0 ? lastDigit : -lastDigit;
		digits[i--] = (char) (lastDigit + '0');
		x /= 10;
		x = x > 0 ? x : -x;
		while(x > 0) {
			digits[i--] = (char) ((x % 10) + '0');
			x /= 10;
		}
		return digits;
    }
	@Test
	public void test() {
		assertEquals(321, reverse(123));
	}

}
