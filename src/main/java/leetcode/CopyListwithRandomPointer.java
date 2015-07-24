package leetcode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		RandomListNode curr = this;
		while(curr != null) {
			res.append(label);
			if(curr.next != null) res.append("->");
			curr = curr.next;
		}
		return res.toString();
	}
};

public class CopyListwithRandomPointer {
	public class Solution {
	    public RandomListNode copyRandomList(RandomListNode head) {
	        Map<RandomListNode, RandomListNode> map = new HashMap<>();
	        for(RandomListNode curr = head; curr != null; curr = curr.next) {
	        		RandomListNode node = new RandomListNode(curr.label);
	        		map.put(curr, node);
	        }
	        for(RandomListNode curr = head; curr != null; curr = curr.next) {
	        		RandomListNode node = map.get(curr);
	        		node.next = map.get(curr.next);
	        		node.random = map.get(curr.random);
	        }
	        return map.get(head);
	    }
	    
	    public RandomListNode copyRandomList2(RandomListNode head) {
	    		if(head == null) return head;
	    		for(RandomListNode curr = head; curr != null; curr = curr.next.next) {
	    			RandomListNode copy = new RandomListNode(curr.label);
	    			copy.next = curr.next;
	    			curr.next = copy;
	    		}
	    		RandomListNode res = head.next;
	    		for(RandomListNode curr = head; curr != null; curr = curr.next.next) {
	    			if(curr.random != null)
	    				curr.next.random = curr.random.next;
	    		}
	    		//��ԭList.next
	    		for(RandomListNode curr = head; curr != null;) {
	    			RandomListNode next = curr.next.next, copy = curr.next;
	    			copy.next = next != null ? next.next : null;
	    			curr.next = next;
	    			curr = next;
	    		}
	    		return res;
	    }
	}

	private Solution sln = new Solution();
	@Test
	public void test() {
		RandomListNode head = new RandomListNode(-1);
		head.next = new RandomListNode(-1);
		System.out.println(sln.copyRandomList2(head));
	}
}
