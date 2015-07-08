package array;

/**
 * Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 */

public class MajorityElement {
    /*
     * O(N) time and O(1) space.
     * 
     * An interesting voting algorithm. It actually returns the most repeated
     * number in the array
     */
    public class Solution {
	public int majorityElement(int[] nums) {
	    int maj = nums[0];
	    int count = 1;
	    for (int i = 1; i < nums.length; i++) {
		if (maj == nums[i]) {
		    count++;
		} else {
		    count--;
		}

		if (count == 0) {
		    maj = nums[i];
		    count = 1;
		}
	    }

	    return maj;
	}
    }
}
