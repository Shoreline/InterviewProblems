package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
     * third round. similar to second round.
     * 
     * finished in leetcode with a few typos
     */
    public ArrayList<ArrayList<Integer>> permuteUnique3(int[] num) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0)
	    return res;

	Arrays.sort(num);
	boolean[] used = new boolean[num.length];

	permuteUniqueHelp3(num, res, used, new int[num.length], 0);

	return res;
    }

    private static void permuteUniqueHelp3(int[] num,
	    ArrayList<ArrayList<Integer>> res, boolean[] used, int[] temp,
	    int amount) {

	if (amount == num.length) {
	    ArrayList<Integer> aList = new ArrayList<Integer>();
	    for (int i = 0; i < temp.length; i++) {
		aList.add(temp[i]);
	    }
	    res.add(aList);
	    return;
	}

	for (int i = 0; i < num.length; i++) {
	    if (used[i] == true)
		continue;

	    if (i > 0 && num[i] == num[i - 1] && used[i - 1] == false) {
		continue;
	    }

	    temp[amount] = num[i];
	    used[i] = true;
	    amount++;
	    permuteUniqueHelp3(num, res, used, temp, amount);
	    used[i] = false;
	    amount--;
	}

    }

    /*
     * second round
     * 
     * Very similar to Permutation I, only two differences
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0)
	    return result;

	// *Important* sort the array
	Arrays.sort(num);

	boolean[] occupancy = new boolean[num.length];
	int[] temp = new int[num.length];

	permuteUnique2(num, occupancy, 0, temp, result);

	return result;
    }

    private static void permuteUnique2(int[] num, boolean[] occupancy,
	    int amount, int[] temp, ArrayList<ArrayList<Integer>> result) {

	if (amount == num.length) {
	    ArrayList<Integer> aResult = new ArrayList<Integer>();
	    for (int i = 0; i < amount; i++) {
		aResult.add(temp[i]);
	    }
	    result.add(aResult);

	    return;
	}

	for (int i = 0; i < num.length; i++) {
	    if (occupancy[i] == true)
		continue;

	    /*
	     * *Important* If meet a duplicate, do not use it until its
	     * predecessor has been used -> make sure for a set of duplicate
	     * elements, only one permutation is allowed: the first one, the
	     * second one, ... the last one
	     */
	    if (i > 0 && num[i] == num[i - 1] && occupancy[i - 1] == false) {
		continue;
	    }
	    // ================

	    occupancy[i] = true;
	    temp[amount] = num[i];
	    permuteUnique2(num, occupancy, amount + 1, temp, result);
	    occupancy[i] = false;

	}
    }

    /*
     * Alternative: use set, not recommended
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	// Start typing your Java solution below
	// DO NOT write main() function
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

    /*
     * The following solution can only pass the small judge
     * 
     * Large judge exceeded time
     */
    public static ArrayList<ArrayList<Integer>> permute1(int[] num) {
	boolean[] mask = new boolean[num.length];

	for (int i = 0; i < mask.length; i++) {
	    mask[i] = true;
	}

	ArrayList<ArrayList<Integer>> result = permute1(num, mask);

	HashSet<ArrayList<Integer>> finalResult = new HashSet<ArrayList<Integer>>();

	for (ArrayList<Integer> aResult : result) {

	    finalResult.add(aResult);
	}

	result = new ArrayList<ArrayList<Integer>>(finalResult);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> permute1(int[] num,
	    boolean[] mask) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	int counter = 0;
	int firstTrueIdx = -1;
	for (int i = 0; i < mask.length; i++) {
	    if (mask[i] == true)
		counter++;
	    if (counter == 1 && firstTrueIdx == -1) {
		firstTrueIdx = i;
	    }
	}
	if (counter == 1) {
	    ArrayList<Integer> aResult = new ArrayList<Integer>();
	    aResult.add(num[firstTrueIdx]);
	    result.add(aResult);
	    return result;
	}

	for (int i = 0; i < num.length; i++) {
	    if (mask[i] == false) {
		continue;
	    }

	    boolean[] newMask = mask.clone();
	    newMask[i] = false;

	    ArrayList<ArrayList<Integer>> tempResult = permute1(num, newMask);

	    for (ArrayList<Integer> oneResult : tempResult) {
		oneResult.add(num[i]);
	    }

	    result.addAll(tempResult);
	}

	return result;
    }
}
