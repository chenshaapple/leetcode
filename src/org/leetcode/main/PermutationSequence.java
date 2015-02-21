package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		List<Integer> permutations = getPermutationCount(n - 1);
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		k--;
		for(int i = n - 2; i >= 0; i--) {
			int index = k / permutations.get(i);
			result.append(numbers.get(index));
			numbers.remove(index);
			k = k % permutations.get(i);
		}
		result.append(numbers.get(0));
		return result.toString();
	}

	private List<Integer> getPermutationCount(int n) {
		List<Integer> result = new ArrayList<>();
		int tmp = 1;
		for(int i = 1; i <= n; i++) {
			tmp *= i;
			result.add(tmp);
		}
		return result;
	}
	@Test
	public void test() {
		System.out.println(getPermutation(8, 8590));
		assertEquals("123", getPermutation(3, 1));
	}

}
