package string;

public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).
     * 
     * For example, a = "11" b = "1" Return "100".
     * 
     * 
     */

    /*
     * Converting strings into Integers may lead to error(or runtime error): the
     * string of binary may exceeds the limit of Integer data type.
     */

    public static String addBinary(String a, String b) {
	String result = "";

	int num1 = Integer.valueOf(a, 2);
	int num2 = Integer.valueOf(b, 2);
	result = Integer.toBinaryString(num1 + num2);
	return result;
    }

    // not finished
    public static String addBinary2(String a, String b) {
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
	System.out.println(a1);
	System.out.println(b1);

	int carrier = 0;
	for (int i = a1.length() - 1; i >= 0; i--) {
	    if (a1.charAt(i) == '1' && b1.charAt(i) == '1') {
		result.insert(0, '1');
		carrier = 1;
	    } else if (a1.charAt(i) == '0' && b1.charAt(i) == '0') {
		result.insert(0, '1');
	    }
	}

	return result.toString();
    }

    /*
     * Fill the shorter string with "0"s at its beginning. Then simply mimic
     * manual adding
     */
    public static String addBinarya(String a, String b) {
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
		    + Integer.valueOf(String.valueOf(b1.charAt(i))) + carrier;
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
