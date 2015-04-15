package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */

/*
 * Same method as construct binary tree from preorder and inorder traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    if (inorder == null || postorder == null) {
		return null;
	    }

	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < inorder.length; i++) {
		map.put(inorder[i], i);
	    }

	    return buildHelper(inorder, 0, inorder.length - 1, postorder, 0,
		    postorder.length - 1, map);
	}

	private TreeNode buildHelper(int[] inorder, int inL, int inR,
		int[] postorder, int postL, int postR, Map<Integer, Integer> map) {
	    if (inL > inR) {
		return null;
	    }

	    TreeNode root = new TreeNode(postorder[postR]);
	    int inOrderIndex = map.get(root.val);

	    root.left = buildHelper(inorder, inL, inOrderIndex - 1, postorder,
		    postL, postL + inOrderIndex - inL - 1, map);
	    root.right = buildHelper(inorder, inOrderIndex + 1, inR, postorder,
		    postL + inOrderIndex - inL, postR - 1, map);
	    return root;
	}

    }
}
