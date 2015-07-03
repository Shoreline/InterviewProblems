package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination must be in non-descending order. The solution set must not
 * contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8: A solution set
 * is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */

public class CombinationSumII {
    /*
     * recursion + backtracking
     * 
     * if (i > pos && candidates[i] == candidates[i - 1]) continue;
     */
    public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		} else if (i > pos && candidates[i] == candidates[i - 1]) {
		    continue;
		}
		tmp.add(candidates[i]);
		dfs(candidates, target - candidates[i], i + 1, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    /*
     * Second try
     * 
     * Similar as permuations2, add a boolean array to flag whether an element
     * is used.
     */
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
	    int target) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0 || target <= 0)
	    return result;

	Arrays.sort(num);
	boolean occupaid[] = new boolean[num.length];

	result = combinationSum2(num, target, num.length - 1, occupaid);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
	    int target, int cur, boolean occupaid[]) {

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0 || target <= 0)
	    return result;

	for (int i = cur; i >= 0; i--) {

	    /*
	     * for n repeated elements, anyone of them, num[i] can be used only
	     * if num[i+1] has been used. Cases allowed: any one of these n
	     * elements; any two of these n elements; ... all of these n
	     * elements.
	     * 
	     * This method can assure no duplicate answers. Great for all
	     * permutation questions with duplicate elements
	     */
	    if (i < num.length - 2 && num[i] == num[i + 1] && !occupaid[i + 1])
		continue;

	    if (num[i] > target) {
		continue;
	    } else if (num[i] == target) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(num[i]);
		result.add(aList);
	    } else {
		occupaid[i] = true;
		ArrayList<ArrayList<Integer>> temp = combinationSum2(num,
			target - num[i], i - 1, occupaid);
		occupaid[i] = false;
		for (ArrayList<Integer> aList : temp) {
		    aList.add(num[i]);
		}
		result.addAll(temp);
	    }

	}

	return result;
    }

    /*
     * Recursion
     * 
     * Do not forget: if an element's value equals to the target, add it to
     * result directly, no need to continue recursion with this element
     * 
     * The solution below used additional boolean array to store whether an
     * element is used. Maybe can avoid using it if we implement similar
     * thoughts in Word Search
     */

    public static ArrayList<ArrayList<Integer>> combinationSum1(int[] num,
	    int target) {

	Arrays.sort(num);

	boolean[] occupied = new boolean[num.length];
	for (int i = 0; i < occupied.length; i++) {
	    occupied[i] = true;
	}

	ArrayList<ArrayList<Integer>> result = combinationSum1(num, target,
		occupied);

	// Any better way to get rid of duplicate elements?
	HashSet<ArrayList<Integer>> finalResult = new HashSet<ArrayList<Integer>>();

	for (ArrayList<Integer> aResult : result) {
	    Collections.sort(aResult);
	    finalResult.add(aResult);
	}

	result = new ArrayList<ArrayList<Integer>>(finalResult);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> combinationSum1(int[] num,
	    int target, boolean[] occupied) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	for (int i = 0; i < num.length; i++) {
	    if (occupied[i] == false) {
		continue;
	    } else if (num[i] > target) {
		return result;
	    } else if (num[i] == target) {
		ArrayList<Integer> aResult = new ArrayList<Integer>();
		aResult.add(num[i]);
		result.add(aResult);
	    } else {
		occupied[i] = false;

		ArrayList<ArrayList<Integer>> newResult = combinationSum1(num,
			target - num[i], occupied);
		for (ArrayList<Integer> aResult : newResult) {
		    aResult.add(num[i]);
		}
		result.addAll(newResult);
		occupied[i] = true;
	    }

	}

	return result;
    }

}
