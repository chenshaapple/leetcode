package leetcode;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class CountandSay {

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		StringBuilder result = new StringBuilder("1");
		for(int i = 1; i < n; i++) {
			String last = result.toString();
			result.delete(0, result.length());
			char value = last.charAt(0);
			int count = 1;
			for(int j = 1; j < last.length(); j++) {
				char curt = last.charAt(j);
				if(curt != value) {
					result.append(count);
					result.append(value);
					value = curt;
					count = 1;
				} else {
					count++;
				}
			}
			result.append(count);
			result.append(value);
		}
		return result.toString();
	}
	
	public class Solution {
	    public String countAndSay(int n) {
	        if(n == 1) return "1";
	        StringBuilder res = new StringBuilder("1");
	        for(int i = 1; i < n; i++) {
	        		String last = res.toString();
	        		res.delete(0, res.length());
	        		int count = 1;
	        		char value = last.charAt(0);
	        		for(int j = 1; j < last.length(); j++) {
	        			char curr = last.charAt(j);
	        			if(curr == value)
	        				count++;
	        			else {
	        				res.append(count);
	        				res.append(value);
	        				value = curr;
	        				count = 1;
	        			}
	        		}
	        		res.append(count);
	        		res.append(value);
	        }
	        return res.toString();
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test1() {
		assertEquals("1", sln.countAndSay(1));
	}
	
	@Test
	public void test2() {
		assertEquals("11", sln.countAndSay(2));
	}

	@Test
	public void test3() {
		assertEquals("21", sln.countAndSay(3));
	}
}
