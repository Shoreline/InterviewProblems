package array;

/**
 * Search for a Range
 * 
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * 
 * return [3, 4].
 */
public class SearchForARange {
    /*
     * Straightforward solution: Use two binary search to find low and high
     * bound of the target.
     */
    public class Solution {
	public int[] searchRange(int[] nums, int target) {
	    int low = 0;
	    int high = nums.length - 1;
	    int[] res = new int[] { -1, -1 };
	    while (low <= high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
		    res[0] = mid; // low bound
		    high = mid - 1;
		} else if (nums[mid] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    low = 0;
	    high = nums.length - 1;
	    while (low <= high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
		    res[1] = mid; // high bound
		    low = mid + 1;
		} else if (nums[mid] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return res;
	}
    }

    /*
     * Can be more concise by combining the two searching methods.
     */
    public class Solution_funs {
	public int[] searchRange(int[] A, int target) {
	    int[] res = new int[] { -1, -1 };
	    if (A == null) {
		return res;
	    }

	    // find the low bound
	    res[0] = searchLowBound(A, 0, A.length - 1, target);

	    if (res[0] == -1) {
		return res;
	    }

	    // find the high bound
	    res[1] = searchHighBound(A, res[0], A.length - 1, target);

	    return res;
	}

	private int searchLowBound(int[] A, int low, int high, int target) {
	    int res = -1;

	    while (low <= high) {
		int mid = (low + high) / 2;
		if (A[mid] == target) {
		    res = mid;
		    high = mid - 1;
		} else if (A[mid] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }

	    return res;
	}

	private int searchHighBound(int[] A, int low, int high, int target) {
	    int res = -1;
	    while (low <= high) {
		int mid = (low + high) / 2;
		if (A[mid] == target) {
		    res = mid;
		    low = mid + 1;
		} else if (A[mid] < target) {
		    low = mid + 1;
		} else {
		    high = mid - 1;
		}
	    }
	    return res;
	}

    }
}
