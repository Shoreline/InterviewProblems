package array;

/**
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S.
 * 
 * You may assume there exists one unique longest palindromic substring.
 */

/*
 * Manacher algorithm: O(N) time
 * 
 * link: http://www.felix021.com/blog/read.php?2040
 * 
 * http://www.meetqun.com/thread-3203-1-1.html
 */
public class LongestPalindromicSubstring {

    /*
     * Straightforward solution, O(n^2) time and O(1) space
     */
    public class Solution {
	public String longestPalindrome(String s) {
	    if (s == null) {
		return null;
	    }

	    String res = "";
	    for (int i = 0; i < s.length(); i++) {
		if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
		    continue;
		}

		int m = i;
		int n = i;

		while (m > 0 && s.charAt(m - 1) == s.charAt(i)) {
		    m--;
		}
		while (n < s.length() - 1 && s.charAt(n + 1) == s.charAt(i)) {
		    n++;
		}

		while (m > 0 && n < s.length() - 1
			&& s.charAt(m - 1) == s.charAt(n + 1)) {
		    m--;
		    n++;
		}

		res = (n - m + 1) > res.length() ? s.substring(m, n + 1) : res;
	    }

	    return res;
	}
    }
}
