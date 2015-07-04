package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 */

public class Permutations2 {
    /*
     * Similar to permutations I, jus two differences
     */
    public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
		return res;
	    }

	    Arrays.sort(nums); // sort the array
	    dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(int[] nums, boolean[] used, List<Integer> tmp,
		List<List<Integer>> res) {
	    if (tmp.size() == nums.length) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }

	    /*
	     * *Important* If meet a duplicate, do not use it until its
	     * predecessor has been used -> make sure for a set of duplicate
	     * elements, only one sub-permutation will be used: the first one,
	     * the second one, ... the last one
	     */
	    for (int i = 0; i < nums.length; i++) {
		if (used[i]
			|| (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
		    continue;
		}
		used[i] = true;
		tmp.add(nums[i]);
		dfs(nums, used, tmp, res);
		tmp.remove(tmp.size() - 1);
		used[i] = false;
	    }
	}
    }

    /*
     * Alternative: use set, not recommended
     */
    class Solution_set {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    HashSet<ArrayList<Integer>> tempResult = new HashSet<ArrayList<Integer>>();

	    if (num == null || num.length == 0)
		return result;

	    boolean[] occupancy = new boolean[num.length];
	    int[] temp = new int[num.length];

	    permuteUnique(num, occupancy, 0, temp, tempResult);

	    result = new ArrayList<ArrayList<Integer>>(tempResult);

	    return result;
	}

	private void permuteUnique(int[] num, boolean[] occupancy, int amount,
		int[] temp, HashSet<ArrayList<Integer>> tempResult) {

	    if (amount == num.length) {
		ArrayList<Integer> aResult = new ArrayList<Integer>();
		for (int i = 0; i < amount; i++) {

		    aResult.add(temp[i]);
		}
		tempResult.add(aResult);

		return;
	    }

	    for (int i = 0; i < num.length; i++) {
		if (occupancy[i] == true)
		    continue;

		occupancy[i] = true;
		temp[amount] = num[i];
		permuteUnique(num, occupancy, amount + 1, temp, tempResult);
		/*
		 * Important: no need to use a separate boolean array, just
		 * reset each element after using it
		 */
		occupancy[i] = false;
	    }
	}
    }

}
