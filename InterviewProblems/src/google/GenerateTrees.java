package google;

import java.util.*;

import tree.TreeNode;

/**
 * given number N which represents total number of leaves in tree. you need to
 * generate all possible tree, such that each node in tree has zero child or two
 * children. The return type should be a list of such kind of trees. Only tree
 * structure matters, tree node doesn't have any value initially.
 * 
 * My solution: N = 1 and N = 2 are base cases
 * 
 * For example, N = 3.
 * 
 * 
              1                1
           /    \            /   \
          1     1         1     1
        / \                    /  \
        1  1                  1   1
 * 
 * For N = 4, all possible trees can be generated from f(3) by attaching each
 * leaf node with two children, recursively follow this pattern to return target
 * N. (Note: f(3) indicates a list of trees with 3 nodes in structure described
 * above)
 *
 */

/*
 * My thought: the base case is n = 1. 
 */
public class GenerateTrees {
    class Method {

	public List<TreeNode> genTrees(int n) {
	    List<TreeNode> res = new ArrayList<>();

	    if (n == 1) {
		res.add(new TreeNode(1));
		return res;
	    }   
	    
	    Set<String> existings = new HashSet<>();

	    for (TreeNode root : genTrees(n - 1)) {

		List<TreeNode> leaves = new ArrayList<>();
		getLeaves(root, leaves);

		for (TreeNode leaf : leaves) {
		    leaf.left = new TreeNode(1);
		    leaf.right = new TreeNode(1);
		    String encoded = serialize(root);
		    if (!existings.contains(encoded)) {
			existings.add(encoded);
			res.add(clone(root));
		    }
		    leaf.left = null;
		    leaf.right = null;
		}

	    }

	    return res;
	}

	private void getLeaves(TreeNode root, List<TreeNode> leaves) {

	}

	private String serialize(TreeNode root) {
	    return null;
	}

	private TreeNode clone(TreeNode root) {
	    return null;
	}
    }
}
