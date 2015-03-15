package org.leetcode.main;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        BigDecimal value1 = new BigDecimal(num1);
        BigDecimal value2 = new BigDecimal(num2);
        return value1.multiply(value2).toString();
    }
    
    @Test
    public void testMaxLong() {
    		System.out.println(Long.MAX_VALUE);
    }
    
	@Test
	public void test() {
		System.out.println(multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));
	}

}
