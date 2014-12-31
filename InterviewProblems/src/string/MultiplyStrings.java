package string;

import java.util.ArrayList;

public class MultiplyStrings {
    /**
     * Multiply Strings
     * 
     * Given two numbers represented as strings, return multiplication of the
     * numbers as a string.
     * 
     * Note: The numbers can be arbitrarily large and are non-negative.
     */

    /*
     * My thought: mimic manual multiplying
     * 
     * coding speed too slow!!!!! need to finish in 15 min, instead of 2h
     * 
     * Be aware:
     * 
     * 1. carrier needs to be reset!
     * 
     * 2. start from the end of each String
     */

    public static String multiply(String num1, String num2) {
	if (num1 == null || num2 == null || num1.length() == 0
		|| num2.length() == 0)
	    return "";
	if (num1.equals("0") || num2.equals("0"))
	    return "0";

	ArrayList<String> product = new ArrayList<String>();

	for (int i = num1.length() - 1; i >= 0; i--) {
	    int i1 = num1.charAt(i) - '0';
	    StringBuilder aProduct = new StringBuilder();
	    int carrier = 0;
	    for (int j = num2.length() - 1; j >= 0; j--) {
		int i2 = num2.charAt(j) - '0';

		char c = (char) ('0' + (i1 * i2 + carrier) % 10);
		carrier = (i1 * i2 + carrier) / 10;
		aProduct.append(c);
	    }
	    if (carrier > 0) {
		aProduct.append((char) ('0' + carrier));
	    }

	    aProduct.reverse();
	    for (int k = 0; k < num1.length() - 1 - i; k++) {
		aProduct.append('0');
	    }
	    product.add(aProduct.toString());
	}

	// use the longest one as base
	String s = product.get(product.size() - 1);
	product.remove(product.size() - 1);
	int carrier = 0;
	for (String aProduct : product) {
	    // fill "0"s at the beginning
	    StringBuilder zeros = new StringBuilder();
	    for (int i = 0; i < s.length() - aProduct.length(); i++) {
		zeros.append('0');
	    }
	    aProduct = zeros.toString() + aProduct;

	    StringBuilder curResult = new StringBuilder();
	    for (int i = aProduct.length() - 1; i >= 0; i--) {
		int i1 = s.charAt(i) - '0';
		int i2 = aProduct.charAt(i) - '0';
		char c = (char) ('0' + (i1 + i2 + carrier) % 10);
		carrier = (i1 + i2 + carrier) / 10;
		curResult.append(c);
	    }
	    if (carrier > 0) {
		curResult.append((char) ('0' + carrier));
		// Do not forget to reset carrier!
		carrier = 0;
	    }

	    s = curResult.reverse().toString();
	}

	return s;
    }
}
