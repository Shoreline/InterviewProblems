package array;

public class RemoveDuplicatesFromSortedArray {
    /**
     * Remove Duplicates from Sorted Array
     * 
     * Given a sorted array, remove the duplicates in place such that each
     * element appear only once and return the new length.
     * 
     * Do not allocate extra space for another array, you must do this in place
     * with constant memory.
     * 
     * For example, Given input array A = [1,1,2],
     * 
     * Your function should return length = 2, and A is now [1,2].
     */

    /*
     * two ways:
     * 
     * 1. element switching, push all duplicated elements to the end of array;
     * 
     * 2. a better way: Make sure the beginning of the array is make of unique
     * elements-> insert all unique elements to the head of the array. Original
     * elements in the head can be overwritten
     */
    public int removeDuplicates(int[] A) {
	if (A.length < 2) {
	    return A.length;
	}

	// A is already sorted
	// Arrays.sort(A);

	int uniqueIdx = 1;

	for (int i = 1; i < A.length; i++) {
	    if (A[i] != A[i - 1]) {
		/*
		 * note: uniqueIdx <= i
		 */
		A[uniqueIdx] = A[i];
		uniqueIdx++;
		continue;
	    }

	}

	return uniqueIdx;
    }

    // Intuitive solution. The while loop can be more concise
    public class Solution {
	public int removeDuplicates(int[] A) {
	    if (A == null || A.length == 0) {
		return 0;
	    }

	    int ptr1 = 0;
	    int ptr2 = 1;
	    while (ptr2 < A.length) {
		if (A[ptr1] == A[ptr2]) {
		    ptr2++;
		} else {
		    ptr1++;
		    A[ptr1] = A[ptr2];
		    ptr2++;
		}
	    }

	    return ptr1 + 1;
	}
    }
}
