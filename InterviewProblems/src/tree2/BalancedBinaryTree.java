package tree2;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by
 * more than 1.
 * 
 */

public class BalancedBinaryTree {


    public static boolean isBalanced(LeetTreeNode root) {
	if (root == null) {
	    return true;
	}

	int leftHeight = getHeight(root.left);
	int rightHeight = getHeight(root.right);

	if (leftHeight == -1 || rightHeight == -1) {
	    return false;
	}

	if (Math.abs(leftHeight - rightHeight) > 1) {
	    return false;
	}
	return true;

    }

    private static int getHeight(LeetTreeNode root) {
	if (root == null) {
	    return 0;
	} else {
	    int leftHeight = getHeight(root.left);
	    if (leftHeight == -1) {
		return -1;
	    }

	    int rightHeight = getHeight(root.right);
	    if (rightHeight == -1) {
		return -1;
	    }
	    if (Math.abs(leftHeight - rightHeight) > 1) {
		return -1;
	    }

	    int result = 1 + Math.max(leftHeight, rightHeight);

	    return result;
	}
    }

    // another solution
    // public static boolean isBalanced(LeetTreeNode root) {
    // if (root == null) {
    // return true;
    // }
    //
    // int leftHeight = getHeight(root.left);
    // int rightHeight = getHeight(root.right);
    //
    //
    //
    // if (Math.abs(leftHeight - rightHeight) > 1) {
    // return false;
    // }
    //
    // return (isBalanced(root.left) && isBalanced(root.right));
    //
    // }
    //
    // private static int getHeight(LeetTreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int result = 1 + Math.max(getHeight(root.left),getHeight(root.right));
    //
    // return result;
    //
    // }

}
