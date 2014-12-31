package tree;

public class MaximumDepthOfBinaryTree {
    /**
     * Maximum Depth of Binary Tree
     * 
     * Given a binary tree, find its maximum depth.
     * 
     * The maximum depth is the number of nodes along the longest path from the
     * root node down to the farthest leaf node.
     */

    /*
     * one time pass
     * 
     * simple recursion.
     */
    public int maxDepth(TreeNode root) {
	if (root == null)
	    return 0;

	int result = 0;

	result = 1 + Math.max(maxDepth(root.left), (maxDepth(root.right)));

	return result;
    }
}
