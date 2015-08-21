package array;

import java.util.*;

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
     * 
     * For N unused digits, there are N! permutations in total. Chose the
     * r-largest digit in them as the next digit of result, then all
     * (r-1)*(N-1)! possibilities will be surely smaller than the final number
     * 
     * k-th permutation, means there are (k-1) permutations smaller than it. So
     * rank = (k-1)/f
     */
    public class Solution {
	public String getPermutation(int n, int k) {
	    StringBuilder result = new StringBuilder();
	    List<Integer> unUsed = new ArrayList<Integer>();
	    int f = 1;
	    for (int i = 1; i <= n; i++) {
		unUsed.add(i);
		f *= i;
	    }

	    while (!unUsed.isEmpty()) {
		// let f = (len-1)!, which is the # of combos for len-1 digits
		f = f / unUsed.size();
		// index is guaranteed between [0, len-1]

		int rank = (k - 1) / f;
		result.append(unUsed.get(rank));
		k -= rank * f;
		unUsed.remove(rank);
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
