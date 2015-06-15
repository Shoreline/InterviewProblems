package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */

/*
 * Keep track of the index range of current sub-tree in int[] preorder and
 * int[] inorder.
 * 
 * Each time being invoked, the helper method build the root node of current
 * sub-tree, then call itself twice to continuously build root.left and
 * root.right
 */
public class ConstructBTreeFromInorderAndPreOrder {
    public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder == null || inorder == null) {
		return null;
	    }

	    // inorder array value to index map
	    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
	    for (int i = 0; i < inorder.length; i++) {
		inorderIndexMap.put(inorder[i], i);
	    }

	    return treeBuilder(preorder, 0, preorder.length - 1, inorder, 0,
		    inorder.length - 1, inorderIndexMap);
	}

	private TreeNode treeBuilder(int[] preorder, int preStart, int preEnd,
		int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
	    if (inStart > inEnd) {
		return null;
	    }

	    TreeNode root = new TreeNode(preorder[preStart]);

	    int index = map.get(root.val);
	    int lenLeft = index - inStart; // length, not offset. offset is length -1
	    TreeNode left = treeBuilder(preorder, preStart + 1, preStart + 1
		    + lenLeft - 1, inorder, inStart, index - 1, map);
	    TreeNode right = treeBuilder(preorder, preStart + 1 + lenLeft - 1
		    + 1, preEnd, inorder, index + 1, inEnd, map);
	    root.left = left;
	    root.right = right;

	    return root;
	}
    }
}
