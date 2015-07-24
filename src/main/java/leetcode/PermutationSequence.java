package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		List<Integer> permutations = getPermutationCount(n - 1);
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		k--;
		for (int i = n - 2; i >= 0; i--) {
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
		for (int i = 1; i <= n; i++) {
			tmp *= i;
			result.add(tmp);
		}
		return result;
	}

	public class Solution {
		public String getPermutation(int n, int k) {
			StringBuilder res = new StringBuilder();
			List<Integer> digits = new ArrayList<>(n);
			List<Integer> counts = count(n);
			for (int i = 0; i < n; i++)
				digits.add(i + 1);
			k -= 1;
			for (int i = 0; i < n - 1; i++) {
				Integer count = counts.get(n - 2 - i);
				int digit = digits.remove(k / count);
				res.append(digit);
				k = k % count;
			}
			res.append(digits.get(0));
			return res.toString();
		}
		
		public List<Integer> count(int n) {
			List<Integer> res = new ArrayList<>(n);
			int product = 1;
			for(int i = 0; i < n; i++) {
				product *= i + 1;
				res.add(product);
			}
			return res;
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		assertEquals("312", sln.getPermutation(3, 5));
	}

	@Test
	public void case2() {
		assertEquals("1", sln.getPermutation(1, 1));
	}
	
	@Test
	public void case3() {
		assertEquals("21", sln.getPermutation(2, 2));
	}
	
	@Test
	public void case4() {
		assertEquals("132", sln.getPermutation(3, 2));
	}

	@Test
	public void case5() {
		assertEquals("3124", sln.getPermutation(4, 17));
	}
}
