package tree;

/**
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

/*
 * Be careful of the definition of minimum depth.
 * 
 * If one of the children of root is null, then its min depth is 1 + min_depth
 * of the other node (still true even if the other node is also null)
 */
public class MinimumDepthOfBinaryTree {
    public class Solution {
	public int minDepth(TreeNode root) {
	    if (root == null) {
		return 0;
	    }
	    if (root.left == null || root.right == null) {
		return 1 + (root.left == null ? minDepth(root.right)
			: minDepth(root.left));
	    }

	    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
    }

    public class Solution_2 {
	public int minDepth(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    return dfs(root);
	}

	private int dfs(TreeNode root) {
	    if (root.left == null && root.right == null) {
		return 1;
	    }

	    int left = Integer.MAX_VALUE;
	    if (root.left != null) {
		left = dfs(root.left);
	    }
	    int right = Integer.MAX_VALUE;
	    if (root.right != null) {
		right = dfs(root.right);
	    }

	    return Math.min(left, right) + 1;
	}
    }

    class Solution_2013 {
	public int minDepth(TreeNode root) {
	    if (root == null)
		return 0;

	    if (root.left == null && root.right == null)
		return 1;

	    int left = Integer.MAX_VALUE;
	    int right = Integer.MAX_VALUE;

	    if (root.left != null) {
		left = minDepth(root.left);
	    }
	    if (root.right != null) {
		right = minDepth(root.right);
	    }

	    return 1 + Math.min(left, right);
	}

	/*
	 * For reference: get height (maximum depth) of a binary tree
	 * 
	 * No need to care every leaf
	 */

	public int getHeight(TreeNode root) {
	    if (root == null)
		return 0;
	    return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
	}
    }
}
