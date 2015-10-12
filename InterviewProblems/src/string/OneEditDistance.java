package string;

/**
 * One Edit Distance
 * 
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 *
 */
public class OneEditDistance {
    public class Solution {
	public boolean isOneEditDistance(String s, String t) {
	    if (s.length() > t.length()) {
		return isOneEditDistance(t, s);
	    }
	    if (t.length() - s.length() > 1) {
		return false;
	    }

	    boolean hasDiff = false;

	    for (int i = 0, j = 0; i < s.length(); i++, j++) {
		if (s.charAt(i) != t.charAt(j)) {
		    if (hasDiff) {
			return false;
		    }
		    hasDiff = true;
		    if (s.length() < t.length()) {
			j++;
		    }
		}
	    }

	    return hasDiff || s.length() < t.length();
	}
    }
}
