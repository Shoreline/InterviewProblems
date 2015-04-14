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
     * The code below generate many duplicated solutions.
     * 
     * It is important to add 'null' to List.   
     */
    public class Solution {
	public List<TreeNode> generateTrees(int n) {
	    List<TreeNode> res = new ArrayList<TreeNode>();
	    if (n < 1) {
		res.add(null);
		return res;
	    }
	    res = genTreeHelper(1, n);
	    return res;
	}

	private List<TreeNode> genTreeHelper(int start, int end) {
	    List<TreeNode> res = new ArrayList<TreeNode>();
	    if (start > end) {
		res.add(null);
		return res;
	    }

	    for (int i = start; i <= end; i++) {
		List<TreeNode> leftTrees = genTreeHelper(start, i - 1);
		List<TreeNode> rightTrees = genTreeHelper(i + 1, end);
		for (int l = 0; l < leftTrees.size(); l++) {
		    for (int r = 0; r < rightTrees.size(); r++) {
			TreeNode root = new TreeNode(i);
			root.left = leftTrees.get(l);
			root.right = rightTrees.get(r);
			res.add(root);
		    }
		}
	    }

	    return res;
	}
    }
}
