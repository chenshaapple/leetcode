package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class CombinationSumII {
	public class Solution {
		private int[] candidates;

		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			this.candidates = candidates;
			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(this.candidates);
			combinationSum2(res, new LinkedList<>(), 0, target);
			return res;
		}

		private void combinationSum2(List<List<Integer>> res,
				List<Integer> item, int begin, int target) {
			if (target == 0) {
				res.add(new ArrayList<>(item));
				return;
			}
			for (int i = begin; i < candidates.length; i++) {
				if (target < candidates[i])
					return;
				if (i != begin && candidates[i] == candidates[i - 1])
					continue;
				item.add(candidates[i]);
				combinationSum2(res, item, i + 1, target - candidates[i]);
				item.remove(item.size() - 1);
			}
		}
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		List<List<Integer>> result = sln.combinationSum2(new int[] { 10, 1, 2,
				7, 6, 1, 5 }, 8);
		result.forEach(list -> System.out.println(list));
		assertEquals(4, result.size());
	}

}
