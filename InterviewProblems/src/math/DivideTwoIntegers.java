package math;

/**
 * Divide Two Integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 */

/*
 * Use 2^N as base. Think about regular 10^N base, they are similar. The reason
 * to use 2^N base is because we are now allowed to use multiplication. So we
 * can only use shift to archive our goal.
 * 
 * The way of computing shift is similar to computing div in Palindrome number
 */
public class DivideTwoIntegers {
    /*
     * Used long to avoid Integer overflow, nasty.
     * 
     * O(logN)
     */
    public class Solution {
	public int divide(int dividend, int divisor) {
	    if (divisor == 0) {
		return Integer.MAX_VALUE;
	    }
	    if (dividend == 0) {
		return 0;
	    }

	    boolean isPositive = (dividend > 0 && divisor > 0)
		    || (dividend < 0 && divisor < 0) ? true : false;
	    // boolean isNeg = (dividend^divisor)>>>31 == 1

	    long a = Math.abs((long) dividend);
	    long b = Math.abs((long) divisor);

	    int shift = 0;
	    while (a >= (b << 1)) {
		b <<= 1;
		shift++;
	    }

	    long res = 0;
	    while (shift >= 0) {
		if (a >= b) {
		    res += ((long) 1 << shift);
		    a -= b;
		}
		b >>= 1;
		shift--;
	    }

	    res = isPositive ? res : -res;
	    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
		return Integer.MAX_VALUE;
	    }
	    return (int) res;
	}
    }
}
