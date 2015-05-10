package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BSTIterator {
	List<TreeNode> list;
	int i;
    public BSTIterator(TreeNode root) {
    		list = new ArrayList<>();
    		i = 0;
    		inOrder(list, root);
    }
    
    private void inOrder(List<TreeNode> list, TreeNode root) {
    		if(root != null) {
    			inOrder(list, root.left);
    			list.add(root);
    			inOrder(list, root.right);
    		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    		return i <= list.size() - 1;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(i++).val;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
