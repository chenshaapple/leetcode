package leetcode;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HappyNumber {
	public class Solution {
	    public boolean isHappy(int n) {
	    		if(n == 1) return true;
	        Set<Integer> set = new HashSet<>();
	        while(n != 1) {
	        		if(set.contains(n)) return false;
	        		set.add(n);
	        		int digit = 0, sum = 0;
	        		while(n != 0) {
	        			digit = n % 10;
	        			n /= 10;
	        			sum += (digit * digit);
	        		}
	        		n = sum;
	        }
	    		return true;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		assertEquals(true, sln.isHappy(19));
	}
	
	@Test
	public void test1() {
		assertEquals(true, sln.isHappy(-19));
	}

}
