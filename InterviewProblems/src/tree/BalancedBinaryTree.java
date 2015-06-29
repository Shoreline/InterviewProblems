package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */

public class BalancedBinaryTree {
    public class Solution {
	public boolean isBalanced(TreeNode root) {
	    return getHeight(root) != -1;
	}

	private int getHeight(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    int left = getHeight(root.left);
	    if (left == -1) {
		return -1;
	    }

	    int right = getHeight(root.right);
	    if (right == -1 || Math.abs(left - right) > 1) {
		return -1;
	    }

	    return 1 + Math.max(left, right);
	}
    }
}
