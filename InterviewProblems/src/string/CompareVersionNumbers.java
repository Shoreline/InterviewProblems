package string;

/**
 * Compare Version Numbers
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */
public class CompareVersionNumbers {
    /*
     * 1. '.' is a special character, need to add "\\" before it;
     * 
     * 2. int len = Math.max(ver1.length, ver2.length)
     */
    public class Solution {
	public int compareVersion(String version1, String version2) {
	    // version strings are non-empty
	    String[] v1 = version1.split("\\.");
	    String[] v2 = version2.split("\\.");

	    for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
		String val1 = i < v1.length ? v1[i] : "0";
		String val2 = i < v2.length ? v2[i] : "0";

		int diff = Integer.valueOf(val1) - Integer.valueOf(val2);
		if (diff != 0) {
		    return diff > 0 ? 1 : -1;
		}
	    }

	    return 0;
	}
    }
}
