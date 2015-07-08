package bit;

/**
 * Reverse Bits
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 */

public class ReverseBits {

    /*
     * use OR to change res
     */
    public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
	    int res = 0;

	    for (int i = 0; i < 32; i++) {
		// wrong with out (): res |= (n >> i) & 1 << (31 - i)
		res |= ((n >> i) & 1) << (31 - i);

	    }

	    return res;
	}
    }

    // Time limit exceeded. Perhaps addition is too slow?
    public class Method_tle {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
	    int res = 0;
	    while (n != 0) {
		res = (res << 1) + (n & 1);
		n = n >> 1;
	    }

	    return res;
	}
    }

    /*
     * 0 ^ 1 = 1; 1 ^ 1 = 0
     * 
     * --> a bit ^ 1 = NOT this bit
     * 
     * 0 ^ 0 = 0; 0 ^ 1 = 1;
     * 
     * --> a bit ^ 0 = still this bit
     */
    public class Solution_Swapping {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
	    int res = n;
	    for (int i = 0; i < Integer.SIZE / 2; i++) {
		res = swap(res, i, Integer.SIZE - 1 - i);
	    }
	    return res;
	}

	private int swap(int n, int i, int j) {
	    int iBit = (n >> i) & 1;
	    int jBit = (n >> j) & 1;

	    if (iBit != jBit) {
		int mask = (1 << i) | (1 << j);
		n = n ^ mask;
	    }

	    return n;
	}
    }

    public class Solution_2013 {
	public int reverseIntegerByBit(int n) {

	    for (int i = 0; i < Integer.SIZE / 2; i++) {
		int j = Integer.SIZE - 1 - i;
		swapBits(n, i, j);
	    }

	    return n;
	}

	private int swapBits(int n, int i, int j) {

	    int ithBit = (n >> i) & 1;
	    int jthBit = (n >> j) & 1;

	    if ((ithBit ^ jthBit) == 1) {
		/*
		 * build a mask: 0...1...1...0 (Only the ith and jth bits are 1)
		 */
		int mask1 = 1 << i;
		int mask2 = 1 << j;
		int mask = mask1 | mask2;

		// switch the ith and jth bit
		n = n ^ mask;
	    }

	    return n;
	}
    }
}
