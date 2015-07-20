package math;

import java.util.Stack;

/**
 * Basic Calculator
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "1 + 1" = 2
 * 
 * " 2-1 + 2 " = 3
 * 
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 */

/*
 * Stack to deal with parenthesis.
 * 
 * Reset sign after both '(' and ')';
 * 
 * Reset res after '('
 * 
 * Values in the stack are pushed by pair: one is the sign of next (left)
 * parenthesis; one is the value between next and previous left parenthesis
 */
public class BasicCalculator {
    public class Solution {
	public int calculate(String s) {
	    Stack<Integer> stack = new Stack<>();
	    int res = 0;
	    int sign = 1;

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (Character.isDigit(c)) {
		    int num = c - '0';
		    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
			c = s.charAt(++i);
			num = num * 10 + (c - '0');
		    }
		    res = res + sign * num;
		} else if (c == '-') {
		    sign = -1;
		} else if (c == '+') {
		    sign = 1;
		} else if (c == '(') {
		    stack.push(res); // push by pair
		    stack.push(sign);
		    res = 0;
		    sign = 1; // remember to reset sign
		} else if (c == ')') {
		    // the first pop out value is the sign
		    res = res * stack.pop() + stack.pop();
		    sign = 1; // remember to reset sign
		}
	    }

	    return res;
	}
    }
}
