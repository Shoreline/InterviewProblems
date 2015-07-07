package string;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation 
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */

/*
 * Use Stack.
 * 
 * Need to improve "isNumeric(String)"
 */
public class EvaluateReversePolishNotation {   
    public class Solution {
	public int evalRPN(String[] tokens) {
	    Stack<Integer> stack = new Stack<Integer>();

	    for (int i = 0; i < tokens.length; i++) {
		if (isNumeric(tokens[i])) {
		    stack.push(Integer.valueOf(tokens[i]));
		} else {
		    int right = stack.pop();
		    int left = stack.pop();
		    switch (tokens[i]) {
		    case "+":
			stack.push(left + right);
			break;
		    case "-":
			stack.push(left - right);
			break;
		    case "*":
			stack.push(left * right);
			break;
		    case "/":
			stack.push(left / right);
			break;
		    }
		}
	    }

	    return stack.pop();
	}

	private boolean isNumeric(String str) {
	    if (str.equals("+") || str.equals("-") || str.equals("*")
		    || str.equals("/")) {
		return false;
	    }

	    return true;
	}
    }
}
