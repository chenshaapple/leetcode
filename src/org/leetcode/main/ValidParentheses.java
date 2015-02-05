package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidParentheses {
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push(s.charAt(i));
				break;
			case '{':
				stack.push(s.charAt(i));
				break;
			case '[':
				stack.push(s.charAt(i));
				break;
			case ')':
				if (stack.peek() == null || !stack.peek().equals('(')) {
					return false;
				}
				stack.pop();
				break;
			case '}':
				if (stack.peek() == null || !stack.peek().equals('{')) {
					return false;
				}
				stack.pop();
				break;
			case ']':
				if (stack.peek() == null || !stack.peek().equals('[')) {
					return false;
				}
				stack.pop();
				break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public int longestValidParentheses(String s) {
		LinkedList<Integer> stack = new LinkedList<>(); //for there is only bracket, if not, it's a harder problem
		int max = 0;
		for (int i = 0 , left = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);//every '(' determine a left border
			} else {
				//bad-formed
				if(stack.isEmpty()) {
					left = i + 1;
				} else {
					stack.pop();
					if(stack.isEmpty()) {
						//current is well-formed
						max = Math.max(max, i - left + 1);
					} else {
						//the peek's next is the left border
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals(true, isValid("([])"));
	}

	@Test
	public void testLongest1() {
		assertEquals(0, longestValidParentheses("("));
	}

	@Test
	public void testLongest2() {
		assertEquals(6, longestValidParentheses("(()())"));
	}

	@Test
	public void testLongest3() {
		assertEquals(2, longestValidParentheses("()"));
	}

	@Test
	public void testLongest4() {
		assertEquals(2, longestValidParentheses("()(()"));
	}

	@Test
	public void testLongest5() {
		assertEquals(4, longestValidParentheses("(()()"));
	}

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
