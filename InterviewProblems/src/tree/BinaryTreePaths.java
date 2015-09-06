package tree;

import java.util.*;

/**
 * Binary Tree Paths
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
   1
 /   \
2     3
 \
  5
 * 
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 *
 */
public class BinaryTreePaths {
    /*
     * Regular dfs.
     */
    public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> res = new ArrayList<>();
	    if (root == null) {
		return res;
	    }

	    dfs(root, new StringBuilder(), res);

	    return res;
	}

	private void dfs(TreeNode root, StringBuilder tmp, List<String> res) {
	    tmp.append(root.val);
	    int valLen = String.valueOf(root.val).length();
	    if (root.left == null && root.right == null) {
		res.add(tmp.toString());
		tmp.setLength(tmp.length() - valLen);
		return;
	    }

	    tmp.append("->");

	    if (root.left != null) {
		dfs(root.left, tmp, res);
	    }

	    if (root.right != null) {
		dfs(root.right, tmp, res);
	    }

	    tmp.setLength(tmp.length() - valLen - 2);
	}
    }
}
