package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class MergekSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
        return mergeKLists(lists, 0, lists.size() - 1);
    }
    
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode vhead = new ListNode(0), curr = vhead, lCurr = l1, rCurr = l2;
		while(lCurr != null && rCurr != null) {
			if(lCurr.val < rCurr.val) {
				curr.next = lCurr;
				lCurr = lCurr.next;
			} else {
				curr.next = rCurr;
				rCurr = rCurr.next;
			}
			curr = curr.next;
		}
		curr.next = lCurr != null ? lCurr : rCurr;
		return vhead.next;
	}
    
	//求mid的时候
	//begin <= mid
	//mid < end;
	//所以只有以下是安全的方法
    private ListNode mergeKLists(List<ListNode> lists, int begin, int end) {
    		if(begin == end) return lists.get(begin);
    		int mid = (begin + end) / 2;
    		ListNode left = mergeKLists(lists, begin, mid);
    		ListNode right = mergeKLists(lists, mid + 1, end);
    		return merge(left, right);
    }
	@Test
	public void test() {
		List<ListNode> lists = new ArrayList<>();
		lists.add(null);
		lists.add(null);
		System.out.println(mergeKLists(lists));
	}

}
