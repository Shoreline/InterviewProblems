package tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import linkedlist.ListNode;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	RecoverBinarySearchTree.recoverTree(root);

	UniqueBinarySearchTreesII.generateTrees(1);

	TreeNode a = new TreeNode(1);
	System.out.println(PathSum.hasPathSum(a, 1));

	ConvertSortedArrayToBinarySearchTree
		.sortedArrayToBST(new int[] { 1, 3 });

	ConvertSortedListToBinarySearchTree.sortedListToBSTB(new ListNode(0));

	TreeNode t = new TreeNode(1);
	t.left = new TreeNode(2);
	t.right = new TreeNode(5);
	t.left.left = new TreeNode(3);
	t.left.right = new TreeNode(4);
	t.right.right = new TreeNode(6);

	FlattenBinaryTreeToLinkedList.flatten(t);

	LinkedList<String> haha = new LinkedList<String>();
	Collections.reverse(haha);
	HashMap<String, String> hahaha = new HashMap<String, String>();

    }

}
