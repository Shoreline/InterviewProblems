package string;

public class StringToInteger {
    /**
     * String to Integer (atoi)
     * 
     * Implement atoi to convert a string to an integer.
     * 
     * Hint: Carefully consider all possible input cases. If you want a
     * challenge, please do not see below and ask yourself what are the possible
     * input cases.
     * 
     * Notes: It is intended for this problem to be specified vaguely (ie, no
     * given input specs). You are responsible to gather all the input
     * requirements up front.
     * 
     * Requirements for atoi: The function first discards as many whitespace
     * characters as necessary until the first non-whitespace character is
     * found. Then, starting from this character, takes an optional initial plus
     * or minus sign followed by as many numerical digits as possible, and
     * interprets them as a numerical value.
     * 
     * The string can contain additional characters after those that form the
     * integral number, which are ignored and have no effect on the behavior of
     * this function.
     * 
     * If the first sequence of non-whitespace characters in str is not a valid
     * integral number, or if no such sequence exists because either str is
     * empty or it contains only whitespace characters, no conversion is
     * performed.
     * 
     * If no valid conversion could be performed, a zero value is returned. If
     * the correct value is out of the range of representable values, INT_MAX
     * (2147483647) or INT_MIN (-2147483648) is returned.
     */
    /*
     * The string can contain additional characters after those that form the
     * integral number, which are ignored
     * 
     * Problem: how to judge whether a String's value is out of the range of
     * Integer?
     * 
     * Is 2e5 a valid number?
     * 
     * "- 123" is not allowed.
     */
    public static int atoi(String str) {
	if (str == null || str.length() == 0)
	    return 0;

	// str = str.trim();
	if (str.length() == 0
		|| (str.length() == 1 && (str.equals("+") || str.equals("-"))))
	    return 0;

	int s1 = -1;
	int s2 = -1;
	int sign = 0;

	for (int i = 0; i < str.length(); i++) {
	    char c = str.charAt(i);
	    if (c == ' ') {
		if (sign == 0 && s1 == -1)
		    continue;
	    }

	    if (c <= '9' && c >= '0') {
		if (s1 == -1) {
		    s1 = i;
		    s2 = i;
		} else if (i - s2 == 1) {
		    s2++;
		} else {
		    break;
		}
	    } else {
		if (c == '-' && s1 == -1 && sign == 0) {
		    sign = -1;
		    continue;
		} else if (c == '+' && s1 == -1 && sign == 0) {
		    sign = 1;
		    continue;
		}

		if (s1 == -1) {
		    return 0;
		} else {
		    break;
		}
	    }
	}

	str = str.substring(s1, s2 + 1);
	int result = 0;

	// better start from the left
	for (int j = 0; j < str.length(); j++) {
	    int digit = str.charAt(j) - '0';
	    /*
	     * Important: how to determine whether the result will exceed range
	     * of Integer
	     */
	    if (result > Integer.MAX_VALUE / 10
		    || (result == Integer.MAX_VALUE / 10 && (digit >= 7))) {
		if (sign == -1) {
		    if (result == Integer.MAX_VALUE / 10 && digit == 7) {
		    } else
			return Integer.MIN_VALUE;
		} else {
		    return Integer.MAX_VALUE;
		}
	    }
	    result = result * 10 + digit;
	}
	if (sign == -1) {
	    result = -1 * result;
	}
	return result;
    }
}
