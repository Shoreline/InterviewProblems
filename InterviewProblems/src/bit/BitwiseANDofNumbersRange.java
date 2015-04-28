package bit;

/**
 * Bitwise AND of Numbers Range
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 *
 */

/*
 * The actual idea is to find the common left part of m and n, then fill the rest with 0.
 * 
 * For example: 5: 101; 7: 111 
 * So the common left part is 1xx, fill x with 0 so the answer is 100
 * 
 * Bitwise AND from m to n, is equivalent to bitwise AND from n to m. 
 * -> keep doing n= n & (n-1), which will make the difference part between n and n-1 to 0.
 * 
 */
public class BitwiseANDofNumbersRange {
    public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
	    int count = 0;
	    while (m != n) {
		m = m >> 1;
		n = n >> 1;
		count++;
	    }

	    // the right count bits of m will be 0
	    return m << count;
	}
    }
}
