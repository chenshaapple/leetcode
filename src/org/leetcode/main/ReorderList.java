package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReorderList {
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null) {
    		return;
    	}
        ListNode prev = null, slow = head, fast = head;
        while(fast.next != null) {
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next.next != null ? fast.next.next : fast.next;
        }
        if(prev != null) {
        	prev.next = null;
        }
        //reverse from slow to fast
        reverse(slow, fast);
        //merge head and slow(the head now is fast)
        ListNode left = head, right = fast, curt = head;
        while(left != null && right != null && left != right) {
        	ListNode tmpLeft = left.next;
        	ListNode tmpRight = right.next;
        	left.next = right;
        	right.next = tmpLeft;
        	curt = right;
        	left = tmpLeft;
        	right  = tmpRight;
        }
        curt.next = right;
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
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode end = new ListNode(5);
		head.next.next.next.next = end;
		reorderList(head);
		print(head);
	}
	
	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		reorderList(head);
		print(head);
	}

}
