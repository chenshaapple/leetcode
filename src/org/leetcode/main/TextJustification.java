package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> res = new LinkedList<String>();
		int i = 0;
		while (true) {
			StringBuilder line = new StringBuilder();
			int start = i, size = 0;
			while(i < words.length && line.length() < L) {
				size += words[i].length();
				i++;
			}
			int firstGap = 0, 
			res.add(line.toString());
			if(i == words.length) {
				break;
			}
		}
		return res;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
