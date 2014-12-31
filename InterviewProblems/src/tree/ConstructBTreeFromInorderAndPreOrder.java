package tree;

public class ConstructBTreeFromInorderAndPreOrder {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary
     * tree.
     * 
     * Note: You may assume that duplicates do not exist in the tree.
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {

	// be careful of the boundary conditions
	// the following may not be right
	if (postorder.length == 0 || postorder == null) {
	    return null;
	}

	TreeNode root = new TreeNode(postorder[postorder.length - 1]);

	int inorderRootIndex = 0;
	while (inorder[inorderRootIndex] == root.val) {
	    inorderRootIndex++;
	}

	int postorderLeftEndIndex = 0;
	while (postorder[postorderLeftEndIndex] == inorder[inorderRootIndex - 1]) {
	    postorderLeftEndIndex++;
	}

	/*
	 * build sub in / post order arrays
	 * 
	 * recursively sovle the problem
	 */

	return root;
    }
}
