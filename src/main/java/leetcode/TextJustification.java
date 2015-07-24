package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TextJustification {

	public class Solution {
	    public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> res = new LinkedList<>();
	        int i = 0;
	        while(i < words.length) {
	        		StringBuilder builder = new StringBuilder();
	        		StringBuilder gapBuilder = new StringBuilder();
	        		List<String> line = new LinkedList<>();
	        		int minGap = 1, length = 0, restGap = maxWidth;
	        		while(i < words.length && length + words[i].length() + minGap * line.size() <= maxWidth) {
	        			length += words[i].length();
	        			line.add(words[i++]);
	        		}
	        		minGap = line.size() > 1 ? (maxWidth - length) / (line.size() - 1) : maxWidth - length;
	        		if(i == words.length)
	        			minGap = 1;
	        		for(int j = 0; j < minGap; j++)
	        			gapBuilder.append(" ");
	        		restGap = (maxWidth - length) - minGap * (line.size() - 1);
	        		for(int j = 0; j < line.size(); j++) {
	        			builder.append(line.get(j));
	        			if(j < line.size() - 1)
	        				builder.append(gapBuilder.toString());
	        			if(i != words.length && restGap > 0) {
	        				builder.append(" ");
	        				restGap--;
	        			}
	        		}
	        		for(;restGap > 0; restGap--) 
	        			builder.append(" ");
	        		res.add(builder.toString());
	        }
	        return res;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(sln.fullJustify(words, 16));
	}

	@Test
	public void test1() {
		String[] words = new String[]{""};
		System.out.println(sln.fullJustify(words, 2));
	}
	
	@Test
	public void test2() {
		String[] words = new String[]{"What","must","be","shall","be."};
		System.out.println(sln.fullJustify(words, 12));
	}
	
	@Test
	public void test3() {
		String[] words = new String[]{"a"};
		System.out.println(sln.fullJustify(words, 2));
	}
	
	@Test
	public void test4() {
		String[] words = new String[]{"a","b","c","d","e"};
		String[] just = new String[]{"a b","c d","e  "};
		assertEquals(Arrays.toString(just), sln.fullJustify(words, 3).toString());
	}
}
