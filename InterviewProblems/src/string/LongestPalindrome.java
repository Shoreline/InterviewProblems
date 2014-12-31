package string;

public class LongestPalindrome {

    /**
     * 
     * @param input
     * @return
     * 
     *         find the LCS of input String and reversed input String: not
     *         working? for example, if the input is "abcdefgedcba"
     * 
     */

    public static String getLongestPalindrome(String input) {
	String result = "";
	for (int i = 0; i < input.length(); i++) {
	    String currentLP = getLPAtPos(input, i);
	    if (currentLP.length() > result.length()) {
		result = currentLP;
	    }

	}

	if (result.length() < 2) {
	    System.out.println("No palindrome for input String: " + input);
	    return null;
	}

	return result;
    }

    private static String getLPAtPos(String input, int pos) {
	String result = "";
	int counter = 1;

	/* if the length of palindrome is an even number */
	if (pos > 1 && input.charAt(pos - 1) == input.charAt(pos)) {

	    while ((pos - counter - 1) >= 0 && (pos + counter < input.length())) {
		if (input.charAt(pos - counter - 1) != input.charAt(pos
			+ counter)) {
		    break;
		}
		counter++;
	    }
	    counter--;
	    result = input.substring(pos - counter - 1, pos + counter + 1);

	} else {
	    while ((pos - counter) >= 0 && (pos + counter < input.length())) {
		if (input.charAt(pos - counter) != input.charAt(pos + counter)) {
		    break;
		}
		counter++;
	    }
	    counter--;
	    result = input.substring(pos - counter, pos + counter + 1);
	}

	return result;

    }

}
