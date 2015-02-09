package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SubstringwithConcatenationofAllWords {
	
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> result = new LinkedList<>();
    	int wordLength = L[0].length();
    	int gap = wordLength * L.length;
    	Map<String, Integer> map = new HashMap<>();
    	for(int i = 0; i < L.length; i++) {
    		if(!map.containsKey(L[i])) {
    			map.put(L[i], 1);
    		} else {
    			map.put(L[i], map.get(L[i]) + 1);
    		}
    	}
    	Map<String, Integer> visitMap = new HashMap(map);
    	int index = 0;
    	while(index <= (S.length() - gap)) {
    		for(int i = 0; i < L.length; i++) {
    			String word = S.substring(index + i * wordLength, index + (i + 1) * wordLength);
    			if(visitMap.containsKey(word)) {
    				if(visitMap.get(word) > 1) {
    					visitMap.put(word, visitMap.get(word) - 1);
    				} else {
    					visitMap.remove(word);
    				}
    			} else {
    				break;
    			}
    		}
    		if(visitMap.isEmpty()) {
    			result.add(index);
    		} 
    		visitMap = new HashMap(map);
    		index++;
    	}
    	return result;
    }

	@Test
	public void test() {
		assertEquals(Arrays.asList(0,9), findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}
	
	@Test
	public void test1() {
		assertEquals(Arrays.asList(0), findSubstring("a", new String[]{"a"}));
	}
	
	@Test
	public void test2() {
		assertEquals(Arrays.asList(0, 2, 4), findSubstring("abababab", new String[]{"a", "b", "a"}));
	}

}
