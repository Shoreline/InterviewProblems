package array;

import java.util.ArrayList;

/**
 * Permutation Sequence
 * 
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence {
    /*
     * Time: O(N^2). The remove() of an arrayList costs O(N)
     */
    public class Solution {
	public String getPermutation(int n, int k) {
	    if (n < 1)
		return "";

	    StringBuilder result = new StringBuilder();
	    ArrayList<Integer> numList = new ArrayList<Integer>();
	    int f = 1;
	    for (int i = 1; i <= n; i++) {
		numList.add(i);
		f *= i;
	    }
	    if (k > f) {
		return "";
	    }

	    while (!numList.isEmpty()) {
		int len = numList.size();
		
		// let f = (len-1)!, which is the combination possiblity for len-1 number
		f = f / len; 		
		// index is a guranteed between [0, len-1]
		int index = (k - 1) / f;
		
		result.append(numList.get(index));

		k -= index * f;
		numList.remove(index);
	    }

	    return result.toString();
	}
    }

    /*
     * Java has not build-in factorial function??
     */

    public static String getPermutation(int n, int k) {
	if (n < 1)
	    return "";

	StringBuilder result = new StringBuilder();
	ArrayList<Integer> numList = new ArrayList<Integer>();
	for (int i = 1; i <= n; i++) {
	    numList.add(i);
	}

	while (!numList.isEmpty()) {
	    int len = numList.size();
	    int index = (k - 1) / factorial(len - 1);
	    k = k - index * factorial(len - 1);

	    result.append(numList.get(index));
	    numList.remove(index);
	}

	return result.toString();
    }

    // first round
    public static String getPermutation1(int n, int k) {

	ArrayList<Integer> result = new ArrayList<Integer>();

	ArrayList<Integer> numList = new ArrayList<Integer>();
	for (int i = 1; i <= n; i++) {
	    numList.add(i);
	}

	for (int i = 1; i <= n; i++) {
	    if (k == 1) {
		result.addAll(numList);
		break;
	    }

	    int temp = factorial(n - i);

	    /*
	     * use k-1 because k do not start with 0, but 1
	     */
	    int p = (k - 1) / temp; // very easy to make mistake!!

	    result.add(numList.get(p));
	    numList.remove(p);
	    k = k - p * temp;// very easy to make mistake!!
	}

	StringBuilder haha = new StringBuilder();
	for (Integer aDigit : result) {
	    haha.append(aDigit);
	}

	return haha.toString();
    }

    private static int factorial(int x) {
	int fact = 1;
	for (int i = 2; i <= x; i++) {
	    fact *= i;
	}
	return fact;
    }

}
