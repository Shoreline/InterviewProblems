package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */

public class ConstructBTreeFromInorderAndPreOrder {
    /*
     * Keep track of the index range of current sub-tree in int[] preorder and
     * int[] inorder.
     * 
     * Each time being invoked, the helper method build the root node of current
     * sub-tree, then call itself twice to continuously build root.left and
     * root.right
     */
    public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder == null || inorder == null) {
		return null;
	    }

	    // tree value to In-order array index map
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < inorder.length; i++) {
		map.put(inorder[i], i);
	    }

	    return buildHelper(preorder, 0, preorder.length - 1, inorder, 0,
		    inorder.length - 1, map);
	}

	// preL, preR and inL, inR: inclusive index boundaries of current
	// sub-tree
	private TreeNode buildHelper(int[] preorder, int preL, int preR,
		int[] inorder, int inL, int inR, Map<Integer, Integer> map) {
	    if (preL > preR || inL > inR) {
		return null;
	    }

	    TreeNode root = new TreeNode(preorder[preL]);
	    int inOrderIndex = map.get(root.val);

	    root.left = buildHelper(preorder, preL + 1, preL + inOrderIndex
		    - inL, inorder, inL, inOrderIndex - 1, map);
	    root.right = buildHelper(preorder, preL + inOrderIndex - inL + 1,
		    preR, inorder, inOrderIndex + 1, inR, map);

	    return root;
	}
    }
}
