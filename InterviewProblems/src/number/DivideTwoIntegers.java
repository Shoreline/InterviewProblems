package number;

public class DivideTwoIntegers {
    /**
     * Divide two integers without using multiplication, division and mod
     * operator.
     */
    class Solution {
	public int divide(int dividend, int divisor) {
	    long dividend_l = (long) dividend;
	    long divisor_l = (long) divisor;
	    int sign = (dividend > 0 && divisor > 0)
		    || (dividend < 0 && divisor < 0) ? 1 : -1;
	    dividend_l = Math.abs(dividend_l);
	    divisor_l = Math.abs(divisor_l);
	    if (dividend_l < divisor_l) {
		return 0;
	    }
	    long div_base = divisor_l;
	    long base = 1;
	    while ((div_base << 1) <= dividend_l) {
		base <<= 1;
		div_base <<= 1;
	    }
	    long value = 0;
	    while (dividend_l > 0 && div_base >= divisor_l) {
		if (dividend_l >= div_base) {
		    value += base;
		    dividend_l -= div_base;
		}
		base >>= 1;
		div_base >>= 1;
	    }

	    if (sign > 0) {
		return (int) Math.min(value, Integer.MAX_VALUE);
	    } else {
		return (int) -value;
	    }
	}
    }
    
    /*
     * 1. simulate manual dividing 2. int, String conversion 3. handle negative
     * number properly
     */
    public int divide(int dividend, int divisor) {
	if (divisor == 0) {
	    return 0;
	}

	String dividendStr = String.valueOf(dividend);
	String divisorStr = String.valueOf(divisor);

	int sign1 = 1;
	int sign2 = 1;

	if (dividendStr.charAt(0) == '-') {
	    sign1 = -1;
	    dividendStr = dividendStr.substring(1);
	}

	if (divisorStr.charAt(0) == '-') {
	    sign2 = -1;
	    divisorStr = divisorStr.substring(1);
	}

	if (Integer.valueOf(dividendStr) < Integer.valueOf(divisorStr)) {
	    return 0;
	}

	StringBuilder result = new StringBuilder();

	// ...

	return 0;
    }

    /*
     * High hand's solution: use shift operator to substitute division
     * 
     * -> wrong sign if dividend is too large
     */
    public static int divideHighHand(int dividend, int divisor) // return c=a/b;
    {
	long a = dividend; // convert to long in case of overflow
	long b = divisor;

	if (b == 0)
	    throw new ArithmeticException();

	boolean neg = false;
	if (a < 0)
	    neg = !neg;

	if (b < 0)
	    neg = !neg;

	a = Math.abs(a);
	b = Math.abs(b);

	int d = 0;
	while (b << d <= a) { // note: b << d does not change the value of b
	    d++;
	}
	// so now (b<<d) > a. Here b << d may overflow Integer.MAX_VALUE

	int c = 0;
	/*
	 * The idea is to use binary dividend? The answer must be = (1 or
	 * 0)*2^31 + (1 or 0)*2^30+...
	 */
	for (int i = d; i >= 0; i--) {
	    if (b << i <= a) {
		// c |= 1 << i;
		c += 1 << i; // my way, equivalent to high hand's way
		a -= b << i;
	    }
	}

	if (neg)
	    c = -c;
	return c;
    }
}
