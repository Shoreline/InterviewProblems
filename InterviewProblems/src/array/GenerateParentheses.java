package array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Generate Parentheses
     * 
     * Given n pairs of parentheses, write a function to generate all
     * combinations of well-formed parentheses.
     * 
     * For example, given n = 3, a solution set is:
     * 
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     */

    /*
     * My thought: a Catalan number question?
     * 
     * Knowing the combination amount is a Catalan number is not enough, we
     * still have to construct each combination. The algorithm of construction
     * varies case by case.
     * 
     * Use the algorithm in 150-question book, page 327
     * character appending rules:
     * 1) # of left parenthesis >= # of right ones 
     * 2) # of left parenthesis <= n
     * 
     * *Important*: add a String to result ArrayList only when we are sure that
     * this is a valid case
     * 
     * Use a global ArrayList to store results. The recursion method is void
     */
    
    /*
     * Use char[] instead of StringBuilder. 
     * No need to new SB everytime, new value will overwrite the old ones
     */
    public class Solution3 {
	public List<String> generateParenthesis(int n) {
	    List<String> res = new ArrayList<String>();
	    if (n < 1) {
		return res;
	    }

	    generateParenthesis(0, 0, n, res, new char[2 * n], 0);
	    return res;
	}

	private void generateParenthesis(int lp, int rp, int n,
		List<String> res, char[] temp, int ptr) {

	    if (rp > lp || lp > n) {
		return;
	    } else if (ptr > 2 * n - 1) {
		res.add(new String(temp));
		return;
	    }

	    temp[ptr] = '(';
	    generateParenthesis(lp + 1, rp, n, res, temp, ptr + 1);

	    temp[ptr] = ')';
	    generateParenthesis(lp, rp + 1, n, res, temp, ptr + 1);
	}
    }

    /*
     * Second round solution (done in leetcode webpage)
     * 
     * StringBuilder, like arrayList, is passed by (value of ) reference
     */
    public static class Solution2 {
	public static ArrayList<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    if (n < 1)
		return result;

	    generateParenthesis(n, 0, 0, result, new StringBuilder());

	    return result;
	}

	private static void generateParenthesis(int n, int left, int right,
		ArrayList<String> result, StringBuilder temp) {

	    if (left < right || left > n) {
		return;
	    }

	    if (right == n) {
		result.add(temp.toString());
		return;
	    }

	    // still need to use a new StringBuilder
	    StringBuilder temp2 = new StringBuilder(temp);

	    generateParenthesis(n, left + 1, right, result, temp.append("("));

	    // temp.setLength(temp.length()-1); <-- does not work
	    generateParenthesis(n, left, right + 1, result, temp2.append(")"));

	}
    }

    /*
     * The first round solution.
     */
    public static class Solution1 {
	public static ArrayList<String> generateParenthesis1(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    if (n <= 0)
		return result;

	    generateParenthesis1(n, n, "", result);

	    return result;

	}

	public static void generateParenthesis1(int remainingLeft,
		int remainingRight, String curString, ArrayList<String> result) {

	    /*
	     * The stop conditions are:
	     * 
	     * 1. right must >=0;
	     * 
	     * 2. right must be equal or larger than left (the remaining right
	     * paren must not less than the remaining left paren)
	     */
	    if (remainingRight < remainingLeft || remainingLeft < 0) {
		return;
	    }
	    if (remainingLeft == 0 && remainingRight == 0) {
		result.add(curString);
		return;
	    }

	    generateParenthesis1(remainingLeft - 1, remainingRight, curString
		    + "(", result);

	    generateParenthesis1(remainingLeft, remainingRight - 1, curString
		    + ")", result);
	}
    }
}
