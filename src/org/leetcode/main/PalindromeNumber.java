package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumber {
	public class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;
			int digitCapacity = getDigitCapacity(x);
			while (digitCapacity > 1) {
				int denominator = (int) Math.pow(10, digitCapacity - 1);
				if (x / denominator != x % 10)
					return false;
				x = (x % denominator) / 10;
				digitCapacity -= 2;
			}
			return true;
		}

		private int getDigitCapacity(int x) {
			int res = 0;
			while (x > 0) {
				res++;
				x /= 10;
			}
			return res;
		}
	}

	public class Solution2 {
		public boolean isPalindrome(int x) {
	        if(x < 0) return false;
			int digits = 0;
			int origin = x;
			while(x > 0) {
				digits++;
				x /= 10;
			}
			while(digits > 0) {
				int divisor = (int)Math.pow(10, digits - 1);
				int left = origin / divisor;
				int right = origin % 10;
				if(left != right) return false;
				origin = (origin % divisor) / 10;
				digits -= 2;
			}
			return true;
		}
	}
	private Solution sln = new Solution();
	@Test
	public void test() {
		assertEquals(true, sln.isPalindrome(12321));
	}

	@Test
	public void test1() {
		assertEquals(true, sln.isPalindrome(123321));
	}

	@Test
	public void test2() {
		assertEquals(false, sln.isPalindrome(1234123));
	}

	@Test
	public void test3() {
		assertEquals(false, sln.isPalindrome(1000021));
	}
}
