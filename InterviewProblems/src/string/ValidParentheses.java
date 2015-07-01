package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */

/*
 * Stack is usually used to solve parentheses valid problems
 */
public class ValidParentheses {
    public class Solution {
	public boolean isValid(String s) {
	    if (s == null || s.length() == 0) {
		return true;
	    }

	    Map<Character, Character> parens = new HashMap<>();
	    parens.put(']', '[');
	    parens.put('}', '{');
	    parens.put(')', '(');

	    Stack<Character> stack = new Stack<>();

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (c == '(' || c == '{' || c == '[') {
		    stack.push(c);
		} else if (stack.isEmpty() || stack.pop() != parens.get(c)) {
		    return false;
		}
	    }

	    return stack.isEmpty();
	}
    }
}
