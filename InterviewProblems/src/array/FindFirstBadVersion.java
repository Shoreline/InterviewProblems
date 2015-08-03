package array;

/**
 * First Bad Version
 * 
 * The code base version is an integer start from 1 to n. One day, someone
 * committed a bad version in the code case, so it caused this version and the
 * following versions are all failed in the unit tests. Find the first bad
 * version.
 * 
 * You can call isBadVersion to help you determine which version is the first
 * bad one. The details interface can be found in the code's annotation part.
 * 
 * Example: Given n = 5:
 * 
 * isBadVersion(3) -> false
 * 
 * isBadVersion(5) -> true
 * 
 * isBadVersion(4) -> true
 * 
 * Here we are 100% sure that the 4th version is the first bad version.
 * 
 * Note Please read the annotation in code area to get the correct way to call
 * isBadVersion in different language. For example, Java is
 * VersionControl.isBadVersion(v)
 *
 */

/*
 * Binary search. Be careful about the conditions.
 */
public class FindFirstBadVersion {
    public boolean isBadVersion(int k) {
	return true; // fake method just for avoid error in IDE
    };

    class Solution {
	public int findFirstBadVersion(int n) {
	    if (n == 1) {
		return 1;
	    }

	    int low = 0;
	    int high = n;

	    while (low < high) {
		int mid = low + (high - low) / 2;
		if (isBadVersion(mid)) {
		    high = mid;
		} else {
		    low = mid + 1;
		}
	    }

	    return high;
	}
    }
}
