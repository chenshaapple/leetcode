package leetcode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Traverse the <b>s</b>, and for every character, calculate the index to the left bound's length.<br/>
	 * So we need a map to record the left bound.
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int left = 0, right = 0; right < s.length(); right++) {
        		Character curt = s.charAt(right);
        		if(map.containsKey(curt)) {
        			left = Math.max(left, map.get(curt) + 1);
        		} 
    			map.put(curt, right);
        		res = Math.max(res, right - left + 1);
        }
        return res;
    }
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
        		int res = 0;
        		Map<Character, Integer> map = new HashMap<>();
        		for(int left = 0, right = 0; right < s.length(); right++) {
        			Character curr =  s.charAt(right);
        			if(map.containsKey(curr)) {
        				left = Math.max(left, map.get(curr) + 1);
        			}
        			map.put(curr, right);
        			res = Math.max(res, right - left + 1);
        		}
        		return res;
        }
    }
	@Test
	public void test() {
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
	}

	@Test
	public void test2() {
		assertEquals(3, lengthOfLongestSubstring("dvdf"));
	}
	
	@Test
	public void test3() {
		assertEquals(4, lengthOfLongestSubstring("abcd"));
	}
}
