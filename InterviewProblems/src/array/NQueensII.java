package array;

/**
 * N-Queens II 
 * 
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 *
 */

/*
 * Almost the same as N-Queens I
 */
public class NQueensII {
    public class Solution {
	int res = 0; // may have better way

	public int totalNQueens(int n) {
	    dfsHelper(n, 0, new int[n]);	    
	    return res;
	}

	private void dfsHelper(int n, int amount, int[] pos) {
	    if (amount == n) {
		res++;
		return;
	    }

	    for (int i = 0; i < n; i++) {
		pos[amount] = i;
		if (isValid(amount, pos)) {
		    dfsHelper(n, amount + 1, pos);
		}
	    }
	}

	private boolean isValid(int amount, int[] pos) {
	    for (int i = 0; i < amount; i++) {
		if (pos[i] == pos[amount]
			|| Math.abs(i - amount) == Math.abs(pos[i]
				- pos[amount])) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
