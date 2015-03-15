package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountandSay {

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		StringBuilder result = new StringBuilder("1");
		for(int i = 1; i < n; i++) {
			String last = result.toString();
			result.delete(0, result.length());
			char value = last.charAt(0);
			int count = 1;
			for(int j = 1; j < last.length(); j++) {
				char curt = last.charAt(j);
				if(curt != value) {
					result.append(count);
					result.append(value);
					value = curt;
					count = 1;
				} else {
					count++;
				}
			}
			result.append(count);
			result.append(value);
		}
		return result.toString();
	}

	@Test
	public void test1() {
		assertEquals("1", countAndSay(1));
	}
	
	@Test
	public void test2() {
		assertEquals("11", countAndSay(2));
	}

}
