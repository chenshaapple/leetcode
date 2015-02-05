package org.leetcode.main;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] lowerArray = getAlphanumericArray(s);
		for (int i = 0; i < lowerArray.length / 2; i++) {
			if(lowerArray[i] != lowerArray[ lowerArray.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	private char[] getAlphanumericArray(String s) {
		if(s == null) {
			return new char[0];
		}
		char[] origin = new char[s.length()];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current >= 'a' && current <= 'z') {
				origin[count++] = current;
			} else if (current >= 'A' && current <= 'Z') {
				origin[count++] = (char) (current - 'A' + 'a');
			} else if (current >= '0' && current <= '9') {
				origin[count++] = current;
			}
		}
		char[] result = new char[count];
		System.arraycopy(origin, 0, result, 0, result.length);
		return result;
	}

	@Test
	public void test() {
//		System.out.println(getAlphabetArray("Aha...QaQ"));
//		assertTrue(Arrays.equals(getAlphabetArray("Aha...QaQ"), new char[] {
//				'a', 'h', 'a', 'q', 'a', 'q' }));
		assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(isPalindrome("race a car"));
		assertTrue(isPalindrome(null));
		assertTrue(isPalindrome(""));
		assertFalse(isPalindrome("1a2"));
	}
}
