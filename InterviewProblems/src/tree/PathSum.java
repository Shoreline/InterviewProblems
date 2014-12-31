package tree;

import java.util.ArrayList;

public class PathSum {
    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf
     * path such that adding up all the values along the path equals the given
     * sum.
     * 
     * For example: Given the below binary tree and sum = 22,
     * 
     */
    // 5
    // / \
    // 4 8
    // / / \
    // 11 13 4
    // / \ \
    // 7 2 1

    /**
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is
     * 22.
     */

    public static boolean hasPathSum(TreeNode root, int sum) {
	if (root == null) {
	    return false;
	}

	ArrayList<Integer> rootToNode = new ArrayList<Integer>();

	// ***Easy to forget adding root value first!!
	rootToNode.add(root.val);

	return hasPathSum(root, sum, rootToNode);

    }

    private static boolean hasPathSum(TreeNode root, int sum,
	    ArrayList<Integer> rootToNode) {

	if (root == null) {
	    return false;
	}

	if (root != null && root.left == null && root.right == null) {
	    int curSum = 0;
	    for (Integer anInteger : rootToNode) {
		curSum += anInteger;
	    }
	    if (curSum == sum) {
		return true;
	    }
	}

	ArrayList<Integer> listForLeft = new ArrayList<Integer>(rootToNode);
	ArrayList<Integer> listForRight = new ArrayList<Integer>(rootToNode);

	if (root.left != null)
	    listForLeft.add(root.left.val);

	if (root.right != null)
	    listForRight.add(root.right.val);

	return (hasPathSum(root.left, sum, listForLeft) || hasPathSum(
		root.right, sum, listForRight));
    }

    /*
     * Only need to return a boolean value, so no need to use an arraylist to
     * store the path!
     */
    public static boolean hasPathSum2(TreeNode root, int sum) {

	if (root == null) {
	    return false;
	}

	if (root.left == null && root.right == null) {
	    return (root.val == sum);
	} else {
	    return (hasPathSum2(root.left, sum - root.val) || hasPathSum2(
		    root.right, sum - root.val));
	}

    }
}
