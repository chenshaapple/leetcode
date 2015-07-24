package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
        		res = res * 26 + (s.charAt(i) - 'A'  + 1);
        }
        return res;
    }
	@Test
	public void test() {
		assertEquals(27, titleToNumber("AA"));
	}

	@Test
	public void test1() {
		assertEquals(28, titleToNumber("AB"));
	}
	
	@Test
	public void test2() {
		assertEquals(26, titleToNumber("Z"));
	}
}
