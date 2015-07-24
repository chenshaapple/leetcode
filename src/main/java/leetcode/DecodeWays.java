package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeWays {
	//很容易将空间复杂度优化成o(1)
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int[] opt = new int[s.length() + 1];
		opt[0] = 1;
		opt[1] = 1;
		for (int i = 2; i < s.length() + 1; i++) {
			char curt = s.charAt(i - 1);
			char prev = s.charAt(i - 2);
			if (curt == '0') {
				if(prev == '1' || prev == '2') {
					opt[i] = opt[i - 2];
				} else {
					return 0;//message is illegal
				}
			} else if (curt >= '1' && curt <= '6') {
				if(prev == '1' || prev == '2') {
					opt[i] = opt[i - 1] + opt[i - 2];
				} else {
					opt[i] = opt[i - 1];
				}
			} else {
				if(prev == '1') {
					opt[i] = opt[i - 1] + opt[i - 2];
				} else {
					opt[i] = opt[i - 1];
				}
			}
		}
		return opt[s.length()];
	}

	@Test
	public void test() {
		assertEquals(2, numDecodings("12"));
	}

	@Test
	public void test110() {
		assertEquals(1, numDecodings("110"));
	}
	
	@Test
	public void test10() {
		assertEquals(1, numDecodings("10"));
	}
	
	@Test
	public void test611() {
		assertEquals(2, numDecodings("611"));
	}
	
	@Test
	public void test111() {
		assertEquals(3, numDecodings("111"));
	}
	
	@Test
	public void test12120() {
		assertEquals(3, numDecodings("12120"));
	}
	
	@Test
	public void test17() {
		assertEquals(2, numDecodings("17"));
	}
	
	@Test
	public void test1212() {
		assertEquals(5, numDecodings("1212"));
	}
}
