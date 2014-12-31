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
}
