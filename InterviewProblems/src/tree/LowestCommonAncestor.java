package tree;

public class LowestCommonAncestor {
    /**
     * Find the lowest common ancestor in a binary tree
     * 
     * Assume p, q are guaranteed in this tree
     */
    /*
     * Bottom-up method. Only takes O(n) time.
     */
    public static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {

	if (root == null)
	    return null;

	// do not forget this
	if (root == p || root == q)
	    return root;

	TreeNode L = getLCA(root.left, p, q);
	TreeNode R = getLCA(root.right, p, q);
	if (L != null && R != null && L != R)
	    return root;

	return L == null ? R : L;

    }

    /*
     * Top-down method, takes O(n^2) time.
     * 
     * Need another recursion method isDescendent()
     */
    public static TreeNode getLCATopDown(TreeNode root, TreeNode p, TreeNode q) {

	if (root == null)
	    return null;

	// do not forget this
	if (root == p || root == q)
	    return root;

	boolean pInLeft = isDescendent(root.left, p);
	boolean qInLeft = isDescendent(root.left, q);

	if (pInLeft && qInLeft)
	    return getLCATopDown(root.left, p, q);
	else if ((pInLeft || qInLeft) == false)
	    return getLCATopDown(root.right, p, q);
	else
	    return root;

    }

    private static boolean isDescendent(TreeNode root, TreeNode p) {
	if (root == null)
	    return false;
	if (root == p)
	    return true;
	return (isDescendent(root.left, p) || isDescendent(root.right, p));
    }
}
