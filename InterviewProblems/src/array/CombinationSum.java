package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Combination Sum
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination must be in non-descending order.
 * 
 * The solution set must not contain duplicate combinations. For example, given
 * candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 */
public class CombinationSum {
    /*
     * DFS + backtracking
     * 
     * * Without the else if block the code can still pass leetcode OJ, which
     * shall not happen!
     */
    public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (candidates == null || candidates.length == 0) {
		return res;
	    }

	    Arrays.sort(candidates);

	    dfs(candidates, target, 0, new ArrayList<Integer>(), res);

	    return res;
	}

	private void dfs(int[] candidates, int target, int pos,
		List<Integer> tmp, List<List<Integer>> res) {
	    if (target == 0) {
		res.add(new ArrayList<Integer>(tmp));
		return;
	    }

	    for (int i = pos; i < candidates.length; i++) {
		if (candidates[i] > target) {
		    break;
		} else if (i > 0 && candidates[i] == candidates[i - 1]) {
		    continue;
		}
		tmp.add(candidates[i]);
		dfs(candidates, target - candidates[i], i, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public class Solution_old {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();

	    if (candidates == null || candidates.length == 0) {
		return res;
	    }

	    Arrays.sort(candidates);

	    List<Integer> tmp = new ArrayList<Integer>();
	    Set<List<Integer>> resSet = new HashSet<List<Integer>>();
	    combinationSumHelper(candidates, target, tmp, resSet);

	    res.addAll(resSet);
	    return res;
	}

	private void combinationSumHelper(int[] candidates, int target,
		List<Integer> tmp, Set<List<Integer>> res) {
	    if (target == 0) {
		List<Integer> solution = new ArrayList<Integer>(tmp);
		Collections.sort(solution);
		res.add(solution);
		return;
	    }

	    for (int i = 0; i < candidates.length; i++) {
		if (i > 1 && candidates[i] == candidates[i - 1]) {
		    continue;
		} else if (candidates[i] > target) {
		    break;
		} else {
		    tmp.add(candidates[i]);
		    combinationSumHelper(candidates, target - candidates[i],
			    tmp, res);
		    tmp.remove(tmp.size() - 1);
		}
	    }

	    return;
	}
    }

    class Solution2013 {
	/*
	 * Second try. Third time pass.
	 * 
	 * This solution (and the test cases in leetcode) assume all elements in
	 * candidate array is unique.
	 * 
	 * Any way to use the two pointer algorithm in two sum?
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
		int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    if (candidates == null || candidates.length == 0 || target <= 0) {
		return result;
	    }
	    // do not forget to sort candidates array first
	    Arrays.sort(candidates);
	    result = combinationSum(candidates, target, candidates.length - 1);

	    return result;
	}

	private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
		int target, int cur) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    if (candidates == null || candidates.length == 0 || target <= 0) {
		return result;
	    }

	    /*
	     * To avoid duplicates, the key is to pass down current maximum
	     * allowed index
	     */
	    for (int i = cur; i >= 0; i--) {

		if (candidates[i] > target)
		    continue;

		if (candidates[i] == target) {
		    ArrayList<Integer> aList = new ArrayList<Integer>();
		    aList.add(candidates[i]);
		    result.add(aList);
		    continue;
		}

		ArrayList<ArrayList<Integer>> temp = combinationSum(candidates,
			target - candidates[i], i);
		for (ArrayList<Integer> aList : temp) {
		    aList.add(candidates[i]);
		}
		result.addAll(temp);
	    }

	    return result;
	}

	/*
	 * classic recursion.
	 */

	public ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates,
		int target) {

	    Arrays.sort(candidates); // probably not necessary here

	    ArrayList<ArrayList<Integer>> result = combinationSum1help(
		    candidates, target);

	    HashSet<ArrayList<Integer>> finalResult = new HashSet<ArrayList<Integer>>();

	    for (ArrayList<Integer> aResult : result) {
		Collections.sort(aResult);
		finalResult.add(aResult);
	    }

	    result = new ArrayList<ArrayList<Integer>>(finalResult);

	    return result;
	}

	private ArrayList<ArrayList<Integer>> combinationSum1help(
		int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    for (int i = 0; i < candidates.length; i++) {
		if (candidates[i] > target) {
		    continue;
		}
		if (candidates[i] == target) {
		    ArrayList<Integer> aResult = new ArrayList<Integer>();
		    aResult.add(target);
		    result.add(aResult);
		}

		ArrayList<ArrayList<Integer>> newResult = combinationSum1help(
			candidates, target - candidates[i]);

		for (ArrayList<Integer> aResult : newResult) {
		    aResult.add(candidates[i]);
		}

		result.addAll(newResult);

	    }

	    return result;
	}
    }
}
