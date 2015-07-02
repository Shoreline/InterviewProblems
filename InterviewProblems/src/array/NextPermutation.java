package array;

import java.util.Arrays;

/**
 * Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 -> 1,3,2
 * 
 * 3,2,1 -> 1,2,3
 * 
 * 1,1,5 -> 1,5,1
 */

/*
 * Solution: Need to know math
 * 
 * 1. From right to left, find the first digit (PartitionNumber) which violate
 * the increase trend;
 * 
 * 2. From right to left, find the first digit larger than the PartitionNumber,
 * call it changeNumber;
 * 
 * 3. Swap the PartitionNumber and the changeNumber;
 * 
 * 4. Reverse all digits on the right of the original index of the
 * PartitionNumber (current index of the changeNumber) [2015 note] Step 4 is
 * equivalent to sort the right hand side of array as descending order ->
 * Arrays.sort(num, PartitionIdx, num.length);
 */

public class NextPermutation {
    public class Solution {
	public void nextPermutation(int[] nums) {
	    if (nums == null || nums.length < 2) {
		return;
	    }

	    int len = nums.length;
	    int p = len - 2;

	    while (p >= 0 && nums[p] >= nums[p + 1]) {
		p--;
	    }

	    if (p >= 0) {
		int c = len - 1;
		while (nums[c] <= nums[p]) {
		    c--;
		}
		swap(nums, p, c);
	    }

	    for (int i = 0; i < (len - p - 1) / 2; i++) {
		swap(nums, p + 1 + i, len - 1 - i);
	    }

	}

	private void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
    }

    public class Solution2 {
	public void nextPermutation(int[] num) {
	    if (num == null || num.length < 2) {
		return;
	    }

	    int p = -1; // p: partition index
	    for (int i = num.length - 1; i > 0; i--) {
		if (num[i] > num[i - 1]) {
		    p = i - 1;

		    for (int j = num.length - 1; j > p; j--) {
			if (num[j] > num[p]) {
			    swap(num, j, p);
			    break;
			}
		    }
		    break;
		}
	    }

	    Arrays.sort(num, p + 1, num.length);

	    return;
	}

	private void swap(int[] num, int i, int j) {
	    int tmp = num[i];
	    num[i] = num[j];
	    num[j] = tmp;
	    return;
	}
    }

}
