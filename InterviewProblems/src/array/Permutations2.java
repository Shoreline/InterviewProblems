package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
    /**
     * Permutations II
     * 
     * Given a collection of numbers that might contain duplicates, return all
     * possible unique permutations.
     * 
     * For example, [1,1,2] have the following unique permutations: [1,1,2],
     * [1,2,1], and [2,1,1].
     */

    /*
     * Similar to Permutation I, only two differences
     */
    public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();

	    if (num == null) {
		return res;
	    }
	    Arrays.sort(num); // sor the array

	    puHelper(num, new boolean[num.length], new ArrayList<Integer>(),
		    res);

	    return res;
	}

	private void puHelper(int[] num, boolean[] occupancy,
		List<Integer> tmpPerm, List<List<Integer>> res) {
	    if (tmpPerm.size() == num.length) {
		List<Integer> perm = new ArrayList<Integer>(tmpPerm);
		res.add(perm);
		return;
	    }

	    for (int i = 0; i < num.length; i++) {
		if (occupancy[i]) {
		    continue;
		}
		/*
		 * *Important* If meet a duplicate, do not use it until its
		 * predecessor has been used -> make sure for a set of duplicate
		 * elements, only one sub-permutation will be used: the first one, the
		 * second one, ... the last one
		 */
		if (i > 0 && num[i] == num[i - 1] && occupancy[i - 1] == false) {
		    continue;
		}

		occupancy[i] = true;
		tmpPerm.add(num[i]);
		puHelper(num, occupancy, tmpPerm, res);

		occupancy[i] = false;
		tmpPerm.remove(tmpPerm.size() - 1);
	    }

	    return;
	}
    }

    /*
     * Alternative: use set, not recommended
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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

    private static void permuteUnique(int[] num, boolean[] occupancy,
	    int amount, int[] temp, HashSet<ArrayList<Integer>> tempResult) {

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
	     * Important: no need to use a separate boolean array, just reset
	     * each element after using it
	     */
	    occupancy[i] = false;

	}

    }

}
