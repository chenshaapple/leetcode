package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IsomorphicStrings {
	public class Solution {
		public boolean isIsomorphic(String s, String t) {
			if (s.length() != t.length())
				return false;
			Map<Character, Integer> map = new HashMap<>();
			int[] serial1 = new int[s.length()], serial2 = new int[t.length()];
			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if(map.containsKey(curr))
					serial1[i] = map.get(curr);
				else{
					map.put(curr, map.size());
					serial1[i] = map.size();
				}
			}
			map.clear();
			for(int i = 0; i < t.length(); i++) {
				char curr = t.charAt(i);
				if(map.containsKey(curr))
					serial2[i] = map.get(curr);
				else {
					map.put(curr, map.size());
					serial2[i] = map.size();
				}
			}
			for(int i = 0; i < s.length(); i++){
				if(serial1[i] != serial2[i])
					return false;
			}
			return true;
		}
		
		public boolean isIsomorphic2(String s, String t) {
			
			return true;
		}
	}
	
	private Solution sln = new Solution();
	
	@Test
	public void test() {
		String s = "ab", t = "aa";
		assertEquals(false, sln.isIsomorphic(s, t));
	}
}
