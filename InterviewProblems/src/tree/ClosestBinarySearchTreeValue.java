package tree;

import java.util.*;

/**
 * Closest Binary Search Tree Value
 * 
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 *
 */
public class ClosestBinarySearchTreeValue {
    /*
     * Take advantage of BST's attribute 
     */
    public class Solution {
	public int closestValue(TreeNode root, double target) {
	    int res = root.val;
	    while (root != null) {
		if (Math.abs(target - root.val) < Math.abs(target - res)) {
		    res = root.val;
		}
		root = root.val > target ? root.left : root.right;
	    }
	    return res;
	}
    }

    public class Solution2 {
	public int closestValue(TreeNode root, double target) {
	    List<Integer> min = new ArrayList<>();
	    dfs(root, target, min);
	    return min.get(0);
	}

	private void dfs(TreeNode root, double target, List<Integer> min) {
	    if (root == null || (!min.isEmpty() && min.get(0) == target)) {
		return;
	    }

	    double diff = Math.abs(root.val - target);
	    if (min.isEmpty()) {
		min.add(root.val);
	    } else if (diff < Math.abs(min.get(0) - target)) {
		min.set(0, root.val);
	    }

	    if (root.val == target) {
		return;
	    } else if (root.val - target > 0) {
		dfs(root.left, target, min);
	    } else {
		dfs(root.right, target, min);
	    }
	}
    }
}
