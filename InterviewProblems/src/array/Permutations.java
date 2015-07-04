package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {
    /*
     * DFS + backtracking
     */
    public class Solution {
	public List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
		return res;
	    }
	    dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(int[] nums, boolean[] used, List<Integer> tmp,
		List<List<Integer>> res) {
	    if (tmp.size() == nums.length) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }

	    for (int i = 0; i < nums.length; i++) {
		if (!used[i]) {
		    tmp.add(nums[i]);
		    used[i] = true;
		    dfs(nums, used, tmp, res);
		    tmp.remove(tmp.size() - 1);
		    used[i] = false;
		}
	    }
	}
    }
}
