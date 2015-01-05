package array;

public class LongestPalindromicSubstring {
    /**
     * Longest Palindromic Substring
     * 
     * Given a string S, find the longest palindromic substring in S.
     * 
     * You may assume there exists one unique longest palindromic substring.
     */

    /*
     * My solution can pass the large set. O(n^2)
     * 
     * but any dp solution? yes! and it takes only o(n)!
     * 
     * link: http://www.felix021.com/blog/read.php?2040
     */

    /*
     *  Same idea as solution 2.
     *  A little optimization: while n == s.length(), can break the loop and return res.
     */
    public String longestPalindrome3(String s) {
	if (s == null || s.length() < 2) {
	    return s;
	}

	String res = "";

	for (int i = 0; i < s.length(); i++) {
	    if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
		continue;
	    }

	    int m = i;
	    int n = i;

	    while (n + 1 < s.length() && s.charAt(n + 1) == s.charAt(n)) {
		n++;
	    }

	    while (m - 1 >= 0 && n + 1 < s.length()
		    && s.charAt(m - 1) == s.charAt(n + 1)) {
		m--;
		n++;
	    }

	    if (res.length() < n - m + 1) {
		res = s.substring(m, n + 1);
	    }

	    if (n == s.length()) {
		break;
	    }
	}

	return res;
    }
    
    /*
     * second round.
     */
    public String longestPalindrome2(String s) {
	if (s == null || s.length() < 2)
	    return s;

	char[] C = s.toCharArray();

	String curMax = s.substring(0, 1);

	for (int i = 0; i < C.length; i++) {
	    if (i > 0 && C[i] == C[i - 1])
		continue;

	    int m = i;
	    int n = i;

	    /*
	     * Let C[m]/C[n] to be the first/last char of the center part of a palindromic substring: 
	     * C[m] = C[m+1] = ... = C[n]
	     */
	    while (n + 1 < C.length && C[n + 1] == C[i]) {
		n++;
	    }

	    /*
	     * Use m-1 and n+1 in while loop condition
	     */
	    while (m - 1 >= 0 && n + 1 < C.length && C[m - 1] == C[n + 1]) {
		m--;
		n++;
	    }

	    if (n - m + 1 > curMax.length()) {
		curMax = s.substring(m, n + 1);
	    }
	}
	return curMax;
    }

    /*
     * first round. Used an additional help method.
     */
    static class Solution1 {
	public static String longestPalindrome1(String s) {
	    if (s == null || s.length() == 0) {
		return "";
	    }
	    String curLongest = "";

	    for (int i = 0; i < s.length(); i++) {
		// find the longest palindrome at i
		String temp = longestPalindromeHelp1(s, i);

		if (temp.length() > curLongest.length())
		    curLongest = temp;

	    }

	    return curLongest;
	}

	/*
	 * return the Palindromic substring in s centered at a given index
	 */
	private static String longestPalindromeHelp1(String s, int index) {
	    int left = index - 1;
	    int right = index + 1;

	    /*
	     * locate the boundaries
	     * 
	     * For "xxxa2222bxxx", and index =4 ~7, the boudaries will be "a"
	     * and "b"
	     */
	    while (left >= 0 && s.charAt(index) == s.charAt(left)) {
		left--;
	    }
	    while (right < s.length() && s.charAt(index) == s.charAt(right)) {
		right++;
	    }

	    while (left >= 0 && right < s.length()
		    && s.charAt(left) == s.charAt(right)) {
		left--;
		right++;
	    }

	    return s.substring(left + 1, right);
	}
    }
}
