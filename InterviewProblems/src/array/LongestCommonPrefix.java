package array;

/**
 * Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
    public class Solution {
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) {
		return "";
	    } else if (strs.length == 1) {
		return strs[0];
	    }

	    StringBuilder res = new StringBuilder();
	    int pos = 0;
	    while (pos < strs[0].length()) {
		for (int i = 1; i < strs.length; i++) {
		    if (pos >= strs[i].length()
			    || strs[i].charAt(pos) != strs[0].charAt(pos)) {
			return res.toString();
		    }
		}
		res.append(strs[0].charAt(pos));
		pos++;
	    }

	    return res.toString();
	}
    }
    
    
}
