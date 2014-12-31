package string;

public class DivideTwoIntegers {
    /**
     * Divide two integers without using multiplication, division and mod
     * operator.
     */

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
     * High hand solution: use shift operator to substitute divide!
     */
    public static int divideHighHand(int dividend, int divisor) // return c=a/b;
    {
	long a = dividend;
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
	while (b << d <= a) {
	    d++;
	}

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
