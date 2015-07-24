package leetcode;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0) {
        		n /= 5;
        		res += (n);
        }
        return res;
    }
    
    private String factorial(int n) {
    		BigDecimal res = BigDecimal.valueOf(1);
    		for(int i = 0; i < n; i++) {
    			res = res.multiply(BigDecimal.valueOf(i + 1));
    		}
    		return res.toString();
    }
	@Test
	public void test() {
		for(int i = 0; i < 50; i++) {
			String factorial = factorial(i + 1);
			System.out.println((i + 1) + ": " + trailingZeroes(i + 1) + " "+ factorial);
		}
	}

	@Test
	public void testZero() {
		System.out.println(Double.valueOf(0).equals(0.0));
		System.out.println(Double.valueOf(0.0).equals(Double.valueOf(0)));
        double x = 0.00000000000000000;
        double y = 0.00000000000000001;
        System.out.println(x==0);
        System.out.println(y==0);
	}
}
