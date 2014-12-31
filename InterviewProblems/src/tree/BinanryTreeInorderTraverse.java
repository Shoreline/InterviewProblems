package tree;

import java.util.ArrayList;

public class BinanryTreeInorderTraverse {

    /**
     * Binary Tree Inorder Traversal
     * 
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * 
     * For example: Given binary tree {1,#,2,3}, return [1,3,2].
     * 
     * Note: Recursive solution is trivial, could you do it iteratively?
     * 
     */

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	if (root == null) {
	    return result; // NOTE! do not return null!
	}

	result.addAll(inorderTraversal(root.left));
	result.add(root.val);
	result.addAll(inorderTraversal(root.right));

	return result;
    }

    /*
     * another solution: solve it iteratively: check notes
     */
    public ArrayList<Integer> inorderTraversalItr(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	return result;
    }

}
