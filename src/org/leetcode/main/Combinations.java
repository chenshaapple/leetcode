package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		if(k > n) {
			return new LinkedList<>();
		}
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> options = getOptions(n);
		combine(result, new LinkedList<>(), options, k);
		return result;
	}

	private List<Integer> getOptions(int n) {
    	 List<Integer> result = new LinkedList<>();
    	 for(int i = 0; i < n; i++) {
    		 result.add(i + 1);
    	 }
    	 return result;
    }

	private void combine(List<List<Integer>> result, List<Integer> combine,
			List<Integer> options, int k) {
		if (k <= 0) {
			result.add(new LinkedList<>(combine));
			return;
		}
		for(int i = 0; i <= options.size() - k; i++) {
			int tmp = options.get(i);
			if(combine.size() > 0 && tmp < combine.get(combine.size() - 1)) {
				continue;
			}
			combine.add(tmp);
			options.remove(i);
			combine(result, combine, options, k - 1);
			combine.remove(combine.size() - 1);
			options.add(i, tmp);
		}
	}

	@Test
	public void test() {
		List<List<Integer>> result = combine(4, 2);
		assertEquals(6, result.size());
	}

//	@Test
	public void testAdd() {
		List<Integer> options = new LinkedList<>();
		for(int i = 0; i < 4; i++) {
			options.add(i + 1);
		}
		int tmp = options.get(2);
		options.remove(2);
		options.add(2, tmp);
		assertEquals(Integer.valueOf(tmp), options.get(2));
	}
}
