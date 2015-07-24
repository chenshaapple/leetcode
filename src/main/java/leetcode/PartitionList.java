package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitionList {
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lessList = new ListNode(0), greaterList = new ListNode(0), curr = head;
            ListNode lessTail = lessList, greaterTail = greaterList;
            while(curr != null) {
            	if(curr.val < x) {
            		lessTail.next = curr;
            		lessTail = curr;
            	} else {
            		greaterTail.next = curr;
            		greaterTail = curr;
            	}
            	curr = curr.next;
            }
            lessTail.next = greaterList.next;
            greaterTail.next = null;
            return lessList.next;
        }
    }
}
