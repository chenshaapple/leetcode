package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * ����ܺ�ʵ�֣���Ŀǰ��û���뵽�����ռ临�Ӷȵ��㷨���������˵ݹ�Ŀ϶����ǳ���
 * �ù鲢����Ļ������е������ÿ�ָ������ˣ�����ָ�뵽���β��ʱ����ָ������е�
 */

public class SortList {

	/**
	 * without tail
	 */
	public ListNode normalQuickSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode l = new ListNode(-1), e = new ListNode(0), g = new ListNode(1);
		ListNode lCurt = l, eCurt = e, gCurt = g, curt = head;
		while (curt != null) {
			if (curt.val == head.val) {
				eCurt = eCurt.next = curt;
			} else if (curt.val < head.val) {
				lCurt = lCurt.next = curt;
			} else {
				gCurt = gCurt.next = curt;
			}
			curt = curt.next;
		}
		lCurt.next = null;
		gCurt.next = null;
		ListNode res = null;
		ListNode left = normalQuickSort(l.next);
		eCurt.next = normalQuickSort(g.next);
		if (left != null) {
			ListNode leftCurt = left;
			while (leftCurt.next != null) {
				leftCurt = leftCurt.next;
			}
			leftCurt.next = e.next;
			res = left;
		} else {
			res = e.next;
		}
		return res;
	}

	/**
	 * with tail
	 */
	public ListNode quickSort(ListNode head) {
		return quickSort(head, null);
	}

	private ListNode quickSort(ListNode head, ListNode tail) {
		if (head == null || head.next == tail) {
			return head;
		}
		ListNode little = new ListNode(0), equal = new ListNode(0), great = new ListNode(
				0);
		ListNode lCurt = little, eCurt = equal, gCurt = great;
		ListNode curt = head;
		while (curt != tail) {
			if (curt.val == head.val) {
				eCurt = eCurt.next = curt;
			} else if (curt.val < head.val) {
				lCurt = lCurt.next = curt;
			} else {
				gCurt = gCurt.next = curt;
			}
			curt = curt.next;
		}
		eCurt.next = tail;
		ListNode res = equal.next;
		// 先把三个list的尾部确定
		if (little.next != null) {
			lCurt.next = equal.next;
			res = quickSort(little.next, equal.next);
		}
		if (great.next != null) {
			gCurt.next = tail;
			eCurt.next = quickSort(great.next, tail);
		}
		return res;
	}

	public ListNode sortListBottomUp(ListNode head) {
		if (head == null) {
			return null;
		}
		int size = 0;
		ListNode tail = head;
		while (tail != null) {
			size++;
			tail = tail.next;
		}
		ListNode res = new ListNode(0), left, right, curt;
		res.next = head;
		for (int i = 1; i < size; i = i << 1) {
			curt = res.next;
			tail = res;
			while (curt != null) {
				left = curt;
				right = getNextNth(curt, i);
				curt = getNextNth(right, i);
				tail = merge(left, right, tail);
			}
		}
		return res.next;
	}

	private ListNode getNextNth(ListNode head, int n) {
		ListNode res = null;
		for (int i = 1; head != null && i < n; i++) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		res = head.next;
		head.next = null;
		return res;
	}

	private ListNode merge(ListNode list1, ListNode list2, ListNode tail) {
		ListNode l1 = list1, l2 = list2, curt = tail;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curt.next = l1;
				l1 = l1.next;
			} else {
				curt.next = l2;
				l2 = l2.next;
			}
			curt = curt.next;
		}
		curt.next = l1 != null ? l1 : l2;
		return curt;
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return sort(head);
	}

	private ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode rightHead = slow.next;
		slow.next = null;
		ListNode leftList = sort(head);
		ListNode rightList = sort(rightHead);
		return merge(leftList, rightList);
	}

	private ListNode merge(ListNode list1, ListNode list2) {
		ListNode result = new ListNode(0), curt = result;
		ListNode i = list1, j = list2;
		while (i != null && j != null) {
			if (i.val < j.val) {
				curt.next = i;
				i = i.next;
			} else {
				curt.next = j;
				j = j.next;
			}
			curt = curt.next;
		}
		curt.next = i != null ? i : j;
		return result.next;
	}

	private void print(ListNode head) {
		ListNode result = head;
		while (result != null) {
			System.out.print("" + result.val + "->");
			result = result.next;
		}
		System.out.println();
	}

	@Test
	public void test() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode res = sortListBottomUp(head);
		print(res);
	}

	@Test
	public void test1() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		print(sortListBottomUp(head));
	}

	@Test
	public void testHashCode() {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(0);
		System.out.println(node1);
		System.out.println(node2);
	}

	@Test
	public void testQuickSrot() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		print(quickSort(head));
	}

	@Test
	public void testQS1() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		print(quickSort(head));
	}

	@Test
	public void testQS2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		print(quickSort(head));
	}

	private ListNode generateList(int[] nums) {
		ListNode res = new ListNode(0), curt = res;
		for (int num : nums) {
			curt.next = new ListNode(num);
			curt = curt.next;
		}
		return res.next;
	}

	@Test
	public void testQS3() {
		// 4,19,14,5,-3,1,8,5,11,15
		ListNode head = generateList(new int[] { 4, 19, 14, 5, -3, 1, 8, 5, 11,
				15 });
		print(quickSort(head));
	}
}
