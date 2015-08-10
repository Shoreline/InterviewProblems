package facebook;

import tree.TreeNode;

/**
 * Given the root of a BST and a target value, delete the node in this BST
 * having this value.
 */

/*
 * When we delete a node, there possibilities arise.
  1) Node to be deleted is leaf: Simply remove from the tree.
              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80
  2) Node to be deleted has only one child: Copy the child to the node and delete the child
              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80
            
  3) Node to be deleted has two children: Find inorder successor of the node. Copy contents 
  of the inorder successor to the node and delete the inorder successor. Note that inorder 
  predecessor can also be used.          

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                            \ 
                60   80                           80
The important thing to note is, inorder successor is needed only when right child is not empty.
In this particular case, inorder successor can be obtained by finding the minimum value in right 
child of the node.
 */

public class DeleteBSTNode {
    /*
     * Recursion. A pretty complete solution.
     */
    class Method {

	public TreeNode delete(TreeNode root, int target) {
	    if (root == null) {
		return null;
	    }

	    if (target < root.val) {
		root.left = delete(root.left, target);
	    } else if (target > root.val) {
		root.right = delete(root.right, target);
	    } else {
		if (root.left == null && root.right == null) {
		    return null; // removed root node.
		}
		if (root.left != null || root.right != null) {
		    TreeNode toBeDeleted = (root.left == null ? root.right : root.left);
		    root.val = toBeDeleted.val;
		    root.left = toBeDeleted.left;
		    root.right = toBeDeleted.right;
		    // gc will clean toBeDeleted from memory in future
		} else {
		    root.val = getMinVal(root.right);
		    delete(root.right, root.val);
		}
	    }

	    return root;
	}

	private int getMinVal(TreeNode node) {
	    if (node.left == null)
		return node.val;
	    else
		return getMinVal(node.left);
	}
    }
}
