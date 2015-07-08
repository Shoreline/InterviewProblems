package array;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * Hint: Could you do it in-place with O(1) extra space?
 * 
 * Related problem: Reverse Words in a String II
 *
 */

public class RotateArray {
    /*
     * In-place and O(1) space
     * 
     * Similar to reverse words in String: 1,2,3,4,5,6,7 -> 7,6,5 | 4,3,2,1 ->
     * 5,6,7,1,2,3,4
     */
    public class Solution {
	public void rotate(int[] nums, int k) {
	    if (nums == null || nums.length == 0 || k % nums.length == 0) {
		return;
	    }
	    k %= nums.length;

	    reverseArray(nums, 0, nums.length - 1);
	    reverseArray(nums, 0, k - 1);
	    reverseArray(nums, k, nums.length - 1);

	}

	private void reverseArray(int[] nums, int start, int end) {
	    for (int i = 0; i < (end - start + 1) / 2; i++) {
		int tmp = nums[start + i];
		nums[start + i] = nums[end - i];
		nums[end - i] = tmp;
	    }
	}
    }

    /*
     * Not in-place
     * 
     * 1,2,3,4,5,6,7 -> x,x,x,1,2,3,4 -> 5,6,7,1,2,3,4
     */
    public class Solution_normal {
	public void rotate(int[] nums, int k) {
	    if (nums == null || nums.length == 0 || k % nums.length == 0) {
		return;
	    }
	    k = k % nums.length;
	    int[] tmp = new int[k];
	    for (int i = 0; i < k; i++) {
		tmp[i] = nums[nums.length - k + i];
	    }

	    for (int i = nums.length - 1; i >= k; i--) {
		nums[i] = nums[i - k];
	    }

	    for (int i = 0; i < k; i++) {
		nums[i] = tmp[i];
	    }

	    return;
	}
    }
}
