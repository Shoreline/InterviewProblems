package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (n > 45) {
		return res;
	    }

	    dfs(k, n, 1, 0, new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(int k, int n, int pos, int sum, List<Integer> tmp,
		List<List<Integer>> res) {
	    if (sum == n && tmp.size() == k) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }

	    for (int i = pos; i <= 9; i++) {
		if (sum + pos > n || tmp.size() == k) {
		    break;
		}

		tmp.add(i);
		dfs(k, n, i + 1, sum + i, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }

	}
    }
}
