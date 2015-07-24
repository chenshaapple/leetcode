package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/*
 * ˼·���밴��һ���������������У�����һ��set,���е�Ԫ��ÿһ����������ʹ��һ�Σ�����set���Ը���subsets���ҳ������Ӷ�N^2
 * Ȼ����̽ÿһ��subset�ܷ�ó�combination,ͬʱһ��subset�����ж��combination,����˼·ÿ�ζ���Ҫ�ҵ���ȷ�Ĳ���λ�ã�ͦ�鷳
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(candidates);
		find(result, new LinkedList<Integer>(), candidates, target, 0);
		return result;
	}

	private void find(List<List<Integer>> result, List<Integer> combination,
			int[] candidates, int target, int begin) {
		if (target < 0) return;
		if (target == 0) {
			result.add(new LinkedList<>(combination));
			return;
		}
		for (int i = begin; i < candidates.length; i++) {
			// ���ǵ������ظ�Ԫ�أ���Ϊ��ǰһ��Ԫ����ȣ������Ѿ���̽���ˣ�ֱ������
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			combination.add(candidates[i]);
			find(result, combination, candidates, target - candidates[i], i);
			combination.remove(combination.size() - 1);
		}
	}

	public class Solution {
		private int[] candidates;
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			this.candidates = candidates;
			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(candidates);
			combinationSum(0, res, new LinkedList<>(), target);
			return res;
		}
		
		/**
		 * OPTION define: the <b>begin</b> candidate can be used 0, 1, ... times
		 * @param begin
		 * @param res
		 * @param item
		 * @param target
		 */
		private void combinationSum(int begin, List<List<Integer>> res, List<Integer> item, int target) {
			if(target == 0) {
				res.add(new ArrayList<>(item));
				return;
			}
			if(begin == candidates.length) return;
			if(begin != 0 && candidates[begin] == candidates[begin - 1]) return;
			int curr = candidates[begin];
			for(int i = 1; i * curr <= target; i++) {
				for(int j = 0; j < i; j++)
					item.add(curr);
				combinationSum(begin + 1, res, item, target - i * curr);
				for(int j = 0; j < i; j++)
					item.remove(item.size() - 1);
			}
			combinationSum(begin + 1, res, item, target);
		}
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		List<List<Integer>> result = sln.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		result.forEach(list->System.out.println(list));
		assertEquals(2, result.size());
	}

}
