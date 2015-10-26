package tree;

/**
 * Inorder Successor in BST
 * 
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 */
public class InorderSuccessorInBST {

    public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    if (root == null)
		return null;

	    TreeNode suc = null;
	    // can use variable root directly. but 'cur' looks less misleading
	    TreeNode cur = root;
	    while (cur != null) {
		if (cur.val > p.val) { // the suc's val must > p.val
		    suc = cur;
		    cur = cur.left;
		} else {
		    cur = cur.right;
		}
	    }
	    return suc;
	}
    }

    public class Solution2 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    if (root == null)
		return null;

	    if (root.val <= p.val) {
		return inorderSuccessor(root.right, p);
	    } else {
		TreeNode left = inorderSuccessor(root.left, p);
		return (left != null && left.val > p.val) ? left : root;
	    }

	}

	public TreeNode predecessor(TreeNode root, TreeNode p) {
	    if (root == null)
		return null;

	    if (root.val >= p.val) {
		return predecessor(root.left, p);
	    } else {
		TreeNode right = predecessor(root.right, p);
		return (right != null && right.val < p.val) ? right : root;
	    }
	}
    }

}
