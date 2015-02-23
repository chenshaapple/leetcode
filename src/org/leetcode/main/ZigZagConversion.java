package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(nRows < 2) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		int step = (nRows - 1) * 2;
		int index = 0;
		for (int i = 0; i < nRows; i++) {
			index = i;
			boolean downThenUp = true;
			int initStep = (nRows - i - 1) * 2 == 0 ? step : (nRows - i - 1) * 2;
			while (index < s.length()) {
				result.append(s.charAt(index));
				index += downThenUp ? initStep : ((step - initStep) == 0 ? step : step - initStep);
				downThenUp = !downThenUp;
			}
		}
		return result.toString();
	}

	@Test
	public void test3() {
		assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
	}
	
	@Test
	public void test4() {
		System.out.println();
		System.out.println(convert("PAYPALISHIRING", 4));
		assertEquals("PAYPALISHIRING".length(), convert("PAYPALISHIRING", 3).length());
	}
	
	@Test
	public void test1() {
		String s = "PAYPALISHIRING";
		String result = convert(s, 1);
		assertEquals(s, result);
	}

	@Test
	public void test2() {
		String s = "PAYPALISHIRING";
		String result = convert(s, 2);
	}
}
