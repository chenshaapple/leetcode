package org.leetcode.main;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		long nume = numerator > 0 ? numerator : -(long)numerator, deno = denominator > 0 ? denominator
				: -(long)denominator;
		Map<Long, Integer> map = new HashMap<>();
		if (nume > 0 && (numerator ^ denominator) < 0) {
			result.append("-");
		}
		if (nume > deno) {
			result.append(nume / deno);
			map.put(nume, result.length() - 1);
			nume = (nume % deno) * 10;
		} else {
			result.append("0");
			nume *= 10;
		}
		if (nume > 0) {
			result.append(".");
		}
		while (!map.containsKey(nume) && nume > 0) {
			result.append(nume / deno);
			map.put(nume, result.length() - 1);
			nume = (nume % deno) * 10;
		}
		if (map.containsKey(nume)) {
			result.insert(map.get(nume), "(");
			result.append(")");
		}
		return result.toString();
	}

	// @Test
	public void testFloor() {
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(20);
		BigDecimal numerator = BigDecimal.valueOf(20);
		BigDecimal divisor = BigDecimal.valueOf(23);
		BigDecimal result = numerator.divide(divisor, 100,
				BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		System.out.println(format.format(200.0 / 23));
	}

	@Test
	public void test() {
		assertEquals("0.(6)", fractionToDecimal(2, 3));
	}

	@Test
	public void test1() {
		assertEquals("0.2", fractionToDecimal(1, 5));
	}

	@Test
	public void test2() {
		assertEquals("1.2", fractionToDecimal(6, 5));
	}

	@Test
	public void test3() {
		assertEquals("1.(3)", fractionToDecimal(4, 3));
	}

	@Test
	public void test4() {
		assertEquals("0.1(6)", fractionToDecimal(1, 6));
	}

	@Test
	public void test5() {
		assertEquals("0", fractionToDecimal(0, 3));
	}

	@Test
	public void test6() {
		assertEquals("0", fractionToDecimal(0, -5));
	}

	@Test
	public void test7() {
		assertEquals("-0.2", fractionToDecimal(-1, 5));
	}
	
	@Test
	public void test8() {
		assertEquals("0.0000000004656612873077392578125", fractionToDecimal(-1, Integer.MIN_VALUE));
	}
	
	@Test
	public void testMinInteger() {
		System.out.println(-(long)Integer.MIN_VALUE);
	}
	
	@Test
	public void testEdge() {
		assertEquals(String.valueOf(Integer.MIN_VALUE), fractionToDecimal(Integer.MIN_VALUE, 1));
	}
}
