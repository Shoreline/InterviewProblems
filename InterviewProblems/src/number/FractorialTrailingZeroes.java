package number;

/**
 * Factorial Trailing Zeroes
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 *
 */

/*
 * The idea is that only 2x5 can generate a 0. And there are many more 5s than
 * 2s. So just need to count 5s.
 * 
 * Notice that 25, 125, 625,... offer more 5s
 */
public class FractorialTrailingZeroes {
    /*
     * every 5 number, there is a number= 5k that can offer at least one 5. Plus
     * k may equal to 5k', ...
     * 
     * So we have below simple algorithm
     */
    public class Solution {
	public int trailingZeroes(int n) {
	    int fives = 0;

	    while (n > 4) {
		fives += n / 5;
		n /= 5;
	    }

	    return fives;
	}
    }
}
