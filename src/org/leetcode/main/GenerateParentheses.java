package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<>();
		generateParenthesis(result, new StringBuilder(), n, n);
		return result;
	}

	private void generateParenthesis(List<String> result, StringBuilder option,
			int restLeft, int restRight) {
		if (restLeft <= 0) {
			for (int i = 0; i < restRight; i++) {
				option.append(")");
			}
			result.add(option.toString());
			option.delete(option.length() - restRight, option.length());
			return;
		}
		option.append("(");
		generateParenthesis(result, option, restLeft - 1, restRight);
		option.deleteCharAt(option.length() - 1);
		if(restLeft < restRight) {
			option.append(")");
			generateParenthesis(result, option, restLeft, restRight - 1);
			option.deleteCharAt(option.length() - 1);
		}
	}

	@Test
	public void test() {
		List<String> result = generateParenthesis(3);
		assertEquals(5, result.size());
	}

//	@Test
	public void testDelete() {
		StringBuilder builder = new StringBuilder();
		builder.append(1);
		builder.append(2);
		builder.append(1);
		builder.append(2);
		builder.delete(builder.length() - 2, builder.length());
		System.out.println(builder.toString());
	}
}
