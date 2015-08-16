package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 */

/*
 * Note: there must be exactly k numbers in a solution set
 */
public class CombinationSumIII {
    public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    dfs(k, n, 1, new ArrayList<Integer>(), res);
	    return res;
	}

	private void dfs(int k, int n, int pos, List<Integer> tmp, List<List<Integer>> res) {
	    if (n == 0 && tmp.size() == k) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    } else if (n < 0 || tmp.size() >= k) {
		return;
	    }

	    for (int i = pos; i <= 9; i++) {
		tmp.add(i);
		dfs(k, n - i, i + 1, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public class Solution2 {
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();

	    if (k < 1 || n < 1) {
		return res;
	    }

	    dfs(k, 1, n, new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(int k, int min, int target, List<Integer> tmp, List<List<Integer>> res) {
	    if (target == 0 && tmp.size() == k) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }
	    if (tmp.size() == k || min > target) {
		return;
	    }

	    for (int i = min; i <= 9; i++) {
		tmp.add(i);
		dfs(k, i + 1, target - i, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }
}
