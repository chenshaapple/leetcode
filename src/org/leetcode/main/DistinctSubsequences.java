package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        return numDistinct(new StringBuilder(), S, T, 0);
    }
    
    private int numDistinct(StringBuilder builder, String S, String T, int offset) {
    		if(builder.length() == T.length()) {
    			return 1;
    		}
    		int res = 0;
    		for(int i = offset; i < S.length(); i++) {
    			char curt = S.charAt(i);
    			if(curt == T.charAt(builder.length())) {
    				builder.append(curt);
    				System.out.println(builder.toString());
    				res += numDistinct(builder, S, T, offset + 1);
    				builder.deleteCharAt(builder.length() - 1);
    				System.out.println(builder.toString());
    			}
    		}
    		return res;
    }
    
    public int numDistinctDP(String S, String T) {
    		int[] opt = new int[T.length() + 1];
    		opt[0] = 1;
    		for(int i = 0; i < S.length(); i++) {
    			for(int j = T.length(); j > 0; j--) {
    				opt[j] += (S.charAt(i) == T.charAt(j - 1) ? opt[j - 1]: 0);
    			}
    		}
    		return opt[T.length()];
    }
	@Test
	public void test() {
		assertEquals(3, numDistinctDP("rabbbit", "rabbit"));
	}

}
