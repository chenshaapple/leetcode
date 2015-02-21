package org.leetcode.main;

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
        if(candidates.length == 0) {
        	return result;
        }
        Arrays.sort(candidates);
        find(result, new LinkedList<Integer>(), candidates, target, 0);
        return result;
    }
    
    private void find(List<List<Integer>> result, List<Integer> combination, 
    		int[] candidates, int target, int begin) {
    	if(target < 0) {
    		return;
    	}
    	if(target == 0) {
    		result.add(new LinkedList<>(combination));
    		return;
    	}
    	for(int i = begin; i < candidates.length; i++) {
    		//���ǵ������ظ�Ԫ�أ���Ϊ��ǰһ��Ԫ����ȣ������Ѿ���̽���ˣ�ֱ������
    		if(i > 0 && candidates[i] == candidates[i - 1]) {
    			continue;
    		}
    		combination.add(candidates[i]);
    		find(result, combination, candidates, target - candidates[i], i);
    		combination.remove(combination.size() - 1);
    	}
    }
    
    
	@Test
	public void test() {
		List<List<Integer>> result = combinationSum(new int[]{2,3,6,7}, 7);
		assertEquals(2, result.size());
	}

}
