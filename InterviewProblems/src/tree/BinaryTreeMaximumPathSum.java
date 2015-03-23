package tree;

public class BinaryTreeMaximumPathSum {
    /**
     * Given a binary tree, find the maximum path sum.
     * 
     * The path may start and end at any node in the tree.
     * 
     * For example: Given the below binary tree, {1,2,3} Return 6.
     */
    public class Solution {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

	    if (root == null) {
		return max;
	    }

	    helper(root);

	    return max;
	}

	// The helper itself returns the max sum of a path that always include
	// root. But the 'max' argument keeps tracking all-time max (path may
	// not include root)
	public int helper(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    int leftMax = helper(root.left);
	    int rightMax = helper(root.right);

	    int subMax = root.val;

	    if (leftMax > 0) {
		subMax += leftMax;
	    }

	    if (rightMax > 0) {
		subMax += rightMax;
	    }

	    max = Math.max(max, subMax);

	    if (Math.max(leftMax, rightMax) > 0) {
		return root.val + Math.max(leftMax, rightMax);
	    } else {
		return root.val;
	    }
	}
    }

    /*
     * High hand solution
     * 
     * time: O(N); space: o(1)
     */
    static int MAX = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
	findMaximumPathSum(root);
	int result = MAX; // now MAX has been changed by dfs(root)
	MAX = Integer.MIN_VALUE; // reset MAX, otherwise LeetCode test will have
				 // errors
	return result;
    }

    private static int findMaximumPathSum(TreeNode root) {
	if (root == null)
	    return 0;

	int l = findMaximumPathSum(root.left); // root.val may be negative
	int r = findMaximumPathSum(root.right);
	int m = root.val;
	if (l > 0)
	    m += l;
	if (r > 0)
	    m += r;

	MAX = Math.max(MAX, m); // maximum possible value under subtree rooted
				// at 'root'
	return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;
    }

    /*
     * My thoughts after reading high hand's solution: 1.Every path has one
     * special node: the node that has the highest depth!
     * 
     * Once this node is used as root in dfs(), the maximumPathSum is found.
     * Obviously, all nodes in the target path are connected.
     * 
     * High hand's recursion will check: for every node, if it is used as the
     * root of a path, what is the maximum sum we can get from this path: the
     * value of m (NOT the return value of dfs(aNode)).
     * 
     * The returned value of dfs(aNode) actually is: the maximum sum value of a
     * partial-path that lands in the area of subtree rooted at aNode. The whole
     * path has a special node that at least one level higher than aNode
     */
}
