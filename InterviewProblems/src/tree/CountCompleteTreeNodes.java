package tree;

/**
 * Count Complete Tree Nodes
 * 
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 */

/*
 * Recursion. The thought is to only count complete subtree. If it is not,
 * recursively go down left and right subtrees.
 * 
 * Note: left and right start with root;
 * 
 * Time: O(h^2)	
 */
public class CountCompleteTreeNodes {
    public class Solution {
	public int countNodes(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    TreeNode left = root;
	    TreeNode right = root;

	    int depthL = 0;
	    while (left != null) {
		left = left.left;
		depthL++;
	    }

	    int depthR = 0;
	    while (right != null) {
		right = right.right;
		depthR++;
	    }

	    if (depthL == depthR) {
		return (1 << depthL) - 1;
	    } else {
		return 1 + countNodes(root.left) + countNodes(root.right);
	    }
	}
    }
}
