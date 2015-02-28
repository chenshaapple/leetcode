package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class MergekSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists == null || lists.size() == 0) {
    		return null;
    	}
        return divide(lists, 0, lists.size() - 1);
    }
    
    private ListNode divide(List<ListNode> lists, int left, int right) {
    	if(left == right) {
    		return lists.get(left);
    	}
    	int mid = (left + right) / 2;
    	ListNode leftList = divide(lists, left, mid);
    	ListNode rightList = divide(lists, mid + 1, right);
    	return merge(leftList, rightList);
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
    	ListNode result = new ListNode(0), tail = result;
    	ListNode i = list1, j = list2;
    	while(i != null && j != null) {
    		if(i.val < j.val) {
    			tail.next = i;
    			i = i.next;
    		} else {
    			tail.next = j;
    			j = j.next;
    		}
    		tail = tail.next;
    	}
    	if(i != null) {
    		tail.next = i;
    	}
    	if(j != null) {
    		tail.next = j;
    	}
    	return result.next;
    }
	@Test
	public void test() {
		ListNode result = mergeKLists(Arrays.asList(new ListNode(0), new ListNode(1)));
		System.out.println(result.val);
	}

}
