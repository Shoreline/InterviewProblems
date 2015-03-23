package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
	For example:
	Given binary tree {1,#,2,3},
   	1
    	 \
     	  2
    	 /
   	3
	return [3,2,1].
 */

public class BinaryPostOrderTraversal {
    /*
     * Keep tracking previous added node
     * ------------------------------------------------------
     * n | (n.right) | n.left | n.left.right| n.left.left| ...
     * ------------------------------------------------------
     * 
     * When the left tree of n is finished; we need to know if n has right sub-tree
     * 
     */
    public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (root == null) {
		return res;
	    }

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode pre = null;

	    stack.push(root);
	    while (!stack.isEmpty()) {
		TreeNode cur = stack.peek();

		/*
		 * if 1)cur is a leaf or 2)previous traversed node is the child
		 * of cur
		 * 
		 * 2) is to deal with n, n.right, n.left situation
		 */
		if ((cur.left == null && cur.right == null)
			|| (pre != null && (pre == cur.left || pre == cur.right))) {
		    res.add(cur.val);
		    pre = cur;
		    stack.pop();
		} else {
		    // push the left node later so it will be pop befor the
		    // right node
		    if (cur.right != null) {
			stack.push(cur.right);
		    }
		    if (cur.left != null) {
			stack.push(cur.left);
		    }
		}
	    }

	    return res;
	}
    }
}
