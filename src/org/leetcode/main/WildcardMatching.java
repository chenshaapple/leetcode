package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 这道题目一开始一直MLE,所以就不用二维的了，
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] opt = new boolean[2][p.length() + 1];
        opt[0][0] = true;
        for(int i = 1; i < p.length() + 1; i++) {
        	if(p.charAt(i - 1) == '*') {
        		opt[0][i] = opt[0][i - 1];
        	}
        }
        int currentRow = 1, lastRow = 0;
        for(int i = 1; i < s.length() + 1; i++) {
        	for(int j = 1; j < p.length() + 1; j++) {
        		char current = p.charAt(j - 1);
        		if(current == '?') {
        			opt[currentRow][j] = opt[lastRow][j - 1];
        		} else if(current == '*') {
        			opt[currentRow][j] = opt[currentRow][j - 1] || opt[lastRow][j - 1];
        		} else {
        			opt[currentRow][j] = opt[lastRow][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
        		}
        	}
        	currentRow = (currentRow + 1) % 2;
        	lastRow = (lastRow + 1) % 2;
        }
        return opt[lastRow][p.length()]; 
    }
	@Test
	public void test() {
		assertEquals(false, isMatch("aa", "a"));
	}

	@Test
	public void test1() {
		assertEquals(true, isMatch("aa", "aa"));
	}
	
	@Test
	public void test2() {
		assertEquals(false , isMatch("aaa", "aa"));
	}
	
	@Test
	public void test3() {
		assertEquals(true, isMatch("aa", "*"));
	}
	
	@Test
	public void test4() {
		assertEquals(true, isMatch("aa", "a*"));
	}
	
	@Test
	public void test5() {
		assertEquals(true, isMatch("ab", "?*"));
	}
	
	@Test
	public void test6() {
		assertEquals(false, isMatch("aab", "c*a*b"));
	}
	
	@Test
	public void test7() {
		assertEquals(false, isMatch("bbbaab", "a**?***"));
	}
}
