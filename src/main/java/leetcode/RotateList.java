package leetcode;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateList {
	public class Solution {
	    public ListNode rotateRight(ListNode head, int k) {
	    		if(head == null) return null;
	        ListNode slow = head, fast = head, tail = head, res = null;
	        int len = 1;
	        while(tail.next != null) {
	        		tail = tail.next;
	        		len++;
	        }
	        k = k % len;
	        tail.next = head;
	        for(int i = 0; i < k; i++) {
	        		fast = fast.next;
	        }
	        while(fast != tail) {
	        		slow = slow.next;
	        		fast = fast.next;
	        }
	        res = slow.next;
	        slow.next = null;
	        return res;
	    }
	}	
}
