package array;

public class SearchInRotatedSortedArray_Storm8 {
    /**
     * Suppose we have a sorted array in ascending order, with no duplicates:
     * 
     * {1, 2, 3, 4, 5, 6, 7}
     * 
     * Somehow an unknown amount of numbers at the beginning are shifted to the
     * end, creating an array that looks like:
     * 
     * 0 1 2 3 4 5 6
     * 
     * {3, 4, 5, 6, 7, 1, 2}
     * 
     * Let us call the new array a shifted cyclic array.
     * 
     * Now, given a Shifted Cyclic Array int a[], and its length n (> 0), write
     * a function to find the smallest number in the array.
     */
    /*
     * My thought: need to find the boundary of smallest/biggest
     */
    public static int getSmallest(int[] a) {
	if (a == null || a.length < 0)
	    return Integer.MAX_VALUE;

	int i = 0;
	int j = a.length - 1;
	int mid = 0;
	// if a is already sorted (no shit at all)
	if (a[i] < a[j]) {
	    return a[i];
	}

	while (i <= j) {
	    /*
	     * Important: Since we cannot determine if a[mid] is what we want,
	     * we have to let j = mid instead of j=mid-1. And add the if block
	     * below to determine if we shall break
	     */
	    if (j - i <= 1) {
		break;
	    }

	    mid = (i + j) / 2;

	    if (a[mid] <= a[j]) {
		// the boundary is in the first half
		// j = mid - 1;
		j = mid;
	    } else if (a[mid] > a[j]) {
		// the boundary is in the last half
		// i = mid + 1;
		i = mid;
	    }

	}

	int result = Math.min(a[i], a[j]);

	return result;
    }
}
