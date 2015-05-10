package org.leetcode.main;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class ValidParentheses {
	public class Solution {
		public boolean isValid(String s) {
			Deque<Character> deque = new LinkedList<>();
			for (Character curr : s.toCharArray()) {
				if (deque.isEmpty()) {
					deque.addLast(curr);
				} else {
					int gap = curr - deque.getLast();
					if (gap > 0 && gap < 3)
						deque.pollLast();
					else
						deque.addLast(curr);
				}
			}
			return deque.isEmpty();
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals(true, sln.isValid("([])"));
	}

	@Test
	public void testisValid() {
		assertEquals(false, sln.isValid("[([]])"));
	}

	@Test
	public void testCharValue() {
		System.out.println((int) '[');
		System.out.println((char) 92);
		System.out.println((int) ']');
		System.out.println((int) '{');
		System.out.println((char) 124);
		System.out.println((int) '}');
		System.out.println((int) '(');
		System.out.println((int) ')');
	}
}
