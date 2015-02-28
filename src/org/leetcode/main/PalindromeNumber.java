package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		int digitCount = getDigitCount(x);
		int divide = (int) Math.pow(10, digitCount - 1);
		while(digitCount > 1) {
			if(x / divide !=  x % 10) {
				return false;
			}
			x = (x % divide) / 10;
			digitCount -= 2;
		}
		return true;
	}

	private int getDigitCount(int x) {
		int result = 0;
		while(x > 0) {
			x /= 10;
			result++;
		}
		return result;
	}
	
	private int getHighDigit(int x) {
		if(x/100000000 > 0) x/=100000000;
		if(x/10000 > 0) x/=10000;
		if(x/100 > 0) x/=100;
		if(x/10 > 0) x/=10;
		return x;
	}

	@Test
	public void test() {
		assertEquals(true , isPalindrome(12321));
	}

	@Test
	public void test1() {
		assertEquals(true, isPalindrome(123321));
	}
	
	@Test
	public void test2() {
		assertEquals(false, isPalindrome(1234123));
	}
	
	@Test
	public void test3() {
		assertEquals(false, isPalindrome(1000021));
	}
}
