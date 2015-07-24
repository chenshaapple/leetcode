package leetcode;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class MultiplyStrings {
    public class Solution {
        public String multiply(String num1, String num2) {
        		return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
        }
    }
}
