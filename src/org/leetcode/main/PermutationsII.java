package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
		return res;
	}

	private void helper(int[] num, boolean[] used, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == num.length) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && !used[i - 1] && num[i] == num[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				item.add(num[i]);
				helper(num, used, item, res);
				item.remove(item.size() - 1);
				used[i] = false;
			}
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
