package org.leetcode.main;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.Test;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
    	StringBuilder result = new StringBuilder();
    	BigDecimal fraction = new BigDecimal(numerator).divide(new BigDecimal(denominator));
    	if(fraction.compareTo(BigDecimal.ZERO) < 0) {
    		result.append("-");
    	}
    	return result.toString();
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testFloor() {
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(20);
		System.out.println((int)-1.5);
		BigDecimal numerator = BigDecimal.valueOf(20);
		BigDecimal divisor = BigDecimal.valueOf(23);
		BigDecimal result = numerator.divide(divisor, 50,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(result);
		System.out.println(format.format(200.0 / 23));
	}
}
