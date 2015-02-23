package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class LetterCombinationsofaPhoneNumber {
	private Map<Integer, List<Character>> dictionary = new HashMap<>();
	{
		char initChar = 'a';
		for(int i = 0; i < 10; i++) {
			List<Character> list = new ArrayList<>();
			dictionary.put(i, list);
			if(i == 0 || i == 1) {
				continue;
			}
			for(int j = 0; j < 3; j++) {
				list.add(initChar++);
			}
			if(i == 7 || i == 9) {
				list.add(initChar++);
			}
		}
	}
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(result, new StringBuilder(), digits);
        return result;
    }
    
    private void letterCombinations(List<String> result, StringBuilder letters, String digits) {
    	if(digits.length() == 0) {
    		result.add(letters.toString());
    		return;
    	}
    	List<Character> letterList = dictionary.get(digits.charAt(0) - '0');
    	String nextDigits = digits.substring(1);
    	for(Character c : letterList) {
    		letters.append(c);
    		letterCombinations(result, letters, nextDigits);
    		letters.deleteCharAt(letters.length() - 1);
    	}
    }
	@Test
	public void test() {
//		for(List<Character> list : dictionary.values()) {
//			System.out.println(list);
//		}
		List<String> result = letterCombinations("23");
		for(String str : result) {
			System.out.println(str);
		}
	}

}
