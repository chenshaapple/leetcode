package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	if(digits.length == 0) {
    		return new int[]{1};
    	}
    	boolean isOverFlow = true;
    	int i = digits.length - 1;
    	while(isOverFlow && i >= 0) {
    		int sum = digits[i] + 1;
    		if(sum < 10) {
    			isOverFlow = false;
    			
    		} else {
    			sum = sum % 10;
    		}
    		digits[i] = sum;
    		i--;
    	}
    	if(isOverFlow) {
    		int[] result = new int[digits.length + 1];
    		System.arraycopy(digits, 0, result, 1, digits.length);
    		result[0] = 1;
    		return result;
    	}
    	return digits;
    }
	@Test
	public void test() {
		int[] result = plusOne(new int[]{8});
		assertEquals(new int[]{9}, result);
	}

	@Test
	public void testOverFlow() {
		int[] result = plusOne(new int[]{9,9});
		assertEquals(new int[]{1,0,0}, result);
	}
	
}
