package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class Triangle {
	public class Solution {
	    public int minimumTotal(List<List<Integer>> triangle) {
	        int[] opt = new int[triangle.size() + 1];
	        for(int i = 0; i < triangle.size(); i++) {
	            List<Integer> row = triangle.get(triangle.size() - 1 - i);
	            for(int j = 0; j < row.size(); j++) 
	                opt[j] = Math.min(opt[j], opt[j + 1]) + row.get(j);
	        }
	        return opt[0];
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(sln.minimumTotal(triangle));
	}

}
