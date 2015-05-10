package org.leetcode.main;

public class BitwiseANDofNumbersRange {
	public class Solution {
	    public int rangeBitwiseAnd(int m, int n) {
	        int res = n;
	        for(int i = m; i < n; i++) {
	        		res = res & i;
	        }
	        return res;
	    }
	}
}
