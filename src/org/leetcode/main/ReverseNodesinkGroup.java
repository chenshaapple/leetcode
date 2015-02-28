package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
/*
 * Swap Nodes in Pairs的follow up,这是一个通用的解法，肯定可以过那道题
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(k == 1) {
    		return head;
    	}
        ListNode result = head;
        for(int i = 1; i < k && result != null; i++) {
        	result = result.next;
        }
        result = result != null ? result : head;
        ListNode first = head, last = first;
        ListNode lastFirst = null;
        while(first != null) {
        	for(int i = 1; i < k && last != null; i++) {
        		last = last.next;
        	}
        	ListNode tmp = last != null ? last.next : null;
        	if(last != null) {
        		reverse(first, last);
        	}
    		if(lastFirst != null) {
    			lastFirst.next = last != null ? last : first;
    		}
        	lastFirst = first;
        	first = last = tmp;
        }
        return result;
    }
    private void reverse(ListNode begin, ListNode end) {
    	ListNode prev = null, curt = begin;
    	while(curt != end) {
    		ListNode tmp = curt.next;
    		curt.next = prev;
    		prev = curt;
    		curt = tmp;
    	}
    	end.next = prev;
    }
    
	private void print(ListNode head) {
		ListNode result = head;
		while(result != null) {
			System.out.print("" + result.val + "->");
			result = result.next;
		}
		System.out.println();
	}
	@Test
	public void test3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode end = new ListNode(5);
		head.next.next.next.next = end;
		print(reverseKGroup(head, 3));
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode end = new ListNode(5);
		head.next.next.next.next = end;
		print(reverseKGroup(head, 2));
	}

}
