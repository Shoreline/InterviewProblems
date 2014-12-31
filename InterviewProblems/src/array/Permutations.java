package array;

import java.util.ArrayList;

public class Permutations {
    /**
     * Permutations
     * 
     * Given a collection of numbers, return all possible permutations.
     * 
     * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
     * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */

    /*
     * A more concise solution
     * 
     * Similar to generate parenthesis
     */
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0)
	    return result;

	boolean[] occupancy = new boolean[num.length];
	int[] temp = new int[num.length];

	permute(num, occupancy, 0, temp, result);

	return result;
    }

    // Array temp is used to temporally store partial result so far
    private static void permute(int[] num, boolean[] occupancy, int amount,
	    int[] temp, ArrayList<ArrayList<Integer>> result) {

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

	    occupancy[i] = true;
	    temp[amount] = num[i];
	    permute(num, occupancy, amount + 1, temp, result);
	    /*
	     * Important: no need to use a separate boolean array, just reset
	     * each element after using it
	     */
	    occupancy[i] = false;

	}

    }

    // old version
    public static ArrayList<ArrayList<Integer>> permute1(int[] num) {
	boolean[] mask = new boolean[num.length];

	for (int i = 0; i < mask.length; i++) {
	    mask[i] = true;
	}

	ArrayList<ArrayList<Integer>> result = permute1(num, mask);

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
