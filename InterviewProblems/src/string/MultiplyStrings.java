package string;

import java.util.Arrays;

/**
 * Multiply Strings
 * 
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

/*
 * Use an int[] to save each digit of the intermediate result
 * 
 * Numbers are non-negative. No need to worry about sign.
 * 
 * Similar to the human way of doing multiply, but not identical
 * 
 * Reverse String first to simplify the problem (not necessary)
 */
public class MultiplyStrings {

    public class Solution {
	//
	public String multiply(String num1, String num2) {
	    if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
		return null;
	    }
	    // if the first char is 0 then the product is surely 0.
	    else if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
		return "0";
	    }

	    int len1 = num1.length();
	    int len2 = num2.length();
	    int carry = 0;
	    int[] res = new int[len1 + len2];

	    for (int i = len1 - 1; i >= 0; i--) {
		for (int j = len2 - 1; j >= 0; j--) {
		    int var1 = num1.charAt(i) - '0';
		    int var2 = num2.charAt(j) - '0';
		    int sum = var1 * var2 + carry + res[i + j + 1];
		    res[i + j + 1] = sum % 10;
		    carry = sum / 10;
		}
		res[i] = carry; // important
		carry = 0; // remember to reset carry!
	    }

	    StringBuilder sb = new StringBuilder();
	    for (int i = res[0] == 0 ? 1 : 0; i < res.length; i++) {
		sb.append(res[i]);
	    }

	    return sb.toString();
	}
    }

    public class Solution2 {
	public String multiply(String num1, String num2) {
	    if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
		return "";
	    }
	    int[] res = new int[num1.length() + num2.length()];

	    int carry = 0;
	    for (int i = num1.length() - 1; i >= 0; i--) {
		int d1 = num1.charAt(i) - '0';
		int k = i + num2.length();
		for (int j = num2.length() - 1; j >= 0; j--) {
		    int d2 = num2.charAt(j) - '0';
		    int tmp = d1 * d2 + carry + res[k];
		    res[k] = tmp % 10;
		    carry = tmp / 10;
		    k--;
		}
		res[k] = carry;
		carry = 0;
	    }

	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    while (i < res.length && res[i] == 0) {
		i++;
	    }
	    while (i < res.length) {
		sb.append(res[i++]);
	    }

	    return sb.length() == 0 ? "0" : sb.toString();
	}
    }
}
