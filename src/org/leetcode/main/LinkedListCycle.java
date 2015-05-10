package org.leetcode.main;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LinkedListCycle {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        ListNode slow = head, fast = head;
	        while(fast != null && fast.next != null) {
	        		slow = slow.next;
	        		fast = fast.next.next;
	        		if(slow == fast) return true;
	        }
	        return false;
	    }
	    
	    public boolean hasCycle2(ListNode head) {
	    		Map<ListNode, Boolean> map = new HashMap<>();
	    		ListNode curr = head;
	    		while(curr != null) {
	    			if(map.containsKey(curr)) return true;
	    			map.put(curr, Boolean.TRUE);
	    			curr = curr.next;
	    		}
	    		return false;
	    }
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
