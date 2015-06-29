package bit;

/**
 * Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 */

/*
 * x ^ x = 0; x ^ 0s = x; XOR is associative and commutative
 */

public class SingleNumber {
    public class Solution {
	public int singleNumber(int[] nums) {
	    int res = nums[0];
	    for (int i = 1; i < nums.length; i++) {
		res ^= nums[i];
	    }

	    return res;
	}
    }
}
