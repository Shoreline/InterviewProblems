package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 */

public class UniqueBinarySearchTreesII {
    /*
     * the helper method does not return void!
     * 
     * For other dfs problems, one solution is found once reached the end
     * (deepest place). So the dfs method can be void, only keep the
     * intermediate result and overall solutions as arguments. Each solution is
     * generated only once.
     * 
     * It is important to add 'null' to List.
     */
    public class Solution {
	public List<TreeNode> generateTrees(int n) {
	    return helper(1, n);
	}

	// Returns a list of trees. Each tree represents by a TreeNode
	private List<TreeNode> helper(int start, int end) {
	    List<TreeNode> res = new ArrayList<>();
	    if (start > end) { // important stop condition
		res.add(null);
		return res;
	    }

	    for (int i = start; i <= end; i++) {
		List<TreeNode> leftTrees = helper(start, i - 1);
		List<TreeNode> rightTrees = helper(i + 1, end);
		for (TreeNode leftNode : leftTrees) {
		    for (TreeNode rightNode : rightTrees) {
			TreeNode root = new TreeNode(i);
			root.left = leftNode;
			root.right = rightNode;
			res.add(root);
		    }
		}
	    }

	    return res;
	}
    }
}
