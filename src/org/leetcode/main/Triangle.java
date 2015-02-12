package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        int[][] opt = new int[2][triangle.size()];
        int upper = 0, current = upper + 1;
        for(List<Integer> level : triangle) {
        	for(int i = 0; i < level.size(); i++) {
        		int left, right;
        		if(i == 0) {
        			left = right = opt[upper][i];
        		} else if(i == level.size() - 1) {
        			left = right = opt[upper][i - 1];
        		} else {
        			left = opt[upper][i - 1];
        			right = opt[upper][i];
        		}
        		opt[current][i] = Math.min(left + level.get(i), right + level.get(i));
        	}
        	upper = (++upper) % 2;
        	current = (++current) % 2;
        }
        for(int i = 0; i < triangle.size(); i++) {
        	result = Math.min(opt[upper][i], result);
        }
        return result;
    }
	@Test
	public void test() {
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		System.out.println(minimumTotal(triangle));
	}

}
