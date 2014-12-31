package tree;

public class UniqueBinarySearchTrees {

    /**
     * Unique Binary Search Trees
     * 
     * Given n, how many structurally unique BST's (binary search trees) that
     * store values 1...n?
     * 
     * For example, Given n = 3, there are a total of 5 unique BST's.
     */

    /*
     * The same is equivalent to: given n nodes, how many unique BSTs can be
     * constructed. --> N distinct Integers/values can be stored by a n-node BST
     * of any structure
     * 
     * Catalan number.
     * 
     * Simple recursion.
     */

    public int numTrees(int n) {
	int result = 0;
	if (n < 0)
	    return 0;

	if (n <= 1)
	    return 1;

	for (int i = 0; i < n; i++) {
	    // the 1 of "n-1-i" indicates the root
	    result += numTrees(i) * numTrees(n - 1 - i);
	}

	return result;
    }
}
