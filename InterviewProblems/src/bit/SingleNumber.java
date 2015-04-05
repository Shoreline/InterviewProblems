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

public class SingleNumber {
    /*
     * x ^ x = 0; x ^ 0s = x; XOR is associative and commutative
     */
    public class Solution {
	public int singleNumber(int[] A) {
	    for (int i = 1; i < A.length; i++) {
		A[0] = A[0] ^ A[i];
	    }
	    return A[0];
	}
    }
}
