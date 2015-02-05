package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordsInString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String[] words = s.split(" ");
		if (words.length == 1 && !s.contains(" ")) {
			return s;
		}
		StringBuilder resultBuilder = new StringBuilder();
		String result;
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].equals("")) {
				continue;
			}
			resultBuilder.append(words[i] + " ");
		}
		result = resultBuilder.toString();
		if (result.endsWith(" ")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("1", reverseWords(" 1"));
	}

	@Test
	public void test2() {
		assertEquals("1", reverseWords("1 "));
	}

	@Test
	public void testSpace() {
		assertEquals("", reverseWords(" "));
	}

	@Test
	public void testSingleWorkd() {
		assertEquals("a", reverseWords("a"));
	}

	@Test
	public void testMultiSpaceSplit() {
		assertEquals("b a", reverseWords("a       b"));
	}
}
