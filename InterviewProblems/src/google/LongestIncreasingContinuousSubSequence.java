package google;

/**
 * Longest Increasing Continuous subsequence
 * 
 * 26% Accepted Give you an integer array (index from 0 to n-1, where n is the
 * size of this array)，find the longest increasing continuous subsequence in
 * this array. (The definition of the longest increasing continuous subsequence
 * here can be from right to left or from left to right)
 * 
 * Example For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * 
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * 
 * Note O(n) time and O(1) extra space.
 *
 */
public class LongestIncreasingContinuousSubSequence {
    /*
     * My simple solution. Just find the longest descending sequence and longest
     * ascencding sequence and compare their length
     * 
     */
    public class Solution {
	public int longestIncreasingContinuousSubsequence(int[] A) {
	    if (A == null || A.length == 0) {
		return 0;
	    }

	    int res = 1;

	    int i = 0;
	    while (i < A.length) {
		int j = i + 1;
		while (j < A.length && A[j] > A[j - 1]) {
		    j++;
		}
		res = Math.max(res, j - i);
		i = j;
	    }

	    i = A.length - 1;
	    while (i >= 0) {
		int j = i - 1;
		while (j >= 0 && A[j] > A[j + 1]) {
		    j--;
		}
		res = Math.max(res, i - j);
		i = j;
	    }

	    return res;
	}
    }

    public class Solution_DP {
	public int longestIncreasingContinuousSubsequence(int[] A) {
	    int res = 0;
	    if (A == null || A.length == 0) {
		return res;
	    }
	    boolean fromLeft = true;
	    int start = 0;
	    res = 1;
	    for (int i = 1; i < A.length; i++) {
		if (A[i] > A[i - 1]) {
		    if (fromLeft == true) {
			res = Math.max(res, i - start + 1);
		    } else {
			start = i - 1;
			fromLeft = true;
		    }
		} else if (A[i] < A[i - 1]) {
		    if (fromLeft == false) {
			res = Math.max(res, i - start + 1);
		    } else {
			start = i - 1;
			fromLeft = false;
		    }
		}
	    }
	    return res;
	}
    }
}
