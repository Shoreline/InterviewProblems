package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import linkedlist.ListNode;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	TreeNode root = new TreeNode(0);
	root.left = new TreeNode(1);
	// root.left = new TreeNode(2);
	// new BinaryPostOrderTraversal().new
	// Solution().postorderTraversal(root);

	new Test().recoverTree(root);

    }

    public void recoverTree(TreeNode root) {
	if (root == null) {
	    return;
	}

	List<TreeNode> candidates = new ArrayList<TreeNode>();// maximum 2
							      // elements

	inOrderTraverse(root, null, candidates);

	int tmp = candidates.get(0).val;
	candidates.get(0).val = candidates.get(1).val;
	candidates.get(1).val = tmp;
    }

    private void inOrderTraverse(TreeNode root, TreeNode preNode,
	    List<TreeNode> candidates) {
	if (root == null) {
	    return;
	}

	inOrderTraverse(root.left, preNode, candidates);

	if (preNode != null && preNode.val > root.val) {
	    if (candidates.size() == 0) {
		candidates.add(preNode);
		candidates.add(root);
	    } else {
		candidates.remove(1);
		candidates.add(root);
	    }
	}
	preNode = root;
	inOrderTraverse(root.right, preNode, candidates);
    }

}
