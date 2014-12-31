package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SubSetsCUE {

    // completion code: 1260-17416-83402

    public static ArrayList<ArrayList<Integer>> getSets(int[] input) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	HashMap<Integer, ArrayList<ArrayList<Integer>>> record = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();

	Arrays.sort(input);

	for (int i = 0; i < input.length; i++) {
	    int[] aSubArray = getNewSubArray(input, i);
	    ArrayList<ArrayList<Integer>> haha = getSets(aSubArray, input[i]);
	    if (haha != null) {
		for (ArrayList<Integer> aList : haha) {
		    ArrayList<Integer> aNewList = new ArrayList<Integer>();
		    aNewList.addAll(aList);
		    aNewList.add(input[i]);
		    result.add(aNewList);
		}
	    }
	}

	HashSet<ArrayList<Integer>> result2 = new HashSet<ArrayList<Integer>>();
	for (ArrayList<Integer> aList : result) {
	    Collections.sort(aList);
	    result2.add(aList);
	    // aList.add(sum);
	}
	result = new ArrayList<ArrayList<Integer>>(result2);

	return result;
    }

    public static ArrayList<ArrayList<Integer>> getSets(int[] input, int target) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (input.length == 1) {
	    if (input[0] == target) {
		ArrayList<Integer> aResult = new ArrayList<Integer>();
		aResult.add(target);
		result.add(aResult);
	    } else {
		return null;
	    }
	}

	for (int i = 0; i < input.length; i++) {
	    if (target - input[i] < 0) {
		continue;
	    }
	    int[] aSubArray = getNewSubArray2(input, i);

	    ArrayList<ArrayList<Integer>> haha = getSets(aSubArray, target
		    - input[i]);

	    if (target == input[i]) {
		ArrayList<Integer> aNewList = new ArrayList<Integer>();
		aNewList.add(input[i]);
		result.add(aNewList);
	    }

	    if (haha != null) {
		for (ArrayList<Integer> aList : haha) {
		    ArrayList<Integer> aNewList = new ArrayList<Integer>();
		    aNewList.addAll(aList);
		    aNewList.add(input[i]);
		    result.add(aNewList);
		}
	    }

	}

	return result;

    }

    private static int[] getNewSubArray(int[] in, int index) {
	int[] out = new int[index];

	for (int i = 0; i < index; i++) {
	    out[i] = in[i];

	}
	return out;
    }

    private static int[] getNewSubArray2(int[] in, int index) {
	int[] out = new int[in.length - 1];
	int j = 0;
	for (int i = 0; i < in.length; i++) {
	    if (i == index) {
		continue;
	    }
	    out[j] = in[i];
	    j++;
	}
	return out;
    }
}
