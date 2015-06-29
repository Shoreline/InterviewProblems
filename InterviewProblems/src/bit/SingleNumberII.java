package bit;

/**
 * Single Number II
 * 
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 */

/*
 * Bit counting.
 * 
 * O(32N) time, used fixed extra memory -> O(1) memory
 */
public class SingleNumberII {

    public class Solution {
	public int singleNumber(int[] A) {
	    int[] bit = new int[32];

	    // save bit count in reverse order
	    for (int i = 0; i < A.length; i++) {
		for (int k = 0; k < bit.length; k++) {
		    /*
		     * get value of A[i] at the (31-k)th bit (assume the highest
		     * bit is the 0-th bit);
		     * 
		     * or k-th bit (assume the lowest bit is the 0-th bit
		     */
		    bit[k] += (A[i] >> k) & 1;
		}
	    }

	    int res = 0;
	    for (int k = 0; k < bit.length; k++) {
		/*
		 * bit[31] saves the highest bit, so get moved the most
		 */
		res += (bit[k] % 3) << k;
	    }

	    return res;
	}
    }
}
