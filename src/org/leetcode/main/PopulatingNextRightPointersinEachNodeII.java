package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeII {
	//层次遍历，空间复杂度为O(n)，跟之前一个代码一样
    public void connect(TreeLinkNode root) {
		Deque<TreeLinkNode> deque = new LinkedList<>();
		if (root == null) {
			return;
		}
		deque.addLast(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = deque.pollFirst();
				node.next = i < size - 1 ? deque.peekFirst() : null;
				if(node.left != null ) {
					deque.addLast(node.left);
				}
				if(node.right != null) {
					deque.addLast(node.right);
				}
			}
		}
    }
    //O(1)空间复杂度
    public void connectConstantSpace(TreeLinkNode root) {
    		TreeLinkNode first = root;
    		while(first != null) {
    			TreeLinkNode curt = first, nextLevelFirst = null, nextLevelPrev = null;
    			while(curt != null) {
    				if(nextLevelFirst == null) {
    					nextLevelFirst = curt.left != null ? curt.left : curt.right;
    				}
    				if(curt.left != null) {
    					if(nextLevelPrev != null) {
    						nextLevelPrev.next = curt.left;
    					}
    					nextLevelPrev = curt.left;
    				}
    				if(curt.right != null) {
    					if(nextLevelPrev != null) {
    						nextLevelPrev.next = curt.right;
    					}
    					nextLevelPrev = curt.right;
    				}
    				curt = curt.next;
    			}
    			first = nextLevelFirst;
    		}
    }
	@Test
	public void test() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		connect(root);
		assertEquals(root.left.next, root.right);
	}

	@Test
	public void test1() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.right.right = new TreeLinkNode(5);
		connectConstantSpace(root);
		assertEquals(5, root.left.left.next.next.val);
	}
}
