package array;

public class SearchForARange {
    /**
     * Search for a Range
     * 
     * Given a sorted array of integers, find the starting and ending position
     * of a given target value.
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
    
    /*
     * Straightforward way:Use two binary search to find low and high bound of
     * the target.
     * 
     * Can be more concise by combining the two searching methods.
     */
    public class Solution {
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

    /*
     * My solution shall be correct. But there is a more concise version. Need
     * to check high hands' solutions
     */
    public int[] searchRange(int[] A, int target) {
	int[] result = new int[] { -1, -1 };
	if (A == null || A.length == 0) {
	    return result;
	}

	int i = 0;
	int j = A.length - 1;
	int mid = 0;

	while (i <= j) {
	    mid = (i + j) / 2;
	    if (A[mid] == target) {
		break;
	    } else if (A[mid] < target) {
		i = mid + 1;
	    } else {
		j = mid - 1;
	    }
	}

	/*
	 * if target exists in this array, find the start index and end index
	 * that A[i] == target, through two while loops
	 */
	if (A[mid] == target) {
	    int index1 = mid;
	    int index2 = mid;

	    /*
	     * This time, when A[mid]==target, change i or j instead of break
	     */
	    i = 0;
	    j = mid;
	    while (i <= j) {
		mid = (i + j) / 2;
		if (A[mid] == target) {
		    j = mid - 1;

		} else if (A[mid] < target) {
		    i = mid + 1;
		}

	    }
	    if (A[mid] < target)
		mid++;
	    index1 = mid;

	    i = mid;
	    j = A.length - 1;
	    while (i <= j) {
		mid = (i + j) / 2;
		if (A[mid] > target) {
		    j = mid - 1;
		}

		else if (A[mid] == target) {
		    i = mid + 1;
		}
	    }
	    if (A[mid] > target)
		mid--;
	    index2 = mid;

	    /*
	     * below is the O(n) solution
	     */
	    // while (true) {
	    // int temp1 = index1;
	    // int temp2 = index2;
	    // if (index1 - 1 >= 0 && A[index1 - 1] == A[mid]) {
	    // index1--;
	    // }
	    // else if (index2 + 1 < A.length && A[index2 + 1] == A[mid]) {
	    // index2++;
	    // }
	    // if (temp1 == index1 && temp2 == index2) {
	    // break;
	    // }
	    // }

	    result[0] = index1;
	    result[1] = index2;
	}

	return result;
    }
}
