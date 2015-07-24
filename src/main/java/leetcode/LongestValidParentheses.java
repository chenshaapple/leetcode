package leetcode;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class LongestValidParentheses {
	public class Solution {
		public int longestValidParentheses(String s) {
			int res = 0;
			Deque<Integer> deque = new LinkedList<>();
			for (int i = 0, left = -1; i < s.length(); i++) {
				char curr = s.charAt(i);
				if(curr == '(')
					deque.addLast(i);
				else {
					if(deque.isEmpty())
						left = i;
					else {
						deque.pollLast();
						if(deque.isEmpty())
							res = Math.max(res, i - left);
						else
							res = Math.max(res, i - deque.getLast());
					}
				}
			}
			return res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test1() {
		String s = ")()())";
		assertEquals(4, sln.longestValidParentheses(s));
	}

	@Test
	public void test2() {
		String s = "()(()";
		assertEquals(2, sln.longestValidParentheses(s));
	}

	@Test
	public void test3() {
		String s = "(()";
		assertEquals(2, sln.longestValidParentheses(s));
	}
	
	@Test
	public void test4() {
		String s = "()";
		assertEquals(2, sln.longestValidParentheses(s));
	}
}
