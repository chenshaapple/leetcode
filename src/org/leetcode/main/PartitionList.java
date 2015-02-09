package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessList = new ListNode(0), greaterList = new ListNode(0), current = head;
        ListNode lessTail = lessList, greaterTail = greaterList;
        while(current != null) {
        	if(current.val < x) {
        		lessTail.next = current;
        		lessTail = current;
        	} else {
        		greaterTail.next = current;
        		greaterTail = current;
        	}
        	current = current.next;
        }
        lessTail.next = greaterList.next;
        greaterTail.next = null;
        return lessList.next;
    }
	@Test
	public void test() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		partition(head, 2);
	}

}
