package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses {
    /*
     * My thought: a Catalan number question?
     * 
     * Knowing the combination amount is a Catalan number is not enough, we
     * still have to construct each combination. The algorithm of construction
     * varies case by case.
     * 
     * Use the algorithm in 150-question book, page 327 character appending
     * rules: 1) # of left parenthesis >= # of right ones 2) # of left
     * parenthesis <= n
     * 
     * Use a global ArrayList to store results. The recursion method is void
     */

    /*
     * Use char[] instead of StringBuilder or String to save tmp. 
     */
    public class Solution {
	public List<String> generateParenthesis(int n) {
	    List<String> res = new ArrayList<>();
	    if (n < 1) {
		return res;
	    }

	    dfs(n, n, 0, new char[2 * n], res);

	    return res;
	}

	// left: remaining left paren can be used. Similar for right.
	private void dfs(int left, int right, int pos, char[] tmp,
		List<String> res) {
	    if (left == 0 && right == 0) {
		res.add(new String(tmp));
		return;
	    }
	    if (left < 0 || right < 0 || left > right) {
		return;
	    }

	    tmp[pos] = '(';
	    dfs(left - 1, right, pos + 1, tmp, res);
	    tmp[pos] = ')';
	    dfs(left, right - 1, pos + 1, tmp, res);

	}
    }
}
