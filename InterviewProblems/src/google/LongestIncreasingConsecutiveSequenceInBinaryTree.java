package google;

import tree.TreeNode;

/**
 * longest consecutive increasing sequence in binary tree.
 * 
 * Starting point can be any node in the tree, not necessarily start from the
 * root
 *
 */

/*
 * Somewhat similar to Binary Tree Maximum Path Sum
 * 
 * For every node:
 * 
 * cur[0]: longest decreasing path length ends at this node
 * 
 * cur[1]: longest increasing path length starts at this node
 */
public class LongestIncreasingConsecutiveSequenceInBinaryTree {
    Integer res = 0;

    public int getLongestConsecutiveIncreasingSequenceLen(TreeNode root) {
	dfs(root);
	return res;
    }

    private int[] dfs(TreeNode root) {

	int[] cur = new int[2];
	if (root == null) {
	    return cur;
	}

	cur[0] = 1;
	cur[1] = 1;
	int curMax = 1;

	int[] left = dfs(root.left);
	int[] right = dfs(root.right);

	if (root.left != null) {
	    if (root.left.val < root.val) {
		cur[0] = Math.max(cur[0], left[0] + 1);
		curMax = Math.max(curMax, left[0] + 1);
	    } else if (root.left.val > root.val) {
		cur[1] = Math.max(cur[1], left[1] + 1);
		curMax = Math.max(curMax, left[1] + 1);
	    }
	}

	if (root.right != null) {
	    if (root.right.val < root.val) {
		cur[0] = Math.max(cur[0], right[0] + 1);
		curMax = Math.max(curMax, right[0] + 1);
	    } else {
		cur[1] = Math.max(cur[1], right[1] + 1);
		curMax = Math.max(curMax, right[1] + 1);
	    }
	}

	if (root.left != null && root.right != null) {
	    if (root.left.val < root.val && root.val < root.right.val) {
		curMax = Math.max(curMax, left[0] + 1 + right[1]);
	    }
	    if (root.left.val > root.val && root.val > root.right.val) {
		curMax = Math.max(curMax, left[1] + 1 + right[0]);
	    }
	}

	res = Math.max(res, curMax);

	return cur;
    }
}
