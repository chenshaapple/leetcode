package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
    		if(root == null) {
    			return;
    		}
        List<TreeNode> list = new LinkedList<>();
        preOrder(list, root);
        root.left = null;
        for(TreeNode node : list) {
        		if(node != root) {
        			node.left = null;
        			root.right = node;
        			root = root.right;
        		}
        }
    }
    
    private void preOrder(List<TreeNode> list, TreeNode root) {
    		if(root != null) {
    			list.add(root);
    		}
    		preOrder(list, root.left);
    		preOrder(list, root.right);
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
