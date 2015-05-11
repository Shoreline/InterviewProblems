package tree;

/**
 * In this case the tree is a binary search tree
 */
public class LowestCommonAncestorBST {
    public TreeNode getLCA(TreeNode n1, TreeNode n2, TreeNode root) {
	if (n1.val < n2.val) {
	    return getLCAHelper(n1, n2, root);
	} else {
	    return getLCAHelper(n2, n1, root);
	}
    }

    private TreeNode getLCAHelper(TreeNode n1, TreeNode n2, TreeNode root) {
	if (root == null) {
	    return null;
	}

	if (n2.val < root.val) {
	    return getLCAHelper(n1, n2, root.left);
	} else if (n1.val > root.val) {
	    return getLCAHelper(n1, n2, root.right);
	} else {
	    return root;
	}
    }
}
