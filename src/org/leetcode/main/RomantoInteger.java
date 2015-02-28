package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
/*
 * 根据罗马字母的定义，右+左减，这个实现无法判断错误输入，但是能AC，这是Leetcode的问题了
 */
public class RomantoInteger {
	private Map<Character, Integer> dict = new HashMap<>();
	{
		dict.put('I', 1);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('L', 50);
		dict.put('C', 100);
		dict.put('D', 500);
		dict.put('M', 1000);
	}
    public int romanToInt(String s) {
    	int result = 0;
    	if(s.length() < 1) {
    		return 0;
    	}
    	int lastDigit = dict.get(s.charAt(s.length() - 1));
    	result += lastDigit;
    	int currentDigit;
    	for(int i = s.length() - 2; i >= 0; i--) {
    		char charAt = s.charAt(i);
			currentDigit = dict.get(charAt);
    		result += currentDigit >= lastDigit ? currentDigit : -currentDigit;
    		lastDigit = currentDigit;
    	}
    	return result;
    }
	@Test
	public void test() {
		assertEquals(2016, romanToInt("MMXVI"));
	}
	
	@Test
	public void test1() {
		assertEquals(1997, romanToInt("MCMXCVII"));
	}

}
