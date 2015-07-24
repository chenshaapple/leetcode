package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class Combinations {
	public class Solution {
		private List<List<Integer>> res;
		private List<Integer> item;
		private int n;
		private int k;

		public List<List<Integer>> combine(int n, int k) {
			this.n = n;
			this.k = k;
			res = new ArrayList<>();
			item = new ArrayList<>(k);
			combine(1);
			return res;
		}

		private void combine(int begin) {
			if (item.size() == k) {
				res.add(new ArrayList<>(item));
				return;
			}
			for (int i = begin; i <= n ; i++) {
				item.add(i);
				combine(i + 1);
				item.remove(item.size() - 1);
			}
		}
	}

	private Solution sln = new Solution();
	
	@Test
	public void test() {
		List<List<Integer>> result = sln.combine(4, 2);
		result.forEach(l -> System.out.println(l));
		assertEquals(6, result.size());
	}

	// @Test
	public void testAdd() {
		List<Integer> options = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			options.add(i + 1);
		}
		int tmp = options.get(2);
		options.remove(2);
		options.add(2, tmp);
		assertEquals(Integer.valueOf(tmp), options.get(2));
	}
}
