package google;

import java.util.*;

import tree.TreeNode;

/**
 * Find duplicate subtrees in a BT, and print out
 *
 */
/*
 * 存每一个node的preorder和Inorder traversal的List然后检查是不是都重复
 * 
 * Note: can use one list as the finger print: to save preorder values first,
 * then append inorder values to the end.
 */
public class DuplicatedSubStrees {
    public class Method {
	private boolean contains;
	private TreeNode node1, node2;

	public boolean SameSubTree(TreeNode root) {
	    if (root == null) {
		return true;
	    }

	    contains = false;
	    node1 = null;
	    node2 = null;
	    HashMap<List<Integer>, TreeNode> record = new HashMap<List<Integer>, TreeNode>();
	    search(root, node1, node2, record);

	    return contains;
	}

	private List<List<Integer>> search(TreeNode root, TreeNode n1,
		TreeNode n2, HashMap<List<Integer>, TreeNode> record) {
	    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

	    if (root == null) {
		res.add(new ArrayList<Integer>());
		res.add(new ArrayList<Integer>());
		return res;
	    }
	    List<List<Integer>> left = search(root.left, n1, n2, record);
	    List<List<Integer>> right = search(root.right, n1, n2, record);

	    List<Integer> inorder = new ArrayList<Integer>();
	    List<Integer> preorder = new ArrayList<Integer>();
	    List<Integer> key = new ArrayList<Integer>();

	    inorder.addAll(left.get(0));
	    inorder.add(root.val);
	    inorder.addAll(right.get(0));

	    preorder.add(root.val);
	    preorder.addAll(left.get(1));
	    preorder.addAll(right.get(1));

	    key.addAll(inorder);
	    key.addAll(preorder);
	    if (record.containsKey(key)) {
		contains = true;
		node1 = record.get(key);
		node2 = root;
	    }

	    record.put(key, root);

	    res.add(inorder);
	    res.add(preorder);
	    return res;
	}

    }
}
