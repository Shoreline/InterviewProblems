package linkedin;

import java.util.*;

import linkedin.LongestPalindromicSubsequence.Method;
import tree.TreeNode;

/**
 * http://articles.leetcode.com/2010/09/serializationdeserialization-of-binary.
 * html
 *
 */

/*
 * 1) pre-order traversal
 * 
 * 2)we would need to output the NULL nodes using some kind of sentinel (Here,
 * we use ‘#‘ as the sentinel);
 * 
 * Other method: level order traversal
 */
public class EncodeDecodeBinaryTrees {
    public class Codec {

	public String serialize(TreeNode root) {
	    StringBuilder sb = new StringBuilder();
	    helperS(root, sb);
	    return sb.toString();
	}

	private void helperS(TreeNode node, StringBuilder sb) {
	    if (node == null) {
		sb.append("null").append(",");
		return;
	    }

	    sb.append(node.val).append(",");

	    helperS(node.left, sb);
	    helperS(node.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    String[] vals = data.split("[,]");
	    int[] index = new int[] { 0 };
	    return helperD(vals, index);
	}

	private TreeNode helperD(String[] vals, int[] index) {
	    if (index[0] == vals.length) {
		return null;
	    }

	    String visiting = vals[index[0]++];
	    if (visiting.equals("null")) {
		return null;
	    }

	    TreeNode node = new TreeNode(Integer.valueOf(visiting));
	    node.left = helperD(vals, index);
	    node.right = helperD(vals, index);

	    return node;
	}
    }

    class Method {
	public String serialize(TreeNode root) {
	    List<String> res = new ArrayList<String>();
	    serializeHelper(root, res);
	    return res.toString();
	}

	public void serializeHelper(TreeNode root, List<String> res) {
	    if (root == null) {
		res.add("#");
		return;
	    } else {
		res.add(String.valueOf(root.val));
	    }

	    serializeHelper(root.left, res);
	    serializeHelper(root.right, res);
	}

	public TreeNode deSerialize(List<String> tree) {

	    return null;
	}
    }

    public static void main(String[] args) {
	TreeNode root = new TreeNode(30);
	root.left = new TreeNode(10);
	root.left.left = new TreeNode(50);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(45);
	root.right.right = new TreeNode(35);
	System.out.println(new EncodeDecodeBinaryTrees().new Method().serialize(root));

    }
    /*
     * void writeBinaryTree(BinaryTree *p, ostream &out) { if (!p) { out << "# "
     * ; } else { out << p->data << " "; writeBinaryTree(p->left, out);
     * writeBinaryTree(p->right, out); } }
     * 
     * 
     * 
     * void readBinaryTree(BinaryTree *&p, ifstream &fin) { int token; bool
     * isNumber; if (!readNextToken(token, fin, isNumber)) return; if (isNumber)
     * { p = new BinaryTree(token); readBinaryTree(p->left, fin);
     * readBinaryTree(p->right, fin); } }
     */
}
