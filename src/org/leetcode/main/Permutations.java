package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new LinkedList<>();
		permute(result, num, 0);
		return result;
	}

	private void permute(List<List<Integer>> result, int[] num, int begin) {
		if (begin >= num.length) {
			result.add(getPermutation(num));
			return;
		}

		// �����еĿ���Ԫ�ض����ڵ�һ����Ȼ���ʣ�µĽ��еݹ�
		for (int i = begin; i < num.length; i++) {
			swap(num, begin, i);
			permute(result, num, begin + 1);
			swap(num, begin, i);
		}
	}

	private void swap(int[] num, int index1, int index2) {
		int tmp = num[index1];
		num[index1] = num[index2];
		num[index2] = tmp;
	}

	private List<Integer> getPermutation(int[] num) {
		List<Integer> result = new LinkedList<>();
		for (int ele : num) {
			result.add(ele);
		}
		return result;
	}

	@Test
	public void test() {
		List<List<Integer>> result = permute(new int[] { 1 });
		assertEquals(1, result.size());
	}

}
