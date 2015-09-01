package tree;

/**
 * In this case the tree is a binary search tree
 */
public class LowestCommonAncestorBST {
    class Solution_Recursion {
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
    
    class Solution_Iterative{
//	/* Function to find LCA of n1 and n2. The function assumes that both
//	   n1 and n2 are present in BST */
//	struct node *lca(struct node* root, int n1, int n2)
//	{
//	    while (root != NULL)
//	    {
//	         // If both n1 and n2 are smaller than root, then LCA lies in left
//	        if (root->data > n1 && root->data > n2)
//	           root = root->left;
//	 
//	        // If both n1 and n2 are greater than root, then LCA lies in right
//	        else if (root->data < n1 && root->data < n2)
//	           root = root->right;
//	 
//	        else break;
//	    }
//	    return root;
//	}
    }
}
