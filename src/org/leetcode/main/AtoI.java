package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtoI {

	public int atoiPre(String str) {
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == ' ') {
				continue;
			} else if (current == '-') {
				return (int) (-1 * convert(str.substring(i + 1)));
			} else if (current == '+') {
				return (int) Long.min(Integer.MAX_VALUE,
						convert(str.substring(i + 1)));
			} else if (current >= '0' && current <= '9') {
				return (int) Long.min(Integer.MAX_VALUE,
						convert(str.substring(i)));
			} else {
				break;
			}
		}
		return 0;
	}

	long convert(String numericString) {
		long result = 0;
		long max = 1L + Integer.MAX_VALUE;
		for (int i = 0; i < numericString.length(); i++) {
			char current = numericString.charAt(i);
			if (current >= '0' && current <= '9') {
				result = result * 10 + (current - '0');
				if (result > max) {
					break;
				}
			} else {
				break;
			}
		}
		return Long.min(result, max);
	}

//	public int atoiForLoop(String str) {
//		boolean positive = true;
//		char current;
//		double result = 0;
//		for (int i = 0; i < str.length(); i++) {
//			current = str.charAt(i);
//			if (current == ' ') {
//				continue;
//			} else if (current == '-' || current == '+' || (current >= '0' && current <= '9')) {
//				positive = current == '-' ? false : true;
//				
//			} else {
//				break;
//			}
//		}
//		if (!positive) {
//			result = -result;
//		}
//		if (result > Integer.MAX_VALUE) {
//			result = Integer.MAX_VALUE;
//		} else if (result < Integer.MIN_VALUE) {
//			result = Integer.MIN_VALUE;
//		}
//		return (int) result;
//	}

	public int atoi(String str) {
		if (str == null || str.length() < 1) {
			return 0;
		}

		boolean positive = true;
		int i = 0;
		//double is easy to handle the overflow for it will not happen
		double result = 0;
		// trim the starting ' '
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		// get the optional sign
		if (str.charAt(i) == '-') {
			positive = false;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		// result start form here
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + str.charAt(i) - '0';
			i++;
		}
		if (!positive) {
			result = -result;
		}
		if (result > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE) {
			result = Integer.MIN_VALUE;
		}
		return (int) result;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositiveOverflow() {
		assertEquals(Integer.MAX_VALUE, atoi("  "
				+ ((long) Integer.MAX_VALUE + 1)));
	}

	@Test
	public void testNegativeOverflow() {
		assertEquals(Integer.MIN_VALUE, atoi("  " + Integer.MIN_VALUE));
	}

	@Test
	public void testInvalid() {
		assertEquals(0, atoi("+-12"));
		assertEquals(0, atoi("+   sdfj+"));
		assertEquals(0, atoi("b12345"));
	}

	@Test
	public void testPartInvalid() {
		assertEquals(12, atoi("0012as"));
	}

	@Test
	public void testLongMaxValue() {
	}
}
