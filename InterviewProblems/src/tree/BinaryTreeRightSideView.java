package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree,
 * 
 * 1 <--- / \ 2 3 <--- \ \ 5 4 <---
 * 
 * You should return [1, 3, 4].
 */

public class BinaryTreeRightSideView {
    /*
     * Basically, it is a binary tree level traversal problem
     */

    public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    if (root == null) {
		return res;
	    }

	    List<TreeNode> cur = new ArrayList<>();
	    cur.add(root);
	    while (!cur.isEmpty()) {
		List<TreeNode> next = new ArrayList<TreeNode>();

		for (TreeNode node : cur) {
		    if (node.left != null) {
			next.add(node.left);
		    }
		    if (node.right != null) {
			next.add(node.right);
		    }
		}
		res.add(cur.get(cur.size() - 1).val);
		cur = next;
	    }

	    return res;
	}
    }
}
