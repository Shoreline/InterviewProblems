package linkedin;

import java.util.*;

public class FactorCombinations {
    public class Solution {
	public List<List<Integer>> getFactors(int n) {
	    if (n == 1) {
		return new ArrayList<List<Integer>>();
	    }
	    return dfs(n, n - 1);
	}

	private List<List<Integer>> dfs(int n, int limit) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (n == 1) {
		res.add(new ArrayList<Integer>());
		return res;
	    }

	    for (int i = limit; i >= 2; i--) {
		if (n % i == 0) {
		    List<List<Integer>> rest = dfs(n / i, i);
		    for (List<Integer> ans : rest) {
			ans.add(i);
			res.add(ans);
		    }
		}
	    }

	    return res;
	}
    }

    public class Solution2 {
	public List<List<Integer>> getFactors(int n) {
	    return dfs(n, n - 1);
	}

	private List<List<Integer>> dfs(int n, int limit) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (n == 1 && limit > 0) {
		res.add(new ArrayList<Integer>());
		return res;
	    }

	    for (int i = limit; i >= 2; i--) {
		if (n % i == 0) {
		    List<List<Integer>> rest = dfs(n / i, i);
		    for (List<Integer> ans : rest) {
			ans.add(i);
			res.add(ans);
		    }
		}
	    }

	    return res;
	}
    }
}
