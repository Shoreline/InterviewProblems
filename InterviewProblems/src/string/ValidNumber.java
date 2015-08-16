package string;

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
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 */

/*
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23809661
 * 
 * Check by order:
 * 
 * For '.': there mustn't be other dot or E ahead; it cannot be the only
 * character in S; at least one of its adjacent two characters must be a digit.
 * 
 * For '+' and '-': cannot be the last character of S; if it is not the first
 * character of S, then the character before it must be E ('e' or 'E'); the
 * character behind it must be a digit or dot.
 * 
 * For 'e' and 'E': there mustn't be other E ahead of it; it cannot be the first
 * or last character
 * 
 * Besides these special characters and digits, any other character is not
 * allowed.
 */
public class ValidNumber {
    public class Solution {
	public boolean isNumber(String s) {
	    if (s == null) {
		return false;
	    }
	    s = s.trim();
	    if (s.length() == 0) {
		return false;
	    }

	    boolean usedDot = false;
	    boolean usedE = false;

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		switch (c) {
		case '.':
		    if (usedDot || usedE) {
			return false;
		    } else if ((i == 0 || !Character.isDigit(s.charAt(i - 1)))
			    && (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1)))) {
			return false;
		    }
		    usedDot = true;
		    break;
		case '+':
		case '-':
		    if (i == s.length() - 1) {
			return false;
		    }
		    if (!Character.isDigit(s.charAt(i + 1)) && s.charAt(i + 1) != '.') {
			return false;
		    }
		    if (i != 0 && Character.toLowerCase(s.charAt(i - 1)) != 'e') {
			return false;
		    }
		    break;
		case 'e':
		case 'E':
		    if (usedE || i == 0 || i == s.length() - 1) {
			return false;
		    }
		    usedE = true;
		    break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		    break;
		default:
		    return false;
		}

	    }

	    return true;
	}
    }

    public class Solution2 {
	public boolean isNumber(String s) {
	    if (s == null)
		return false;
	    s = s.trim();
	    if (s.length() == 0)
		return false;
	    boolean dotFlag = false;
	    boolean eFlag = false;
	    for (int i = 0; i < s.length(); i++) {
		switch (s.charAt(i)) {
		case '.':
		    if (dotFlag || eFlag || ((i == 0 || !Character.isDigit(s.charAt(i - 1)))
			    && (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1)))))
			return false;
		    dotFlag = true;
		    break;
		case '+':
		case '-':
		    if ((i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))
			    || (i == s.length() - 1 || !(Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == '.')))
			return false;
		    break;
		case 'e':
		case 'E':
		    if (eFlag || i == s.length() - 1 || i == 0)
			return false;
		    eFlag = true;
		    break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		    break;
		default:
		    return false;
		}
	    }
	    return true;
	}
    }

    /*
     * use Java's own parsing method
     */
    class method_exception {
	public boolean isNumber(final String s) {
	    if (s.contains("f")) {
		return false;
	    }
	    if (s.contains("D")) {
		return false;
	    }

	    try {
		Double.parseDouble(s);
	    } catch (NumberFormatException e) {
		return false;
	    }
	    return true;
	}
    }

    /*
     * Finite auto machine
     * http://blog.csdn.net/kenden23/article/details/18696083
     */
}
