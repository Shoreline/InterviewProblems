package math;

/**
 * Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7
 * 
 * " 3/2 " = 1
 * 
 * " 3+5 / 2 " = 5
 *
 */

/*
 * Since there is no parenthesis, only numbers, operands and white spaces, we
 * can treat numbers connected by multiply and division as one segment. So
 * segments are separated only by '+' and '-'.
 */
public class BasicCalculatorII {
    public class Solution {
	public int calculate(String s) {
	    char operand = '+'; // easy to forget
	    int res = 0;
	    int cur = 0; // value of current segment

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (c == '+' || c == '-') {
		    // only add cur to res while a segment is end
		    operand = c;
		    res += cur;
		    cur = 0;
		} else if (c == '*' || c == '/') {
		    operand = c;
		} else if (Character.isDigit(c)) {
		    int num = c - '0';
		    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
			c = s.charAt(++i);
			num = num * 10 + (c - '0');
		    }
		    switch (operand) {
		    case '+':
			cur += num;
			break;
		    case '-':
			cur += -num;
			break;
		    case '*':
			cur *= num;
			break;
		    case '/':
			cur /= num;
			break;
		    }
		}
	    }

	    res += cur;

	    return res;
	}
    }
}
