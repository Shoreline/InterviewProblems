package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    /**
     * Given a set of distinct integers, S, return all possible subsets.
     * 
     * Note: Elements in a subset must be in non-descending order. The solution
     * set must not contain duplicate subsets. For example, If S = [1,2,3], a
     * solution is:
     * 
     * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
     */

    /*
     * to deep copy an ArrayList:
     * 
     * ArrayList<Integer> newList = new ArrayList<Integer>();
     * 
     * newList.addAll(oldList);
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	Arrays.sort(S);

	if (S.length == 0) {
	    return result;
	}

	result = subsets(S, S.length - 1);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> subsets(int[] S, int startIndex) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (startIndex < 0) {
	    ArrayList<Integer> newList = new ArrayList<Integer>();
	    result.add(newList);
	    return result;
	}

	ArrayList<ArrayList<Integer>> temp = subsets(S, startIndex - 1);

	result.addAll(temp);

	for (ArrayList<Integer> aList : temp) {
	    ArrayList<Integer> newList = new ArrayList<Integer>();
	    newList.addAll(aList);
	    newList.add(S[startIndex]);
	    result.add(newList);
	}

	return result;
    }
}
