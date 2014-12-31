package tree;

public class BinaryTreeMaximumPathSum {
    /**
     * Given a binary tree, find the maximum path sum.
     * 
     * The path may start and end at any node in the tree.
     * 
     * For example: Given the below binary tree, {1,2,3} Return 6.
     */

    /*
     * High hand solution
     */
    static int MAX = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
	dfs(root);
	int result = MAX; // now MAX has been changed by dfs(root)
	MAX = Integer.MIN_VALUE; // reset MAX, otherwise LeetCode test will have
				 // errors
	return result;
    }

    private static int dfs(TreeNode root) {
	if (root == null)
	    return 0;

	int l = dfs(root.left);
	int r = dfs(root.right);
	int m = root.val;
	if (l > 0)
	    m += l;
	if (r > 0)
	    m += r;

	MAX = Math.max(MAX, m);
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
