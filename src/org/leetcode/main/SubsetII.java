package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(num);
        Set<List<Integer>> tmp = new HashSet<>();
        tmp.add(new LinkedList<Integer>());
        for(int i = 0; i < num.length; i++){
        	List<List<Integer>> largerSubsets = new LinkedList<>();
        	for(List<Integer> list : tmp) {
        		List<Integer> subSet = new LinkedList<>();
            	subSet.addAll(list);
            	subSet.add(num[i]);
            	largerSubsets.add(subSet);
        	}
        	for(List<Integer> list : largerSubsets) {
        		tmp.add(list);
        	}
        }
        for(List<Integer> list : tmp) {
            result.add(list);
        }
        return result; 
    }

	@Test
	public void test() {
		List<List<Integer>> result = subsetsWithDup(new int[]{1,1});
		System.out.println(result.size());
	}

}
