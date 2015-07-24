package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	public class Solution {
	    public List<Integer> rightSideView(TreeNode root) {
	    		List<Integer> res = new ArrayList<>();
	    		if(root == null) return res;
	        Deque<TreeNode> deque = new LinkedList<>();
	        deque.addLast(root);
	        while(!deque.isEmpty()) {
	        		int size = deque.size();
	        		TreeNode curr = null;
	        		for(int i = 0; i < size; i++) {
	        			curr = deque.pollFirst();
	        			if(curr.left != null)
	        				deque.addLast(curr.left);
	        			if(curr.right != null)
	        				deque.addLast(curr.right);
	        		}
	        		res.add(curr.val);
	        }
	    		return res;
	    }
	}
}
