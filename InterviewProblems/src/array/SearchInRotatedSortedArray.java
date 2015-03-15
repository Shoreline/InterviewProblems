package array;

public class SearchInRotatedSortedArray {
    /**
     * Stom8 Interview Question Sample
     * 
     * Suppose a sorted array is rotated at some pivot unknown to you
     * beforehand.
     * 
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * 
     * You are given a target value to search. If found in the array return its
     * index, otherwise return -1.
     * 
     * You may assume no duplicate exists in the array.
     */

    /*
     * idea: In each iteration, identify the sorted half of the remaining part
     * of the array. Then with two simple comparisons we can know whether the
     * target is in this half
     * 
     * time complexity: O(lgN)
     */
    public class Solution {
	public int search(int[] A, int target) {
	    if (A == null) {
		return -1;
	    }

	    int low = 0;
	    int high = A.length - 1;

	    while (low <= high) {
		int mid = (low + high) / 2;

		if (A[mid] == target)
		    return mid;

		if (A[mid] >= A[low]) {
		    // {lowEnd ~ mid} is the sorted half

		    // see if target is in this half
		    if (A[low] <= target && target < A[mid]) {
			// target is in this half
			high = mid - 1;
		    } else {
			low = mid + 1;
		    }
		} else {
		    // {mid ~ highEnd} is the sorted half

		    if (A[mid] < target && target <= A[high]) {
			low = mid + 1;
		    } else {
			high = mid - 1;
		    }
		}
	    }

	    return -1;
	}
    }
}
