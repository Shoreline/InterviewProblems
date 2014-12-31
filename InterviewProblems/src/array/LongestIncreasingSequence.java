package array;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestIncreasingSequence {

    /*
     * O(n^2) method. Not good.
     */
    public static ArrayList<Integer> getLISbad(int[] A) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	if (A == null || A.length == 0)
	    return result;

	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	HashSet<Integer> biggestElement = new HashSet<Integer>();

	for (int i = 0; i < A.length; i++) {

	    ArrayList<ArrayList<Integer>> tempLists = new ArrayList<ArrayList<Integer>>();

	    for (ArrayList<Integer> aList : lists) {

		if (aList.get(aList.size() - 1) <= A[i]) {
		    // if (!temp.containsKey(aList.get(0))) {
		    // temp.put(aList.get(0), aList);
		    // } else {
		    //
		    // }

		    ArrayList<Integer> newList = new ArrayList<Integer>(aList);
		    newList.add(A[i]);
		    biggestElement.add(A[i]);
		    tempLists.add(newList);
		}
	    }

	    lists.addAll(tempLists);

	    if (!biggestElement.contains(A[i])) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(A[i]);
		lists.add(aList);
	    }
	}

	for (ArrayList<Integer> aList : lists) {
	    if (aList.size() > result.size())
		result = aList;
	}

	return result;
    }

    /*
     * O(n^2). Only return the size of the LIS
     */
    public static int getLISLength(int[] A) {

	if (A == null || A.length == 0)
	    return 0;

	int[] dp = new int[A.length];
	dp[0] = 1;

	/*
	 * dp[i] indicates: the length of the LIS for A[0] ... A[i] that ends
	 * with A[i]
	 */
	for (int i = 1; i < A.length; i++) {
	    int max = 0;
	    for (int j = 0; j < i; j++) {
		if (A[j] < A[i])
		    max = Math.max(max, dp[j]);
	    }
	    /*
	     * The minimum possible value of max is 0. In this case dp[i] will
	     * be 1, means that this element itself is a increasing sequence
	     */
	    dp[i] = max + 1;

	}

	int ans = 0;
	for (int i = 0; i < A.length; i++)
	    ans = Math.max(ans, dp[i]);
	return ans;

    }

    /*
     * O(n^2). Return the actual LIS
     */
    public static ArrayList<Integer> getLIS(int[] A) {

	ArrayList<Integer> result = new ArrayList<Integer>();
	if (A == null || A.length == 0)
	    return result;

	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	int[] dp = new int[A.length];
	dp[0] = 1;
	ArrayList<Integer> initialList = new ArrayList<Integer>();
	initialList.add(A[0]);
	lists.add(initialList);

	/*
	 * dp[i] indicates: the length of the LIS for A[0] ... A[i] that ends
	 * with A[i]
	 */
	for (int i = 1; i < A.length; i++) {
	    int max = 0;
	    ArrayList<Integer> aList = new ArrayList<Integer>();

	    for (int j = 0; j < i; j++) {
		if (A[j] < A[i]) {
		    max = Math.max(max, dp[j]);
		    if (lists.get(j).size() > aList.size())
			aList = new ArrayList<Integer>(lists.get(j));
		}
	    }
	    /*
	     * The minimum possible value of max is 0. In this case dp[i] will
	     * be 1, means that this element itself is a increasing sequence
	     */
	    dp[i] = max + 1;
	    aList.add(A[i]);
	    lists.add(aList);

	}

	int ans = 0;
	for (int i = 0; i < A.length; i++) {
	    if (dp[ans] < dp[i])
		ans = i;
	}
	result = lists.get(ans);
	return result;

    }
    /*
     * O(nlgn) method
     */
}
