package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		grayCode(result, new LinkedList<>(), n);
		return result;
	}

	private void grayCode(List<Integer> result, Deque<Boolean> digits, int n) {
		if (n == 0) {
			result.add(convert(digits));
			return;
		}
		digits.add(false);
		grayCode(result, digits, n - 1);
		digits.remove(digits.size() - 1);
		digits.add(true);
		grayCode(result, digits, n - 1);
		digits.remove(digits.size() - 1);
	}

	private int convert(Deque<Boolean> digits) {
		int tmp = 0;
		for(Boolean digit : digits) {
			tmp = (tmp << 1) + (digit ? 1 : 0);
		}
		return tmp;
	}

	@Test
	public void test() {
		List<Integer> result = grayCode(2);
		assertEquals(4, result.size());
	}

	@Test
	public void testConvertor() {
		Deque<Boolean> digits = new LinkedList<>();
		digits.push(false);
		digits.push(false);
		digits.push(true);
		assertEquals(4, convert(digits));
	}
}
