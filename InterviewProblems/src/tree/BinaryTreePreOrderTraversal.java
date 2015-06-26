package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 *
 */

/*
 * 3 solutions, similar to in order traversal.
 */
public class BinaryTreePreOrderTraversal {
    /*
     * Morris method.
     * 
     * There is only one line different from in-order traversal
     */
    public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();

	    TreeNode cur = root;
	    TreeNode pre = null;
	    while (cur != null) {
		if (cur.left == null) {
		    res.add(cur.val);
		    cur = cur.right;
		} else {
		    pre = cur.left;
		    while (pre.right != null && pre.right != cur) {
			pre = pre.right;
		    }

		    if (pre.right == null) {
			res.add(cur.val); // the only difference from in-order
			pre.right = cur;
			cur = cur.left;
		    } else {
			// res.add(cur.val); If in-order then add cur.val here
			pre.right = null;
			cur = cur.right;
		    }

		}
	    }

	    return res;
	}

    }

    /*
     * Iterative solution. 'root' is the current node being processed
     * 
     * No need to push root right after initialize stack
     */
    public class Solution_Iteration {
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();

	    while (root != null || !stack.isEmpty()) {
		if (root == null) {
		    root = stack.pop();
		}

		res.add(root.val);

		if (root.right != null) {
		    stack.push(root.right);
		}

		root = root.left;
	    }

	    return res;
	}
    }

    public class Solution_recursion {
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();

	    helper(res, root);

	    return res;
	}

	private void helper(List<Integer> res, TreeNode root) {
	    if (root == null) {
		return;
	    }

	    res.add(root.val);
	    helper(res, root.left);
	    helper(res, root.right);
	}
    }
}
