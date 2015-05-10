package org.leetcode.main;

import org.junit.Test;

import java.util.*;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		permuteUnique(res, new LinkedList<>(), num, new boolean[num.length]);
		return res;
	}

	private void permuteUnique(List<List<Integer>> res, List<Integer> item,
			int[] num, boolean[] visited) {
		if (item.size() == num.length) {
			res.add(new ArrayList<>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if(i != 0 && !visited[i - 1] && num[i] == num[i - 1]) continue;
			if(!visited[i]) {
				visited[i] = true;
				item.add(num[i]);
				permuteUnique(res, item, num, visited);
				item.remove(item.size() - 1);
				visited[i] = false;
			}
		}
	}

	@Test
	public void test() {
		System.out.println(permuteUnique(new int[]{1,1,2}));
	}

}
