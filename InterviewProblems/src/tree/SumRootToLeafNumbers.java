package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *   1 
 *  / \ 
 * 2   3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 *
 */
public class SumRootToLeafNumbers {
    /*
     * DFS
     */
    public class Solution {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
	    if (root == null) {
		return 0;
	    }

	    List<Integer> path = new ArrayList<Integer>();
	    path.add(root.val);
	    dfs(root, path);
	    return sum;
	}

	private void dfs(TreeNode root, List<Integer> path) {
	    if (root.left == null && root.right == null) {
		int count = 1;
		for (int i = path.size() - 1; i >= 0; i--) {
		    sum += path.get(i) * count;
		    count *= 10;
		}
		return;
	    }

	    if (root.left != null) {
		path.add(root.left.val);
		dfs(root.left, path);
		path.remove(path.size() - 1);
	    }

	    if (root.right != null) {
		path.add(root.right.val);
		dfs(root.right, path);
		path.remove(path.size() - 1);
	    }
	}
    }
}
