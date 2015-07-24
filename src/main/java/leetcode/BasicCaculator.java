package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCaculator {
	public class Solution {
		public int calculate(String s) {
			Deque<Character> operators = new LinkedList<>();
			Deque<Integer> operands = new LinkedList<>();
			int res = 0;
			char[] chars = s.toCharArray();
			for(int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if(Character.isDigit(c)) {
					StringBuilder sb = new StringBuilder(c);
					for(int j = i + 1; j < chars.length && Character.isDigit(chars[j]); j++)
						sb.append(chars[j]);
					operands.push(Integer.valueOf(sb.toString()));
				} else {
					if(c == ')') {
						
					} else {
						
					}
				}
			}
			return res;
		}
	}
}
