package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode result = head.next == null ? head : head.next;
		ListNode prev = null, first = head, second = first.next;
		while (second != null) {
			ListNode tmp = second.next;
			second.next = first;
			prev = first;
			first = tmp;
			second = first != null ? first.next : null;
			prev.next = second;
		}
		if (prev != null) {
			prev.next = first;
		}
		return result;
	}

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(swapPairs(head));
	}

	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		System.out.println(swapPairs(head));
	}

	@Test
	public void test2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(swapPairs(head));
	}

	@Test
	public void test3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(swapPairs(head));
	}
}
