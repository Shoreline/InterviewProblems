package math;

/**
 * Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 *
 */
public class PowerOfTwo {
    /*
     * Straightforward way
     */
    public class Solution {
	public boolean isPowerOfTwo(int n) {
	    while (n > 0 && n % 2 == 0) {
		n = n / 2;
	    }
	    return n == 1;
	}
    }

    public class Solution2 {
	public boolean isPowerOfTwo(int n) {
	    int val = 1;
	    while (val != n && val <= Integer.MAX_VALUE / 2) {
		val = val << 1;
	    }

	    return val == n;
	}
    }
}
