package tree;

/**
 * Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 *       1
        / \
       2   5
      / \   \
     3   4   6
 * 
 * The flattened tree should look like: 

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * 
 * Hints: If you notice carefully in the flattened tree, each node's right child
 * points to the next node of a pre-order traversal.
 */

/*
 * Just like the hint says, the actual problem is to pre-order traverse the
 * given tree
 */
public class FlattenBinaryTreeToLinkedList {
    /*
     * Used a class level variable, may not be the best way
     */
    public class Solution {
	TreeNode preNode = null;

	public void flatten(TreeNode root) {
	    if (root == null) {
		return;
	    }

	    if (preNode != null) {
		preNode.right = root;
	    }
	    preNode = root;
	    TreeNode left = root.left;
	    TreeNode right = root.right;
	    root.left = null;

	    flatten(left);
	    flatten(right);
	}
    }

    /*
     * passed at the second time
     * 
     * Straightforward way.
     * 
     * For a root node, disconnect its original right child, re-assign its left
     * child to be the new right child. Recursively call flatten(root.left) to
     * make sure the whole left sub-tree is flattened. Then connect the right
     * node back to the rightmost child, continue call
     * flatten(root.orignalRight) to flatten the right sub-tree
     */
    class Solution_2013 {
	public void flatten(TreeNode root) {
	    if (root == null)
		return;

	    TreeNode preRight = root.right;

	    if (root.left != null) {
		root.right = root.left;
		root.left = null;
		flatten(root.right);

		TreeNode curRight = root.right;
		while (curRight.right != null) {
		    curRight = curRight.right;
		}
		curRight.right = preRight;
	    }

	    /*
	     * after flattening the left subtree, do not forget do the same to
	     * the right subtree
	     */

	    flatten(preRight);

	    return;
	}
    }
}
