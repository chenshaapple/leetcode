package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class MinimumWindowSubstring {
    public String minWindowRecurse(String S, String T) {
        return getWindow(S, T.toCharArray());
    }
    
    private String getWindow(String S, char[] T) {
    	if(S.length() < T.length) {
    		return "";
    	}
    	boolean flag = true;
    	for(char t : T) {
    		if(!S.contains(String.valueOf(t))) {
    			flag = false;
    			break;
    		}
    	}
    	if(flag) {
    		String right = getWindow(S.substring(1), T);
    		String left = getWindow(S.substring(0, S.length() - 1), T);
    		if(left.equals("") && right.equals("")) {
    			return S;
    		}
    		if(left.equals("")) {
    			return right;
    		} else if(right.equals("")) {
    			return left;
    		}
    		return left.length() < right.length() ? left : right;
    	}
    	return "";
    }
    
    public String minWindow(String S, String T) {
    	int left = 0, right = 0;
    	List<String> windows = new LinkedList<>();
    	char[] chars = T.toCharArray();
    	String result = "";
    	int min = Integer.MAX_VALUE;
    
    	int rightBorder = S.length() - T.length();
    	for( ; left < rightBorder; left++) {
    		if(!T.contains(String.valueOf(S.charAt(left)))) {
    			continue;
    		}
    		String match = "";
    		for(right = left + T.length() - 1; right < S.length(); right++) {
    			if(!T.contains(String.valueOf(S.charAt(right)))) {
    				continue;
    			}
    			match = S.substring(left, right + 1);
    			if(checkWindow(match, chars)) {
    				windows.add(match);
    				break;
    			}
    		}
    	}

    	for(String window : windows) {
    		System.out.println(window);
    		if(window.length() < min) {
    			min = window.length();
    			result = window;
    		}
    	}
    	return result;
    }
    
    private boolean checkWindow(String tbd, char[] T) {
    	for(char character : T) {
    		if(!tbd.contains(String.valueOf(character))) {
    			return false;
    		}
    	}
    	return true;
    }
	@Test
	public void test() {
		assertEquals("sk_not_what_your_c", minWindow("ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country"));
	}

}
