package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/*
 * 思路：想按照一个基本规则来进行，给定一个set,其中的元素每一个必须至少使用一次，这种set可以根据subsets来找出，复杂度N^2
 * 然后试探每一个subset能否得出combination,同时一个subset可以有多个combination,这种思路每次都需要找到正确的插入位置，挺麻烦
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
    		//考虑到存在重复元素，因为跟前一个元素相等，所以已经试探过了，直接跳过
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
