package leetcode;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class SubsetsII {
	/**
	 * using hashset to guarantee there is no duplication
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(num);
		Set<List<Integer>> tmp = new HashSet<>();
		tmp.add(new LinkedList<Integer>());
		for (Integer i : num) {
			List<List<Integer>> largerSubsets = new LinkedList<>();
			for (List<Integer> list : tmp) {
				List<Integer> subSet = new LinkedList<>(list);
				subSet.add(i);
				largerSubsets.add(subSet);
			}
			tmp.addAll(largerSubsets);
		}
		for (List<Integer> list : tmp) {
			result.add(list);
		}
		return result;
	}

	/**
	 * without hashset
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup2(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		subsetsWithDup2(res, new ArrayList<Integer>(), num, 0);
		return res;
	}

	private void subsetsWithDup2(List<List<Integer>> res, List<Integer> item,
			int[] num, int begin) {
		res.add(new ArrayList<Integer>(item));
		for (int i = begin; i < num.length; i++) {
			if (i > begin && num[i] == num[i - 1])
				continue;
			item.add(num[i]);
			subsetsWithDup2(res, item, num, i + 1);
			item.remove(item.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] num = new int[] { 1, 1 };
		assertEquals(subsetsWithDup(num), subsetsWithDup2(num));
	}
}
