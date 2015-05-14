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
	    // if(version1==null&& version2==null){
	    // return 0;
	    // }
	    // else if(version1==null||version2==null){
	    // return version1==null? -1:1;
	    // }

	    String[] ver1 = version1.split("\\.");
	    String[] ver2 = version2.split("\\.");
	    int len = Math.max(ver1.length, ver2.length); // graceful handling
	    for (int i = 0; i < len; i++) {
		int v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
		int v2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
		if (v1 != v2) {
		    return v1 > v2 ? 1 : -1;
		}
	    }

	    return 0;
	}
    }
}
