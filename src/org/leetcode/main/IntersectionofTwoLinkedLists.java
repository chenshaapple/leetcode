package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode tailA = headA, tailB = headB;
		int countA = 0, countB = 0;
		while (tailA.next != null) {
			tailA = tailA.next;
			countA++;
		}
		while (tailB.next != null) {
			tailB = tailB.next;
			countB++;
		}
		if (tailA != tailB) {
			return null;
		}
		ListNode slow, fast;
		if (countA > countB) {
			slow = headB;
			fast = headA;
		} else {
			slow = headA;
			fast = headB;
		}
		for (int i = 0; i < Math.abs(countA - countB); i++) {
			fast = fast.next;
		}
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    		if(headA == null || headB == null) return null;
	        int sizeA = 0, sizeB = 0;
	        ListNode tailA = headA, tailB = headB;
	        for(; tailA.next != null; tailA = tailA.next, sizeA++);
	        for(; tailB.next != null; tailB = tailB.next, sizeB++);
	        if(tailA != tailB) return null;
	        ListNode slow = null, fast = null;
	        if(sizeA < sizeB) {
	        		slow = headA;
	        		fast = headB;
	        } else {
	        		slow = headB;
	        		fast = headA;
	        }
	        for(int i = 0; i < Math.abs(sizeA - sizeB); i++) {
	        		fast = fast.next;
	        }
	        while(slow != fast) {
	        		slow = slow.next;
	        		fast = fast.next;
	        }
	        return slow;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
