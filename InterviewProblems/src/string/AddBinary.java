package string;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 */

/*
 * Converting Strings into Integers may lead to error(or runtime error): the
 * string of binary may exceeds the limit of Integer data type.
 */
public class AddBinary {
    /*
     * Similar to add two number, let out of boundary adder to be 0.
     */
    public class Solution {
	public String addBinary(String a, String b) {
	    if (a == null || b == null) {
		return a == null ? b : a;
	    }

	    StringBuilder res = new StringBuilder();
	    int i = 1;
	    int carry = 0;
	    int lenA = a.length();
	    int lenB = b.length();
	    while (lenA - i >= 0 || lenB - i >= 0 || carry > 0) {
		int numA = lenA - i >= 0 ? a.charAt(lenA - i) - '0' : 0;
		int numB = lenB - i >= 0 ? b.charAt(lenB - i) - '0' : 0;
		int sum = numA + numB + carry;
		res.append(sum % 2);
		carry = sum / 2;
		i++;
	    }

	    return res.reverse().toString();
	}
    }

    /*
     * Two tricks to simplify the process: 1) Differentiate long and short
     * Strings 2) Reverse input Strings for easier implementation
     */
    public class Solution2 {
	public String addBinary(String a, String b) {
	    if (a == null || b == null) {
		return a == null ? b : a;
	    } else if (a.length() == 0 || b.length() == 0) {
		return a.length() == 0 ? b : a;
	    }

	    String l = new StringBuilder((a.length() >= b.length() ? a : b))
		    .reverse().toString();
	    String s = new StringBuilder((a.length() >= b.length() ? b : a))
		    .reverse().toString();
	    StringBuilder sb = new StringBuilder();
	    int carry = 0;
	    for (int i = 0; i < l.length(); i++) {
		int m = l.charAt(i) - '0';
		int n = (i < s.length() ? s.charAt(i) - '0' : 0);

		int sum = m + n + carry;
		sb.append(sum % 2);
		carry = sum / 2;
	    }

	    if (carry > 0) {
		sb.append(carry);
	    }

	    return sb.reverse().toString();
	}
    }

    class Wrong_attempt {
	public String addBinary(String a, String b) {
	    String result = "";

	    int num1 = Integer.valueOf(a, 2);
	    int num2 = Integer.valueOf(b, 2);
	    result = Integer.toBinaryString(num1 + num2);
	    return result;
	}
    }

    /*
     * Fill the shorter string with "0"s at its beginning. Then simply mimic
     * manual adding
     */
    class Method_FillShort {
	public String addBinarya(String a, String b) {
	    StringBuilder result = new StringBuilder();
	    int diff = Math.abs(a.length() - b.length());
	    StringBuilder haha = new StringBuilder();

	    for (int i = 0; i < diff; i++) {
		haha.append('0');
	    }

	    String a1 = "";
	    String b1 = "";
	    if (a.length() > b.length()) {
		a1 = a;
		b1 = haha.toString() + b;
	    } else {
		a1 = haha.toString() + a;
		b1 = b;
	    }
	    // System.out.println(a1);
	    // System.out.println(b1);

	    int carrier = 0;
	    for (int i = a1.length() - 1; i >= 0; i--) {
		int sum = Integer.valueOf(String.valueOf(a1.charAt(i)))
			+ Integer.valueOf(String.valueOf(b1.charAt(i)))
			+ carrier;
		if (sum == 0) {
		    result.insert(0, '0');
		    carrier = 0;
		} else if (sum == 1) {
		    result.insert(0, '1');
		    carrier = 0;
		} else if (sum == 2) {
		    result.insert(0, '0');
		    carrier = 1;
		} else if (sum == 3) {
		    result.insert(0, '1');
		    carrier = 1;
		} else {
		    throw new IllegalArgumentException();
		}
	    }

	    if (carrier == 1) {
		result.insert(0, '1');
	    }

	    return result.toString();
	}
    }
}
