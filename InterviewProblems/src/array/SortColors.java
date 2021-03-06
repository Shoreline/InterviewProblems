package array;

/**
 * Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColors {
    /*
     * Best one-pass soluton
     * 
     * A[i]: the first element that is not 0
     * 
     * A[j]: the last element that is not 2
     * 
     * A[k]: the first element that is unknown;
     * 
     * 
     * i: boundary of 0 and 1(or known)
     * 
     * j: boundary of unknown and 2
     * 
     * k: boundary of 1 and unknown
     */
    public class Solution {
	public void sortColors(int[] nums) {
	    if (nums == null) {
		return;
	    }

	    int i = 0;
	    int j = nums.length - 1;
	    int k = 0;
	    while (k <= j) {
		if (nums[k] == 0) {
		    nums[k] = nums[i];
		    nums[i] = 0;
		    i++;
		    k++;
		} else if (nums[k] == 1) {
		    k++;
		} else {
		    nums[k] = nums[j];
		    nums[j] = 2;
		    j--;
		}
	    }
	}
    }

    // two passes solution. Straightforward
    public class Solution_TwoPasses {
	public void sortColorsA(int[] A) {
	    if (A == null || A.length == 0)
		return;

	    int red = 0;
	    int white = 0;
	    int blue = 0;

	    for (int i = 0; i < A.length; i++) {
		if (A[i] == 0) {
		    red++;
		} else if (A[i] == 1) {
		    white++;
		} else if (A[i] == 2) {
		    blue++;
		}
	    }

	    int i = 0;
	    while (i < A.length) {
		if (red > 0) {
		    A[i] = 0;
		    red--;
		} else if (white > 0) {
		    A[i] = 1;
		    white--;
		} else if (blue > 0) {
		    A[i] = 2;
		    blue--;
		}
		i++;
	    }
	}
    }

}
