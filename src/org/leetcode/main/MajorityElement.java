package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class MajorityElement {
    public int majorityElement(int[] num) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(num[0]);
        for(int i = 1; i < num.length; i++) {
        	if(num[i] != stack.peek()) {
        		stack.pop();
        	} else {
        		stack.push(num[i]);
        	}
        }
        return stack.peek();
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
