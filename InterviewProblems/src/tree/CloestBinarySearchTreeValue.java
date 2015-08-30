package tree;

import java.util.*;

public class CloestBinarySearchTreeValue {
    public class Solution {
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
