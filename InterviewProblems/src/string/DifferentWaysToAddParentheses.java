package string;

import java.util.*;

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
		    List<Integer> left = diffWaysToCompute(input.substring(0, i));
		    List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));

		    for (int val1 : left) {
			for (int val2 : right) {
			    int ans = c == '+' ? val1 + val2 : (c == '-' ? val1 - val2 : val1 * val2);
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
