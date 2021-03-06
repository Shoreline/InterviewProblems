package array;

import java.util.ArrayList;
import java.util.List;

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
	public int totalNQueens(int n) {
	    if (n < 1) {
		return 0;
	    }
	    List<Integer> res = new ArrayList<>();
	    res.add(0);
	    dfs(n, 0, new int[n], res);

	    return res.get(0);
	}

	private void dfs(int n, int count, int[] queens, List<Integer> res) {
	    if (count == n) {
		res.set(0, res.get(0) + 1);
		return;
	    }

	    for (int i = 0; i < n; i++) {
		queens[count] = i;
		if (isValid(count, queens)) {
		    dfs(n, count + 1, queens, res);
		}
	    }
	}

	private boolean isValid(int count, int[] queens) {
	    for (int i = 0; i < count; i++) {
		if (queens[i] == queens[count]
			|| Math.abs(queens[i] - queens[count]) == Math.abs(i
				- count)) {
		    return false;
		}
	    }

	    return true;
	}

    }

    public class Solution2 {
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
