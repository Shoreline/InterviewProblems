package math;

/**
 * Divide two integers without using multiplication, division and mod
 * operator.
 */

public class DivideTwoIntegers {
    /*
     * Used long to avoid Integer overflow, nasty.
     */
    public class Solution {
	public int divide(int dividend, int divisor) {
	    if (divisor == 0) {
		return Integer.MAX_VALUE;
	    }

	    // notice
	    int sign = (dividend ^ divisor) >>> 1 == 1 ? -1 : 1;

	    long absDividend = Math.abs((long) dividend);
	    long absDivisor = Math.abs((long) divisor);

	    int digit = 0;
	    while ((absDivisor << 1) <= absDividend) {
		absDivisor <<= 1;
		digit++;
	    }

	    long res = 0;
	    while (digit >= 0) {
		if (absDividend >= absDivisor) {
		    res += ((long) 1 << digit);
		    absDividend -= absDivisor;
		}
		absDivisor >>= 1;
		digit--;
	    }

	    res = sign * res;
	    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
		return Integer.MAX_VALUE;
	    }
	    return (int) (res);
	}
    }
}
