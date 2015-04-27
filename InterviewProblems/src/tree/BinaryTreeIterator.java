package tree;

import java.util.Stack;

/**
 * Binary Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

public class BinaryTreeIterator {
    public class BSTIterator {
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
	    stack = new Stack<TreeNode>();

	    TreeNode node = root;
	    while (node != null) {
		stack.push(node);
		node = node.left;
	    }
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
	    return !stack.isEmpty();
	}

	/** @return the next smallest number */
	// hasNext() is assumed to be checked outside before next()
	public int next() {
	    TreeNode min = stack.pop();
	    int res = min.val;
	    if (min.right != null) {
		TreeNode node = min.right;
		while (node != null) {
		    stack.push(node);
		    node = node.left;
		}
	    }
	    return res;
	}
    }

}
