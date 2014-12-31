package string;

public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers beginning as
     * follows: 1, 11, 21, 1211, 111221, ...
     * 
     * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
     * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
     * nth sequence.
     * 
     * Note: The sequence of integers will be represented as a string.
     */

    public static String countAndSay(int n) {

	if (n == 1) {
	    return "1";
	} else if (n == 2) {
	    return "11";
	}
	String result = "11";
	for (int i = 1; i < n; i++) {
	    StringBuilder temp = new StringBuilder();
	    int counter = 1;

	    for (int j = 1; j < result.length(); j++) {
		if (result.charAt(j) == result.charAt(j - 1)) {
		    counter++;

		} else {
		    temp.append(counter);
		    temp.append(result.charAt(j - 1));
		    counter = 1;
		}

		if (j == result.length() - 1) {
		    if (result.charAt(j) == result.charAt(j - 1)) {
			temp.append(counter);
			temp.append(result.charAt(j - 1));
		    } else {
			temp.append('1');
			temp.append(result.charAt(j));
		    }
		}
	    }

	    result = temp.toString();
	}

	return result;
    }
}
