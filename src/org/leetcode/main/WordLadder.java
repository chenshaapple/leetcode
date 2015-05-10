package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end)) {
			return 1;
		}
		int res = 1;
		dict.add(end);
		Deque<String> deque = new LinkedList<>();
		deque.addLast(start);
		while (!deque.isEmpty()) {
			res++;
			int size = deque.size();
			for (int cursor = 0; cursor < size; cursor++) {
				String curtWord = deque.pollFirst();
				for (int i = 0; i < curtWord.length(); i++) {
					char[] curt = curtWord.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						curt[i] = c;
						String tmp = String.valueOf(curt);
						if (tmp.equals(end)) {
							return res;
						}
						if (dict.contains(tmp)) {
							dict.remove(tmp);
							deque.addLast(tmp);
						}
					}
				}
			}
		}
		return 0;
	}

	// 超时，这种频繁创建新对象的必须
	public int ladderLengthDirect(String start, String end, Set<String> dict) {
		Deque<String> deque = new LinkedList<>();
		Deque<List<String>> restDictDeque = new LinkedList<>();
		deque.addLast(start);
		restDictDeque.add(new ArrayList<String>(dict));
		int res = 1;
		while (!deque.isEmpty()) {
			res++;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				String prev = deque.pollFirst();
				if (variousLetter(prev, end) == 1) {
					return res;
				}
				List<String> restDict = restDictDeque.pollFirst();
				for (int j = 0; j < restDict.size(); j++) {
					String curt = restDict.get(j);
					if (variousLetter(prev, curt) == 1) {
						deque.addLast(curt);
						restDict.remove(curt);
						restDictDeque.addLast(new ArrayList<String>(restDict));
						restDict.add(j, curt);
					}
				}
			}
		}
		return 0;
	}

	private int variousLetter(String str1, String str2) {
		int res = 0;
		int i = 0;
		while (i < str1.length() && i < str2.length()) {
			if (str1.charAt(i) != str2.charAt(i)) {
				res++;
			}
			i++;
		}
		res += (Math.max(0, str1.length() - i) + Math.max(0, str2.length() - i));
		return res;
	}

	private int editDistance(String str1, String str2) {
		char[] array1 = str1.toCharArray(), array2 = str2.toCharArray();
		int[][] opt = new int[array1.length + 1][array2.length + 1];

		return opt[array1.length][array2.length];
	}

	// @Test
	public void test() {
		System.out.println(variousLetter("lot", "hot"));
		System.out.println(variousLetter("lot", "hot1"));
	}

	@Test
	public void test1() {
		String start = "hit", end = "cog";
		Set<String> dict = new HashSet<>(Arrays.asList("hot", "dot", "dog",
				"lot", "log"));
		assertEquals(5, ladderLength(start, end, dict));
	}

	@Test
	public void test2() {
		String start = "hot", end = "dog";
		Set<String> dict = new HashSet<>(Arrays.asList("hot", "dog"));
		assertEquals(0, ladderLength(start, end, dict));
	}

	@Test
	public void test3() {
		String start = "a", end = "c";
		Set<String> dict = new HashSet<>(Arrays.asList("a", "b", "c"));
		assertEquals(2, ladderLength(start, end, dict));
	}

}
