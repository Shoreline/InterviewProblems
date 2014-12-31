package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
    /**
     * Combination Sum
     * 
     * Given a set of candidate numbers (C) and a target number (T), find all
     * unique combinations in C where the candidate numbers sums to T.
     * 
     * The same repeated number may be chosen from C unlimited number of times.
     * 
     * Note: All numbers (including target) will be positive integers. Elements
     * in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie,
     * a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak). The solution set must not contain duplicate
     * combinations. For example, given candidate set 2,3,6,7 and target 7, A
     * solution set is: [7] [2, 2, 3]
     */

    /*
     * Second try. Third time pass.
     * 
     * This solution (and the test cases in leetcode) assume all elements in
     * candidate array is unique.
     * 
     * Any way to use the two pointer algorithm in two sum?
     */
    public static ArrayList<ArrayList<Integer>> combinationSum(
	    int[] candidates, int target) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (candidates == null || candidates.length == 0 || target <= 0) {
	    return result;
	}
	// do not forget to sort candidates array first
	Arrays.sort(candidates);
	result = combinationSum(candidates, target, candidates.length - 1);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(
	    int[] candidates, int target, int cur) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (candidates == null || candidates.length == 0 || target <= 0) {
	    return result;
	}

	/*
	 * To avoid duplicates, the key is to pass down current maximum allowed
	 * index
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

    public static ArrayList<ArrayList<Integer>> combinationSum1(
	    int[] candidates, int target) {

	Arrays.sort(candidates); // probably not necessary here

	ArrayList<ArrayList<Integer>> result = combinationSum1help(candidates,
		target);

	HashSet<ArrayList<Integer>> finalResult = new HashSet<ArrayList<Integer>>();

	for (ArrayList<Integer> aResult : result) {
	    Collections.sort(aResult);
	    finalResult.add(aResult);
	}

	result = new ArrayList<ArrayList<Integer>>(finalResult);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> combinationSum1help(
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
