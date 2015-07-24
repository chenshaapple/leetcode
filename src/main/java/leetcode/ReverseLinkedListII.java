package leetcode;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode curr = this;
		while(curr.next != null) {
			res.append(curr.val + "->");
			curr = curr.next;
		}
		res.append(curr.val);
		return res.toString();
	}
}

public class ReverseLinkedListII {
	public class Solution {
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	    		if(m == n) return head;
	    		ListNode vhead = new ListNode(0), prevRev = vhead, prev = null, curr = null;
	    		vhead.next = head;
	    		for(int i = 0; i < m - 1; i++) {
	    			prevRev = prevRev.next;
	    		}
	    		prev = prevRev;
	    		curr = prev.next;
	    		for(int i = m; i <= n; i++) {
	    			ListNode tmp = curr.next;
	    			curr.next = prev;
	    			prev = curr;
	    			curr = tmp;
	    		}
	    		prevRev.next.next = curr;
	    		prevRev.next = prev;
	    		return vhead.next;
	    }
	}

	private Solution sln = new Solution();

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		System.out.println(sln.reverseBetween(head, 1, 2));
	}

}
