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
	public boolean isOneEditDistance(String s, String t) {
	    String strL = s.length() >= t.length() ? s : t;
	    String strS = s.length() >= t.length() ? t : s;

	    if (strL.length() - strS.length() > 1) {
		return false;
	    } else if (strS.length() == 0 && strL.length() == 0) {
		return false;
	    } else if (strS.length() == 0) {
		return true;
	    }

	    boolean diff = false;
	    int i = 0;
	    int j = 0;
	    while (i < strS.length()) {
		if (strS.charAt(i) != strL.charAt(j)) {
		    if (diff) {
			return false;
		    } else if (strL.length() > strS.length()) {
			j++;
		    }
		    diff = true;
		}

		i++;
		j++;
	    }

	    if (diff && j< strL.length()) {
		return false;
	    }

	    return diff;
	}
    }
}
