package tree;

/**
 * Unique Binary Search Trees
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 */

/*
 * 1. Any node can be the root of a BST. Just make sure the rest nodes follow
 * the BST rule
 * 
 * 2. Since nodes of this problem is from 1 ~ n. The possible node number of
 * left tree is from 0 to n-1, say k. And meanwhile the possible node number of
 * the right tree will be n-1-k (n-1 -k: minus the root, then minus the node
 * count in left tree )
 * 
 * Same as computing Catalan number
 */

public class UniqueBinarySearchTrees {
    /*
     * DP
     * 
     * Time: O(N^2); Space: O(N)
     * 
     * 1D array, but two nested loops
     * 
     * dp[i]: use how many nodes. from 0 ~ n
     */
    public class Solution {
	public int numTrees(int n) {
	    if (n < 0) {
		return 0;
	    }

	    int[] dp = new int[n + 1];
	    dp[0] = 1; // important!
	    dp[1] = 1;

	    for (int i = 2; i <= n; i++) {
		for (int k = 0; k < i; k++) {
		    dp[i] += dp[k] * dp[i - 1 - k];
		}
	    }

	    return dp[n];
	}
    }

    /*
     * Simple recursion: Time limit exceeded
     */
    class method_recursion {
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
}
