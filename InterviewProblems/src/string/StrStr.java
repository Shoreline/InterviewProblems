package string;

/**
 * Implement strStr() (Problem return type changed (2014-10))
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Update (2014-11-02): The signature of the function had been updated to return
 * the index instead of the pointer. If you still see your function signature
 * returns a char * or String, please click the reload button to reset your code
 * definition.
 */

/*
 * Has other solutions implementing advanced known algorithms, like KMP
 * (O(m+n)), Rabin-Karp, Boyer-Moore
 */
public class StrStr {
    public class Solution {
	public int strStr(String haystack, String needle) {
	    if (haystack == null || needle == null) {
		return -1;
	    } else if (needle.isEmpty()) {
		return 0;
	    }

	    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
		if (haystack.charAt(i) == needle.charAt(0)) {
		    boolean found = true;
		    for (int j = 0; j < needle.length(); j++) {
			if (haystack.charAt(i + j) != needle.charAt(j)) {
			    found = false;
			    break;
			}
		    }
		    if (found) {
			return i;
		    }
		}
	    }

	    return -1;
	}
    }

    class Solution_implementKMP {
	public int strStr(String haystack, String needle) {
	    int n = haystack.length(), k = needle.length();
	    if (n < k)
		return -1;
	    if (k == 0)
		return 0;
	    int[] lps = new int[k];
	    buildPattern(lps, needle);
	    int partialMatchLength = 0;
	    for (int i = 0; i < n;) {
		if (haystack.charAt(i) == needle.charAt(partialMatchLength)) {
		    if (partialMatchLength == k - 1)
			return i - partialMatchLength;
		    partialMatchLength++;
		    i++;
		} else {
		    if (partialMatchLength > 0) {
			partialMatchLength = lps[partialMatchLength - 1];
		    } else
			i++;
		}

	    }
	    return -1;
	}

	public void buildPattern(int[] lps, String needle) {
	    lps[0] = 0;
	    int i = 1, currLength = 0; // current length of longest prefix
				       // suffix
	    while (i < lps.length) {
		if (needle.charAt(i) == needle.charAt(currLength)) {
		    currLength++;
		    lps[i] = currLength;
		    i++;
		} else {
		    if (currLength != 0)
			currLength = lps[currLength - 1];
		    else {
			lps[i] = 0;
			i++;
		    }
		}
	    }
	}
    }

    /*
     * use a prime P as base to compute a P-based number to represent a String.
     */
    public class Method_RollingHash {
	public String strStr(String haystack, String needle) {
	    if (haystack == null || needle == null)
		return null;
	    if (haystack.length() == 0) {
		return needle.length() == 0 ? "" : null;
	    }
	    if (needle.length() == 0)
		return haystack;
	    if (haystack.length() < needle.length())
		return null;

	    int base = 29;
	    long patternHash = 0;
	    long tempBase = 1;

	    for (int i = needle.length() - 1; i >= 0; i--) {
		patternHash += (int) needle.charAt(i) * tempBase;
		tempBase *= base;
	    }

	    long hayHash = 0;
	    tempBase = 1;
	    for (int i = needle.length() - 1; i >= 0; i--) {
		hayHash += (int) haystack.charAt(i) * tempBase;
		tempBase *= base;
	    }
	    tempBase /= base;

	    if (hayHash == patternHash) {
		return haystack;
	    }

	    for (int i = needle.length(); i < haystack.length(); i++) {
		hayHash = (hayHash - (int) haystack.charAt(i - needle.length()) * tempBase) * base
			+ (int) haystack.charAt(i);
		if (hayHash == patternHash) {
		    return haystack.substring(i - needle.length() + 1);
		}
	    }
	    return null;
	}

    }

}
