package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(num.length == 0) {
        	return result;
        }
        Arrays.sort(num);
        Set<List<Integer>> tmp = new HashSet<>();
        find(tmp, new LinkedList<Integer>(), num, target, 0);
        for(List<Integer> combination : tmp) {
        	result.add(combination);
        }
        return result;
    }
    
    private void find(Set<List<Integer>> result, List<Integer> combination, 
    		int[] candidates, int target, int begin) {
    	if(target < 0) {
    		return;
    	}
    	if(target == 0) {
    		result.add(new LinkedList<>(combination));
    		return;
    	}
    	for(int i = begin; i < candidates.length; i++) {
    		combination.add(candidates[i]);
    		find(result, combination, candidates, target - candidates[i], i + 1);
    		combination.remove(combination.size() - 1);
    	}
    }
    
	@Test
	public void test() {
		List<List<Integer>> result = combinationSum2(new int[]{2,2,3,7}, 7);
		assertEquals(2, result.size());
	}

}
