package array;

/**
 * Merge Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 */

/*
 * Start from the end of both arrays. Fill the larger one starting from A[n+m-1]
 * 
 * note: take care the situations: when all original elements of A or B has been
 * filled in A, how to deal with the rest elements of the other array
 */
public class MergeSortedArray {
    /*
     * Similar to merge sorted lists
     */
    public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	    if (nums1 == null || nums2 == null) {
		return;
	    }

	    while (m > 0 && n > 0) {
		if (nums1[m - 1] > nums2[n - 1]) {
		    nums1[m + n - 1] = nums1[m - 1];
		    m--;
		} else {
		    nums1[m + n - 1] = nums2[n - 1];
		    n--;
		}
	    }

	    if (n > 0) {
		for (int i = 0; i < n; i++) {
		    nums1[i] = nums2[i];
		}
	    }
	}
    }

    public class Solution2 {
	public void merge(int A[], int m, int B[], int n) {
	    if (A == null || B == null || B.length == 0) {
		return;
	    }

	    int i = m + n - 1;
	    while (i >= 0 && m > 0 && n > 0) {
		if (A[m - 1] >= B[n - 1]) {
		    A[i] = A[m - 1];
		    m--;
		} else {
		    A[i] = B[n - 1];
		    n--;
		}
		i--;
	    }

	    if (m > 0) {
		while (i >= 0) {
		    A[i] = A[m - 1];
		    i--;
		    m--;
		}
	    } else {
		while (i >= 0) {
		    A[i] = B[n - 1];
		    i--;
		    n--;
		}
	    }

	}
    }

}
