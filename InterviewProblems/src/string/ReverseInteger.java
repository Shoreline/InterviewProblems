package string;

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
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 */
/*
 * The tricky part is how to deal with overflow.
 */
public class ReverseInteger {
    /*
     * considered overflow.
     * 
     * After the while loop if x>0 then res must >= Integer>MAX_VALUE. In this
     * situation, the only case we can keep reversing without causing overflow
     * is that res == Integer.MAX_VALUE && x%10<=Integer.MAX_VALUE%10
     */
    class Solution {
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
     * Cannot handle overflow cases, say 1534236469
     * 
     * No need to convert x and result to String/StringBuilder
     */
    public class Wrong_attempt {
	public int reverse(int x) {
	    int res = 0;
	    while (x != 0) {
		int rightmost = x % 10;
		res = res * 10 + rightmost;
		x /= 10;
	    }
	    return res;
	}
    }
}