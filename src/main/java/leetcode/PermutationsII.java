package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		List<Integer> item = new ArrayList<>(num.length);
		permuteUnique(res, new LinkedList<>(), num, new boolean[num.length]);
		return res;
	}

	private void permuteUnique(List<List<Integer>> res, List<Integer> item,
			int[] num, boolean[] visited) {
		if (item.size() == num.length) {
			res.add(new ArrayList<>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if(i != 0 && !visited[i - 1] && num[i] == num[i - 1]) continue;
			if(!visited[i]) {
				visited[i] = true;
				item.add(num[i]);
				permuteUnique(res, item, num, visited);
				item.remove(item.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	public class Solution {
		private List<List<Integer>> res = new LinkedList<>();
		private List<Integer> item;
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        Arrays.sort(nums);
	        item  = new ArrayList<>(nums.length);
	        for(int num : nums)
	        		item.add(num);
	        permuteUnique(0);
	        return res;
	    }
	    
	    private void permuteUnique(int begin) {
	    		if(begin == item.size()) {
	    			res.add(new ArrayList<>(item));
	    			return;
	    		}
	    		for(int i = begin; i < item.size(); i++) {
	    			if(i == begin || !item.get(i).equals(item.get(i - 1))) {
	    				swap(begin, i);
	    				permuteUnique(begin + 1);
	    				swap(begin, i);
	    			}
	    		}
	    }
	    
	    private void swap(int i1, int i2) {
	    		Integer tmp = item.get(i1);
	    		item.set(i1, item.get(i2));
	    		item.set(i2, tmp);
	    }
	}
	
	private Solution sln = new Solution();

	@Test
	public void test() {
		System.out.println(sln.permuteUnique(new int[]{1,1,2}));
	}
	
	@Test
	public void test1() {
		List<List<Integer>> permutations = sln.permuteUnique(new int[]{0,1,0,0,9});
		System.out.println(permutations);
		System.out.println(permutations.size());
		assertEquals(20, permutations.size());
	}

}
