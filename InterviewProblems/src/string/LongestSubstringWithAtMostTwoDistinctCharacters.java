package string;

/**
 * Longest Substring with At Most Two Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 */

/*
 * How about for K distinct characters?
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
	    int i = 0, j = -1, maxLen = 0;
	    for (int k = 1; k < s.length(); k++) {
		if (s.charAt(k) == s.charAt(k - 1))
		    continue;
		if (j >= 0 && s.charAt(j) != s.charAt(k)) {
		    maxLen = Math.max(k - i, maxLen);
		    i = j + 1;
		}
		j = k - 1;
	    }
	    return Math.max(s.length() - i, maxLen);

	}
    }
}
