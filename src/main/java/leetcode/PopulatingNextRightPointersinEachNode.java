package leetcode;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	public TreeLinkNode(int x) {
		this.val = x;
	}
}


public class PopulatingNextRightPointersinEachNode {
	//using extra space
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
	
	//constant space
	public void connectConstantSpace(TreeLinkNode root) {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
