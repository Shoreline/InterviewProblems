package array;

/**
 * Find the Duplicate Number
 * 
 * Total Accepted: 7501 Total Submissions: 22239 Difficulty: Hard
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * 
 * You must not modify the array (assume the array is read only).
 * 
 * You must use only constant, O(1) extra space.
 * 
 * Your runtime complexity should be less than O(n2).
 * 
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 *
 */
/*
 * Easy to prove this is at least one duplicate. (the algorithm relies on this
 * premise)
 * 
 * The main idea is the same with problem Linked List Cycle II
 * 
 * Important: walker and runner are indices.
 * 
 * If there is no duplicate: say values in nums are from 0 to n (not 1 to n),
 * then they will form a big cycle.
 * 
 * If there is duplicated vals, then the index of that value will be the
 * entrance of a small cycle. Use the same algorithm in Linked List Cycle II to
 * find the entrance of this cycle
 */
public class FindTheDuplicateNumber {
    public class Solution {
	public int findDuplicate(int[] nums) {
	    int runner = nums[nums[0]];
	    int walker = nums[0];
	    while (walker != runner) {
		walker = nums[walker];
		runner = nums[nums[runner]];
	    }

	    runner = 0;
	    while (walker != runner) {
		runner = nums[runner];
		walker = nums[walker];
	    }

	    return walker;
	}
    }
}
