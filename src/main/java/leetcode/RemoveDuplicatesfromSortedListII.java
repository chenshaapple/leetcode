package leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveDuplicatesfromSortedListII {
	public class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        ListNode vhead = new ListNode(0), curr = head, vcurr = vhead, prev = null;
	        while(curr != null) {
	        		if((prev == null || curr.val != prev.val)
	        				&&(curr.next == null || curr.val != curr.next.val)) {
	        			vcurr.next = curr;
	        			vcurr = curr;
	        		}
	        		prev = curr;
	        		curr = curr.next;
	        }
	        vcurr.next = null;
	        return vhead.next;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void testStartWithDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		System.out.println(sln.deleteDuplicates(head));
	}

	@Test
	public void testContainOnlyDuplicates() {
		ListNode head = new ListNode(1);
		System.out.println(sln.deleteDuplicates(head));
	}

	@Test
	public void testContainOnlyOneElement() {
		ListNode head = new ListNode(1);
		System.out.println(sln.deleteDuplicates(head));
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		System.out.println(sln.deleteDuplicates(head));
	}
	
	@Test
	public void testTwoCoupleDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		System.out.println(sln.deleteDuplicates(head));
	}
}
