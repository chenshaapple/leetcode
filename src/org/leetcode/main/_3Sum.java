package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
    	List<List<Integer>> result = new LinkedList<>();
        int size = num.length;
        Set<List<Integer>> tmp = new HashSet<>();
        for(int i = 0; i < size - 2; i++) {
        	int begin = i + 1, end = size - 1;
        	while(begin < end) {
        		int sum = num[i] + num[begin] + num[end];
        		if(sum == 0) {
        			tmp.add(Arrays.asList(num[i], num[begin], num[end]));
        			begin++;
        			end--;
        		} else if(sum < 0) {
        			begin++;
        		} else {
        			end--;
        		}
        	}
        }
        for(List<Integer> list : tmp) {
        	result.add(list);
        }
        return result;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
