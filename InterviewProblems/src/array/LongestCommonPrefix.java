package array;

public class LongestCommonPrefix {
    /**
     * Longest Common Prefix
     * 
     * Write a function to find the longest common prefix string amongst an
     * array of strings.
     */

    /*
     * second round (cannot pass the large set???)
     * 
     * take advantage of a label to break multiple loops
     */
    public String longestCommonPrefix(String[] strs) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (strs == null || strs.length == 0 || strs[0].length() == 0) {
	    return "";
	}

	int i = 0;

	loops: while (i < strs[0].length()) {
	    for (int j = 0; j < strs.length; j++) {

		if (i >= strs[j].length()) {
		    break loops;
		}

		char c = strs[0].charAt(i);
		if (strs[j].charAt(i) != c) {

		    break loops;
		}
	    }

	    i++;
	}

	return strs[0].substring(0, i);
    }

    /*
     * first round
     */
    public static String longestCommonPrefix1(String[] strs) {
	if (strs == null || strs.length == 0) {
	    return "";
	}
	int i = 0;
	boolean fine = true;

	while (fine) {
	    for (int j = 0; j < strs.length; j++) {
		if (i >= strs[j].length()) {
		    fine = false;
		    break;
		}
		char c = strs[0].charAt(i);
		if (strs[j].charAt(i) != c) {
		    fine = false;
		    break;
		}
	    }
	    if (fine)
		i++;
	}

	return strs[0].substring(0, i);
    }
}
