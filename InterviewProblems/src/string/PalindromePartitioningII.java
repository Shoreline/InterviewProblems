package string;

public class PalindromePartitioningII {

    /*
     * Two DPs
     * 
     * http://www.cnblogs.com/yuzhangcmu/p/4148892.html
     * 
     * 
     */
    public class Solution {
	public int minCut(String s) {
	    if (s == null) {
		return 0;
	    }

	    /*
	     * whether s.substring() is a palindrome. this dp array does not
	     * need initialization
	     * isPalindrome[i][j]: s.substring(i,j) is palindrome or not
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
		    if (s.charAt(j) == s.charAt(i - 1)
			    && (i - 1 - j <= 2 || isPalindrome[j + 1][i - 2])) {
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
