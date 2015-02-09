package org.leetcode.main;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new LinkedList<>();
		findIp("", 0, s, result);
		return result;
	}

	private void findIp(String currentPart, int length, String subSequence,
			List<String> result) {
		if (length == 4) {
			if(subSequence.equals("")) {
				result.add(currentPart);
			}
			return;
		}
		if (subSequence.length() > (4 - length) * 3
				|| subSequence.length() < (4 - length)) {
			return;
		} else {
			for (int i = 1; i <= subSequence.length() && i <= 3; i++) {
				String nextPart = subSequence.substring(0, i);
				if(!isValid(nextPart)) {
					return;
				}
				nextPart = length == 0 ? nextPart : currentPart + "." + nextPart;
				String nextSubsequence = subSequence.substring(i);
				findIp(nextPart, length + 1, nextSubsequence, result);
			}
		}
	}

	private boolean isValid(String part) {
		Integer number = null;
		if(part.charAt(0) == '0' && part.length() > 1) {
			return false;
		}
		number = Integer.valueOf(part);
		if (number >= 0 && number <= 255) {
			return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		List<String> result = restoreIpAddresses("25525511135");
		for(String ip : result) {
			System.out.println(ip);
		}
	}
	
	@Test
	public void test2() {
		List<String> result = restoreIpAddresses("010010");
		for(String ip : result) {
			System.out.println(ip);
		}
	}
	
	@Test
	public void test3() {
		List<String> result = restoreIpAddresses("0000");
		for(String ip : result) {
			System.out.println(ip);
		}
	}
	
	@Test
	public void testSplit() {
		String part1 = "255";
		System.out.println(part1.split("\\.").length);
		String part2 = "255";
		System.out.println((part1 + "." + part2).split("\\.").length);
		System.out.println("".split("\\.").length);
	}
}
