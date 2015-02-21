package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> result = new LinkedList<>();
    	partition(result, new LinkedList<>(), s, 0);
    	return result;
    }
    
    //借鉴大神的那种回溯，用参数传递tracking
    private void partition(List<List<String>> result, List<String> option, String s, int begin) {
    	if(begin >= s.length()) {
    		result.add(new ArrayList<>(option));
    		return;
    	}
    	for(int i = begin + 1; i <= s.length(); i++) {
    		String word = s.substring(begin, i);
    		if(isPalindrome(word)) {
    			option.add(word);
    			partition(result, option, s, i);
    			option.remove(option.size() - 1);//一定不要用remove(word)
    		}
    	}
    }
    
    private boolean isPalindrome(String word) {
    	int mid = word.length() / 2;
    	for(int i = 0; i < mid; i++) {
    		if(word.charAt(i) != word.charAt(word.length() - 1 - i)) {
    			return false;
    		}
    	}
    	return true;
    }
	@Test
	public void test() {
		List<List<String>> result = partition("aab");
		assertEquals(2, result.size());
	}

}
