package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 *
 */
public class BinaryTreePreOrderTraversal {
    /*
     * Iterative solution. 'root' is the current node being processed
     */
    public class Solution_Iterative {
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();

	    while (root != null || !stack.isEmpty()) {
		if (root == null) {
		    root = stack.pop();
		}

		res.add(root.val);

		if (root.right != null) {
		    stack.push(root.right);
		}

		root = root.left;
	    }

	    return res;
	}
    }

    public class Solution_recursive {
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    ptHelper(res, root);

	    return res;
	}

	private void ptHelper(List<Integer> res, TreeNode root) {
	    if (root == null) {
		return;
	    }

	    res.add(root.val);
	    ptHelper(res, root.left);
	    ptHelper(res, root.right);
	}
    }
}
