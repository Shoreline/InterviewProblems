package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Combinations {
    /**
     * Combinations
     * 
     * Given two integers n and k, return all possible combinations of k numbers
     * out of 1 ... n.
     * 
     * For example, If n = 4 and k = 2, a solution is:
     * 
     * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
     */

    /*
     * My second solution. Second pass, only one small error!
     * 
     * No duplicate list at all.
     * 
     * We shall notice that candidate elements are from 1 ~ n and without any
     * duplicate!
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	// Key: constraints of recursion
	if (n < 1 || n < k || k < 1)
	    return result;

	if (k == 1) {
	    for (int i = 1; i <= n; i++) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(i);
		result.add(aList);
	    }
	    return result;
	}

	for (int i = n; i > 0; i--) {
	    ArrayList<ArrayList<Integer>> temp = combine(i - 1, k - 1);

	    for (ArrayList<Integer> aList : temp) {
		aList.add(i);
	    }

	    result.addAll(temp);
	}

	return result;
    }

    /*
     * First try.
     * 
     * recursion.
     */
    public static ArrayList<ArrayList<Integer>> combine1(int n, int k) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (n < 1 || k < 1) {
	    return result;
	}
	if (n < k) {
	    return result;
	}
	if (k == 1) {
	    for (int i = 1; i <= n; i++) {
		ArrayList<Integer> aResult = new ArrayList<Integer>();
		aResult.add(i);
		result.add(aResult);
	    }
	    return result;
	}

	for (int i = n; i > 0; i--) {
	    ArrayList<ArrayList<Integer>> temp = combine1(i - 1, k - 1);
	    for (ArrayList<Integer> aResult : temp) {
		aResult.add(i);
	    }
	    result.addAll(temp);
	}

	// get rid of duplicate sets
	LinkedHashSet<ArrayList<Integer>> finalResult = new LinkedHashSet<ArrayList<Integer>>();
	for (ArrayList<Integer> aResult : result) {
	    Collections.sort(aResult);
	    finalResult.add(aResult);
	}
	result = new ArrayList<ArrayList<Integer>>(finalResult);

	return result;
    }

}
