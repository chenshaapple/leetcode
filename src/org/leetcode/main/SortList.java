package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 排序很好实现，但目前并没有想到常量空间复杂度的算法，凡是用了递归的肯定不是常量
 * 用归并排序的话，找中点我们用快指针就行了，当快指针到达表尾的时候慢指针就在中点
 */

public class SortList {
    public ListNode sortList(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode tail = head;
    	while(tail.next != null) {
    		tail = tail.next;
    	}
    	return sort(head, tail);
    }
    
    private ListNode sort(ListNode head, ListNode tail) {
    	if(head == tail) {
    		tail.next = null;
    		return head;
    	}
    	ListNode slow = head, fast = head;
    	while(fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	if(fast.next != null) {
    		fast = fast.next;
    	}
    	ListNode rightHead = slow.next;
    	slow.next = null;
    	ListNode leftList = sort(head, slow);
    	ListNode rightList = sort(rightHead, fast);
    	return merge(leftList, rightList);
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
    	ListNode result = new ListNode(0), curt = result;
    	ListNode i = list1, j = list2;
    	while(i != null && j != null) {
    		if(i.val < j.val) {
    			curt.next = i;
    			i = i.next;
    		} else {
    			curt.next = j;
    			j = j.next;
    		}
    		curt = curt.next;
    	}
    	if(i != null) {
    		curt.next = i;
    	}
    	if(j != null) {
    		curt.next = j;
    	}
    	return result.next;
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
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		print(sortList(head));
	}

	@Test
	public void test1() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		print(sortList(head));
	}
	
}
