package array;

/**
 * Plus One
 * 
 * Given a number represented as an array of digits, plus one to the number.
 */

public class PlusOne {

    public class Solution {
	public int[] plusOne(int[] digits) {
	    if (digits == null || digits.length == 0)
		return digits;

	    int carry = 1;
	    for (int i = digits.length - 1; i >= 0; i--) {
		int digit = (digits[i] + carry) % 10;
		carry = (digits[i] + carry) / 10;
		digits[i] = digit;

		// prune branches
		if (carry == 0) {
		    return digits;
		}
	    }

	    /*
	     * if reaches here, no need to copy digits to res. Now all elements
	     * in digits must be 0
	     */
	    int[] res = new int[digits.length + 1];
	    res[0] = 1;
	    return res;
	}
    }

    class Solution_old {
	public int[] plusOne(int[] digits) {

	    int carrier = 1;

	    for (int i = digits.length - 1; i >= 0; i--) {
		if (digits[i] + carrier > 9) {
		    digits[i] = digits[i] + carrier - 10;
		    carrier = 1;
		} else {
		    digits[i] = digits[i] + carrier;
		    carrier = 0;
		    break;
		}
	    }

	    if (carrier == 0) {
		return digits;
	    } else {
		int[] result = new int[digits.length + 1];
		result[0] = carrier;

		for (int i = 0; i < digits.length; i++) {
		    result[i + 1] = digits[i];
		}

		return result;
	    }
	}
    }
}
