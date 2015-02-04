package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /**
     * Valid Parentheses
     * 
     * Given a string containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     * 
     * The brackets must close in the correct order, "()" and "()[]{}" are all
     * valid but "(]" and "([)]" are not.
     */

    public class Solution3 {
	public boolean isValid(String s) {
	    if (s == null || s.length() == 0) {
		return true;
	    }

	    Map<Character, Character> par = new HashMap<Character, Character>();
	    par.put(')', '(');
	    par.put('}', '{');
	    par.put(']', '[');

	    Stack<Character> parStack = new Stack<Character>();
	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);

		if (c == '(' || c == '[' || c == '{') {
		    parStack.push(c);
		} else if (par.containsKey(c)) {
		    if (parStack.isEmpty() ||parStack.pop() != par.get(c)) {
			return false;
		    }
		}

	    }

	    if (parStack.isEmpty()) {
		return true;
	    }

	    return false;
	}
    }
    
    /*
     * Important: Once see parentheses, think using stack
     * 
     * The tricky part is that the brackets shall close in correct order.
     * 
     * "([)]" is not correct.
     */
    public static class Solution2 {
	public static boolean isValid(String s) {
	    if (s == null || s.length() == 0)
		return true;

	    Stack<Character> leftParen = new Stack<Character>();
	    char[] paren = new char[] { '(', ')', '[', ']', '{', '}' };

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);

		for (int j = 0; j < paren.length; j++) {
		    if (c == paren[j] && j % 2 == 0) {
			// if see a left paren, push it into stack;
			leftParen.push(c);
		    } else if (c == paren[j] && j % 2 == 1) {
			// if see a right paren, two cases can lead to false
			if (leftParen.isEmpty()
				|| leftParen.pop() != paren[j - 1])
			    return false;
		    }
		}
	    }

	    if (!leftParen.isEmpty())
		return false;

	    return true;
	}
    }

    public static class Solution1 {
	// too many detail, easy to make mistake. Better use more sily way
	public static boolean isValid1(String s) {
	    if (s == null || s.length() == 0)
		return true;

	    char[] paren = new char[] { '(', ')', '[', ']', '{', '}' };
	    int[] num = new int[6];

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);

		for (int j = 0; j < 6; j++) {
		    if (paren[j] == c) {
			num[j]++;

			// check if left paren # >= right paren #
			if (j % 2 == 0 && num[j] < num[j + 1]) {
			    return false;
			}

			/*
			 * if s.charAt(i) is a right paren, then s.charAt(i-1)
			 * cannot be other type of left paren.
			 * 
			 * For example, if s.charAt(i)==')', then s.charAt(i-1)
			 * cannot be '{' or '['.
			 */
			if (j % 2 == 1 && i > 0) {
			    for (int k = 1; k <= 5; k += 2) {
				if (s.charAt(i - 1) == paren[k - 1]
					&& c != paren[k])
				    return false;
			    }

			}
		    }
		}

	    }

	    // each pair of left/right paren must have identical amount
	    for (int j = 0; j < 6; j += 2) {
		if (num[j] != num[j + 1]) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
