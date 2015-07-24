package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		while (n > 0) {
			n -= 1;
			res.append((char) ('A' + (n % 26)));
			n /= 26;
		}
		return res.reverse().toString();
	}
	
	

	@Test
	public void test() {
		for (int i = 0; i < 26; i++) {
			System.out.println(i + 1 + convertToTitle(i + 1));
			assertEquals(String.valueOf((char) ('A' + i)), convertToTitle(i + 1));
		}
	}

	@Test
	public void test1() {
		assertEquals("AB", convertToTitle(28));
	}

	@Test
	public void test2() {
		assertEquals("AZ", convertToTitle(52));
	}
}
