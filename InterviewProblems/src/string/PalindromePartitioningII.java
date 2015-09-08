package string;

import java.util.Arrays;

/**
 * Palindrome Partitioning II
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioningII {
    /*
     * Two DPs
     * 
     * http://www.cnblogs.com/yuzhangcmu/p/4148892.html
     * 
     * minPieces[i]: the minimum amount of palindrome pieces for the first i
     * characters of s
     * 
     * Return minPieces[s.length()] -1 !
     */
    public class Solution_me {
	public int minCut(String s) {
	    if (s == null || s.length() == 0) {
		return 0;
	    }

	    boolean[][] isPal = isPalindrome(s);

	    int[] minPieces = new int[s.length() + 1];
	    Arrays.fill(minPieces, Integer.MAX_VALUE);
	    minPieces[0] = 0;

	    // "i" means the first-i characters
	    for (int i = 1; i <= s.length(); i++) {
		for (int j = 0; j < i; j++) {
		    // "i-1" is the index of the i-th characters
		    if (minPieces[j] < Integer.MAX_VALUE && isPal[j][i - 1]) {
			minPieces[i] = Math.min(minPieces[i], 1 + minPieces[j]);
		    }
		}
	    }

	    return minPieces[s.length()] - 1;
	}

	private boolean[][] isPalindrome(String s) {
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for (int i = s.length() - 1; i >= 0; i--) {
		for (int j = i; j < s.length(); j++) {
		    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
		}
	    }
	    return dp;
	}
    }

    public class Solution {
	public int minCut(String s) {
	    if (s == null) {
		return 0;
	    }

	    /*
	     * whether s.substring() is a palindrome. this dp array does not
	     * need initialization isPalindrome[i][j]: s.substring(i,j) is
	     * palindrome or not
	     */
	    boolean[][] isPalindrome = new boolean[s.length()][s.length()];

	    int[] minCut = new int[s.length() + 1];
	    minCut[0] = -1;

	    for (int i = 1; i <= s.length(); i++) {
		minCut[i] = Integer.MAX_VALUE;
		/*
		 * must start from 0, otherwise isPalindrome[][] cannot be
		 * properly filled
		 */
		for (int j = 0; j < i; j++) {
		    if (s.charAt(j) == s.charAt(i - 1) && (i - 1 - j <= 2 || isPalindrome[j + 1][i - 2])) {
			isPalindrome[j][i - 1] = true;
			minCut[i] = Math.min(minCut[i], minCut[j] + 1);
		    }

		}

	    }

	    return minCut[s.length()];
	}

    }

    /*
     * Double DPs, failed to construct isPalindrome[][] efficiently
     * 
     * TLE
     */
    public class Attempt_DP {
	public int minCut(String s) {
	    if (s == null || isPalindrome(s)) {
		return 0;
	    }

	    boolean[][] isPalindrome = new boolean[s.length()][s.length() + 1];
	    for (int i = 0; i < s.length(); i++) {
		for (int j = i + 1; j <= s.length(); j++) {
		    isPalindrome[i][j] = isPalindrome(s.substring(i, j));
		}
	    }

	    int[] dp = new int[s.length() + 1];
	    dp[0] = 0;

	    for (int i = 1; i <= s.length(); i++) {
		int iMinCut = Integer.MAX_VALUE;
		for (int j = i - 1; j >= 0; j--) {

		    if (isPalindrome[j][i]) {
			iMinCut = Math.min(iMinCut, dp[j] + 1);
		    }
		}
		dp[i] = iMinCut;
	    }

	    return dp[s.length()];
	}

	private boolean isPalindrome(String s) {
	    int front = 0;
	    int back = s.length() - 1;
	    while (front < back) {
		if (s.charAt(front) != s.charAt(back)) {
		    return false;
		}
		front++;
		back--;
	    }

	    return true;
	}
    }
}
