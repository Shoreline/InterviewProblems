package string;

public class PalindromeNumber {
    /**
     * Palindrome Number
     * 
     * Determine whether an integer is a palindrome. Do this without extra
     * space.
     * 
     * Some hints: Could negative integers be palindromes? (ie, -1)
     * 
     * If you are thinking of converting the integer to string, note the
     * restriction of using extra space.
     * 
     * You could also try reversing an integer. However, if you have solved the
     * problem "Reverse Integer", you know that the reversed integer might
     * overflow. How would you handle such case?
     * 
     * There is a more generic way of solving this problem.
     */

    /*
     * tricky part for using recursion: how to deal with 0s in the middle of x,
     * like 10001
     * 
     * many details. Compare two digits at a time
     */

    public static boolean isPalindrome(int x) {
	if (x < 0)
	    return false;

	if (x == 0)
	    return true;

	int length = 1;
	long temp = 1; // temp may exceed the range of Integer

	while (x / temp > 0) {
	    temp = temp * 10;
	    length++;
	}
	temp /= 10;
	int i = 10;
	int j = 0;

	while (j < length / 2) {
	    int firstDigit = (int) ((x / temp) % 10);
	    int lastDigit = (x % i) / (i / 10);

	    temp /= 10;
	    i *= 10;

	    if (firstDigit != lastDigit)
		return false;
	    j++;
	}

	return true;
    }

    /*
     * this solution using reverse integer and handles int overflow cases
     */
    public class Solution2 {
	public boolean isPalindrome(int x) {
	    if (x < 0) {
		return false;
	    } else if (x / 10 == 0) {
		return true;
	    }

	    return x == reverse(x) ? true : false;

	}

	private int reverse(int x) {
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
}
