package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
	}

	private boolean isMatch(char[] s, int index, char[] p, int offset) {
		if (offset == p.length) {
			return index == s.length;
		}
		if ((offset + 1 < p.length) && p[offset + 1] == '*') {
			while (index < s.length
					&& (s[index] == p[offset] || p[offset] == '.')) {
				if (isMatch(s, index, p, offset + 2)) {
					return true;
				}
				index++;
			}
			return isMatch(s, index, p, offset + 2);
		} else {
			if (index < s.length && (s[index] == p[offset] || p[offset] == '.')) {
				return isMatch(s, ++index, p, ++offset);
			}
		}
		return false;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(true, isMatch("aab", "c*a*b"));
	}

	@Test
	public void test6() {
		assertEquals(true, isMatch("ab", ".*"));
	}

	@Test
	public void test5() {
		assertEquals(true, isMatch("aa", ".*"));
	}

	@Test
	public void test4() {
		assertEquals(true, isMatch("aa", "a*"));
	}

	@Test
	public void test3() {
		assertEquals(false, isMatch("aaa", "aa"));
	}

	@Test
	public void test2() {
		assertEquals(true, isMatch("aa", "aa"));
	}

	@Test
	public void test1() {
		assertEquals(false, isMatch("aa", "a"));
	}

	@Test
	public void test8() {
		assertEquals(true, isMatch("a", "ab*"));
	}
}
