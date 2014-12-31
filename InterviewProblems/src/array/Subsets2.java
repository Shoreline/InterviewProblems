package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
    /**
     * Given a collection of integers that might contain duplicates, S, return
     * all possible subsets.
     * 
     * Note: Elements in a subset must be in non-descending order. The solution
     * set must not contain duplicate subsets. For example, If S = [1,2,2], a
     * solution is:
     * 
     * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
     */

    /*
     * The hard part is, we are not allowed to use Set which can automatically
     * eliminate duplicate cases
     * 
     * Trick: For an element E that is identical with previous element E': find
     * out which ArrayLists got added E' last round (no matter E' is a duplicate
     * one), then only add E to these lists
     */

    static int newListNum = 0;

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	Arrays.sort(num);

	ArrayList<ArrayList<Integer>> result = subsetsWithDup(num,
		num.length - 1);

	return result;
    }

    private static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num,
	    int startIndex) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (startIndex < 0) {
	    ArrayList<Integer> emptyList = new ArrayList<Integer>();
	    result.add(emptyList);
	    newListNum = 1;
	    return result;
	}

	ArrayList<ArrayList<Integer>> temp = subsetsWithDup(num, startIndex - 1);
	result.addAll(temp);

	if (startIndex > 0 && num[startIndex] == num[startIndex - 1]) {
	    // only deal with the new elements just added last time
	    for (int i = newListNum - 1; i >= 0; i--) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.addAll(temp.get(temp.size() - 1 - i));
		newList.add(num[startIndex]);
		result.add(newList);
	    }

	} else {
	    for (ArrayList<Integer> aList : temp) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.addAll(aList);
		newList.add(num[startIndex]);
		result.add(newList);
	    }
	    newListNum = temp.size();
	}

	return result;
    }
}
