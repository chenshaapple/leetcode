package org.leetcode.main;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
	    if(head == null) {
	        return null;
	    }
	    
	    ListNode tail = head;
	    while(tail.next != null) {
	        tail = tail.next;
	    }
	    tail.next = head;
	    
	    ListNode fastNode = head, slowNode = head;
	    for(int i = 0; i < n ; i++) {
	        fastNode = fastNode.next;    
	    }
	    
	    while(fastNode != tail) {
	        slowNode = slowNode.next;
	        fastNode = fastNode.next;
	    }
	    
        ListNode result = slowNode.next;
         slowNode.next = null;
        return result;
	}
	
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		assertEquals(head, rotateRight(head, 0));
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node2;
		assertEquals(node2, rotateRight(head, 1));
	}
	
	@Test
	public void test3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		assertEquals(head, rotateRight(head, 0));
	}
	
	@Test
	public void test4() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		assertEquals(head, rotateRight(head, 2));
	}
}
