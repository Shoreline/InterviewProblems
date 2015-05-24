package tree;

/**
 * Binary Tree Upside Down
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a
 * sibling (a left node that shares the same parent node) or empty, flip it
 * upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 * 
 * For example: Given a binary tree {1,2,3,4,5},
 *        1
   	 / \
 	2   3
       / \
      4   5
 * 
 * return the root of the binary tree [4,5,2,#,#,3,1].
           4
          / \
         5   2
            / \
           3   1  
 * 
 */


public class BinaryTreeUpsideDown {
    /*
     * Do not dive to the deepest leftmost node. Directly start from the tree
     * root.
     * 
     * Re-connect the left and right child of the left node of each level, to
     * its former right sibling node and parent node.
     */
    public class Solution {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
	    if (root == null) {
		return null;
	    }

	    TreeNode cur = root;
	    TreeNode parent = null;
	    TreeNode parentRight = null;
	    while (cur != null) {
		// curLeft and curRight are temp variables
		TreeNode curLeft = cur.left;
		TreeNode curRight = cur.right;

		cur.left = parentRight;
		cur.right = parent;

		parent = cur;
		parentRight = curRight;
		cur = curLeft;
	    }

	    return parent;
	}
    }

    /*
     * Time limit exceeded
     */
    class Wrong_method_recursion {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
	    if (root == null) {
		return null;
	    }

	    TreeNode newRoot = upsideDownBinaryTree(root.left);
	    if (newRoot != null) {
		newRoot.left = root.right;
		newRoot.right = root;
		return newRoot;
	    } else {
		return root;
	    }
	}
    }
}
