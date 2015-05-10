package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for(String token : tokens) {
        		if(token.equals("+")) {
        			deque.push(deque.pop() + deque.pop());
        		} else if(token.equals("-")) {
        			int tmp = deque.pop();
        			deque.push(deque.pop() - tmp);
        		} else if(token.equals("*")) {
        			deque.push(deque.pop() * deque.pop());
        		} else if(token.endsWith("/")) {
        			int tmp = deque.pop();
        			deque.push(deque.pop() / tmp);
        		} else {
        			deque.push(Integer.valueOf(token));
        		}
        }
        return deque.pop();
    }
	@Test
	public void test() {
		assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
	}

}
