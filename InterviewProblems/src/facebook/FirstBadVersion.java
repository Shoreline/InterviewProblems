package facebook;

/**
 * First Bad Version
 * 
 * Total Accepted: 13778 Total Submissions: 69061 Difficulty: Easy
 * 
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * 
 */
abstract class VersionControl {
    boolean isBadVersion(int n) {
	return true;
    }
}

public class FirstBadVersion {
    public class Solution extends VersionControl {
	public int firstBadVersion(int n) {
	    int left = 0;
	    int right = n;
	    int res = -1;
	    while (left <= right) {
		int mid = left + (right - left) / 2;
		if (isBadVersion(mid)) {
		    res = mid;
		    right = mid - 1;
		} else {
		    left = mid + 1;
		}
	    }

	    return res;
	}
    }
}
