package string;

public class ReverseInteger {
    /**
     * Reverse Integer
     * 
     * Reverse digits of an integer.
     * 
     * Example1: x = 123, return 321
     * 
     * Example2: x = -123, return -321
     * 
     * Have you thought about this? Here are some good questions to ask before
     * coding. Bonus points for you if you have already thought through this!
     * 
     * If the integer's last digit is 0, what should the output be? ie, cases
     * such as 10, 100.
     * 
     * Did you notice that the reversed integer might overflow? Assume the input
     * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
     * you handle such cases?
     * 
     * Throw an exception? Good, but what if throwing an exception is not an
     * option? You would then have to re-design the function (ie, add an extra
     * parameter).
     */

    /*
     * considered overflow.
     */
    class solution2 {
	public int reverse(int x) {
	    int res = 0;
	    int sign = x >= 0 ? 1 : -1;
	    x = Math.abs(x);

	    while (x > 0 && res < Integer.MAX_VALUE / 10) {
		res = res * 10 + x % 10;
		x = x / 10;
	    }

	    if (x > 0 && Integer.MAX_VALUE / 10 == res
		    && Integer.MAX_VALUE % 10 >= x % 10) {
		res = res * 10 + x % 10;
		x = x / 10;
	    }

	    return x == 0 ? (res * sign) : 0;
	}
    }

    /*
     * Cannot handle overflow cases.
     * 
     * No need to convert x and result to String/StringBuilder
     */
    class solution1 {
	public int reverse(int x) {
	    int result = 0;
	    int sign = 0;

	    if (x < 0) {
		sign = -1;
		x = x * sign;
	    } else {
		sign = 1;
	    }

	    while (x / 10 > 0) {
		int aDigit = x % 10;
		if (result == 0 && aDigit == 0) {
		    x = x / 10;
		    continue;
		}

		// result.append(aDigit);
		result = result * 10 + aDigit;
		x = x / 10;
	    }
	    result = result * 10 + x;

	    if (sign < 0) {
		result = -result;
	    }

	    return result;
	}
    }
}