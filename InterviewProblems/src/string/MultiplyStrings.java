package string;

public class MultiplyStrings {
    /**
     * Multiply Strings
     * 
     * Given two numbers represented as strings, return multiplication of the
     * numbers as a string.
     * 
     * Note: The numbers can be arbitrarily large and are non-negative.
     */

    /* Similar to the human way of doing multiply, but not identical   
     * 
     * Save 
     * 
     * Reverse String first to simplify the problem 
     * 
     */
    public class Solution {
	// numbers are non-negtive, no need to judege sign
	public String multiply(String num1, String num2) {
	    if (num1 == null || num2 == null) {
		return null;
	    }

	    String n1r = new StringBuilder(num1).reverse().toString();
	    String n2r = new StringBuilder(num2).reverse().toString();

	    int len1 = n1r.length();
	    int len2 = n2r.length();
	    int[] tmp = new int[len1 + len2];

	    for (int i = 0; i < len1; i++) {
		for (int j = 0; j < len2; j++) {
		    int d1 = n1r.charAt(i) - '0';
		    int d2 = n2r.charAt(j) - '0';
		    tmp[i + j] += d1 * d2; // *key
		}
	    }

	    StringBuilder sb = new StringBuilder();
	    int carry = 0;
	    for (int i = 0; i < tmp.length; i++) {
		carry = tmp[i] / 10;
		if (i + 1 < tmp.length) {
		    tmp[i + 1] += carry;
		}
		tmp[i] = tmp[i] % 10;
		sb.append(tmp[i]);
	    }

	    int validLength = sb.length();
	    // corner case: the whole product is '0'
	    while (validLength >= 2 && sb.charAt(validLength - 1) == '0') {
		validLength--;
	    }
	    sb.setLength(validLength);

	    // leet code bug? cannot return directly
	    String res = sb.reverse().toString();
	    return res;

	}
    } 
}
