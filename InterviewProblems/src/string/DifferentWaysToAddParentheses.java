package string;

import java.util.*;

/**
 * Different Ways to Add Parentheses
 * 
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * 
 * Example 1: Input: "2-1-1".
 * 
 * ((2-1)-1) = 0 (2-(1-1)) = 2 Output: [0, 2]
 * 
 * 
 * Example 2: Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * 
 * ((2*3)-(4*5)) = -14
 * 
 * ((2*(3-4))*5) = -10
 * 
 * (2*((3-4)*5)) = -10
 * 
 * (((2*3)-4)*5) = 10
 * 
 * Output: [-34, -14, -10, -10, 10]
 * 
 */

/*
 * Add a pair of parentheses to a parentheses-free string -> split this list of
 * integers into two parts
 */
public class DifferentWaysToAddParentheses {
    public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
	    List<Integer> res = new ArrayList<>();
	    if (input == null || input.isEmpty()) {
		return res;
	    }
	    for (int i = 0; i < input.length(); i++) {
		char c = input.charAt(i);
		if (c == '+' || c == '-' || c == '*') {
		    List<Integer> left = diffWaysToCompute(
			    input.substring(0, i));
		    List<Integer> right = diffWaysToCompute(
			    input.substring(i + 1, input.length()));

		    for (int val1 : left) {
			for (int val2 : right) {
			    int ans = c == '+' ? val1 + val2
				    : (c == '-' ? val1 - val2 : val1 * val2);
			    res.add(ans); // ok to have duplicates
			}
		    }
		}
	    }

	    if (res.isEmpty()) {
		res.add(Integer.valueOf(input));
	    }

	    return res;
	}
    }
}
