package array;

/**
 * Find Peak Element
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 *
 */

public class FindPeakElement {
    /*
     * O(lgN) time
     * 
     * 1) let low<high and mid=(low+high)/2, then mid-1<=high for sure
     * -> safe to compare num[mid] and num[mid+1]
     * 
     * 2) There is always at least one peak for int[] num (adjacent elements in num are different)
     * -> There is always at least one peak for an array A if we assume A[-1]=A[A.len]= -∞
     * -> There is always at least one peak for an array A if A[-1]<A[0] && A[A.len]<A[A.len-1]
     * -> if num[mid]<num[mid+1], there is at least one peak between num[mid+1] ~ num[num.len-1]
     * -> if num[mid]>num[mid+1], there is at least one peak between num[0] ~ num[mid]
     * (num[mid] always ≠ num[mid+]) 
     */
    public class Solution {
	public int findPeakElement(int[] num) {
	    if (num == null || num.length == 0) {
		return -1;
	    }

	    int low = 0;
	    int high = num.length - 1;
	    int res = -1;
	    while (low <= high) {
		if (low == high) {
		    res = low;
		    break;
		}

		int mid = (low + high) / 2;
		if (num[mid] > num[mid + 1]) {
		    /*
		     * since mid<=high-1 so the search range is guaranteed to be
		     * smaller
		     */
		    high = mid;
		} else {
		    low = mid + 1;
		}
	    }

	    return res;
	}
    }
}
