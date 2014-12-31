package string;

public class Implement_strStr {
    /**
     * Implement strStr()
     * 
     * Returns a pointer to the first occurrence of needle in haystack, or null
     * if needle is not part of haystack.
     */

    /*
     * Has other solutions implementing advanced known algorithms, like KMP,
     * Rabin-Karp, Boyer-Moore
     */

    public String strStr(String haystack, String needle) {
	if (haystack == null || needle == null)
	    return null;

	// corner case
	if (needle == "")
	    return haystack;

	for (int i = 0; i < haystack.length(); i++) {
	    /*
	     * add this to avoid unnecessary comparisons. Without it, the
	     * solution below cannot pass the large set
	     * 
	     * Actually, the if block below can be merged into the condition of
	     * for loop
	     */
	    if (haystack.length() - i < needle.length())
		return null;

	    if (haystack.charAt(i) == needle.charAt(0)) {
		for (int j = 0; j < needle.length(); j++) {
		    if (i + j >= haystack.length()
			    || haystack.charAt(i + j) != needle.charAt(j)) {
			break;
			// cannot let i=i+j-1, for example: "mississippi",
			// "issip"
		    }
		    if (j == needle.length() - 1)
			return haystack.substring(i);
		}
	    }
	}

	return null;
    }
}
