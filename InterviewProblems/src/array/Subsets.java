package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * non-deterministic polynomial (NP) time complexity
 */
public class Subsets {
    
    /*
     * DFS
     * -same as ninechapter solution
     * Each round, there is N elements in tmp. Two things needs to be done: 
     * 1). add these N elements to res; 
     * 2). call next round of dfs to add N+1 elements
     */
    public class Solution {
	public List<List<Integer>> subsets(int[] S) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (S == null || S.length == 0) {
		return res;
	    }

	    Arrays.sort(S);
	    dfs(S, 0, new ArrayList<Integer>(), res);
	    return res;
	}

	private void dfs(int[] S, int pos, List<Integer> tmp,
		List<List<Integer>> res) {

	    // add N elements in tmp
	    res.add(new ArrayList<Integer>(tmp));

	    // this if block is useless
	    if (pos == S.length) {
		return;
	    }

	    for (int i = pos; i < S.length; i++) {
		tmp.add(S[i]);
		// call next round dfs to add N+1 elements
		dfs(S, i + 1, tmp, res); 
		tmp.remove(tmp.size() - 1);
	    }

	}
    }

    /*
     * to deep copy an ArrayList:
     * 
     * ArrayList<Integer> newList = new ArrayList<Integer>();
     * 
     * newList.addAll(oldList);
     */
    class Solution_old {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    Arrays.sort(S);

	    if (S.length == 0) {
		return result;
	    }

	    result = subsets(S, S.length - 1);

	    return result;
	}

	private ArrayList<ArrayList<Integer>> subsets(int[] S, int startIndex) {
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
}
