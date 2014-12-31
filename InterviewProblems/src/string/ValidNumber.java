package string;

public class ValidNumber {
    /**
     * Valid Number
     * 
     * Validate if a given string is numeric.
     * 
     * Some examples:
     * 
     * "0" => true
     * 
     * " 0.1 " => true
     * 
     * "abc" => false
     * 
     * "1 a" => false
     * 
     * "2e10" => true
     * 
     * Note: It is intended for the problem statement to be ambiguous. You
     * should gather all requirements up front before implementing one.
     */

    /*
     * not finished yet. too many corner cases
     */
    public boolean isNumber(String s) {
	if (s == null || s.trim().length() == 0)
	    return false;
	s = s.trim();

	// allow maximum one "."

	// allow maximum one "e" among two set of digits

	// allow a "-" at the very beginning

	// if every character is a digit and the first one is not a "0"(except
	// length ==1), pass

	/*
	 * addition cases:
	 * 
	 * allow "+"/"-" at the very beginning, or after "e"
	 */

	int dotPos = -1;
	int ePos = -1;

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '.') {
		if (dotPos > -1 || s.length() == 1)
		    return false;

		dotPos = i;

	    } else if (c == 'e' || s.length() == 1) {
		if (ePos > -1)
		    return false;
		ePos = i;

	    } else if (c == '-' || c == '+') {
		if (s.length() == 1 || (i != ePos + 1)) {
		    return false;
		}
	    } else if (c >= '0' && c <= '9') {
		continue;
	    } else {
		return false;
	    }
	}
	/*
	 * need to check if there are numbers before and after "e"
	 */

	return true;
    }
}
