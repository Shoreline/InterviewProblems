package string;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * Longest Valid Parentheses
     * 
     * Given a string containing just the characters '(' and ')', find the
     * length of the longest valid (well-formed) parentheses substring.
     * 
     * For "(()", the longest valid parentheses substring is "()", which has
     * length = 2.
     * 
     * Another example is ")()())", where the longest valid parentheses
     * substring is "()()", which has length = 4.
     */

    /*
     * use stack. high hand's solution
     * 
     * use a stack to store the indice of left parens; once meet a right paren
     * at index i, it means (i-stack.pop()+1) is a valid substring of
     * parentheses
     * 
     * tricky examples: "()()"; "()(()"
     */
    
    /*
     * Even the stack has left only one left paren and sees a right paren, it
     * may not be the start of substring.
     * For example: "()()"
     */
    public class Solution {
	public int longestValidParentheses(String s) {
	    if (s == null || s.isEmpty()) {
		return 0;
	    }

	    Stack<Integer> lPs = new Stack<Integer>(); // left parentheses
	    int start = 0;
	    int maxLength = 0;
	    
	    for (int i = 0; i < s.length(); i++) {

		if (s.charAt(i) == '(') {
		    lPs.push(i);
		    continue;
		}

		if (lPs.isEmpty()) {
		    start = i + 1;
		} else {
		    lPs.pop();

		    if (lPs.isEmpty()) {
			maxLength = Math.max(i - start + 1, maxLength);
		    } else {
			maxLength = Math.max(i - lPs.peek(), maxLength);
		    }
		}

	    }

	    return maxLength;
	}
    }
    
    /*
     * O(n) solution. One-pass.
     */
    public int longestValidParentheses(String s) {
	if (s == null || s.length() < 2)
	    return 0;

	int maxLen = 0;
	int startIndex = 0;
	Stack<Integer> lParen = new Stack<Integer>();

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '(') {
		lParen.push(i);
	    } else {

		// violation: more rParen than LParen, need to reset startIndex
		if (lParen.isEmpty()) {
		    maxLen = Math.max(maxLen, i - startIndex);
		    startIndex = i + 1;
		} else {
		    /*
		     * update maxLen. In case of situations like ")((()" and
		     * "(()()", the real starting point of this valid
		     * parentheses shall be startIndex or (Index of previous
		     * lParen in stack + 1)
		     */
		    lParen.pop();

		    if (lParen.isEmpty()) {
			maxLen = Math.max(maxLen, i - startIndex + 1);
		    } else {
			maxLen = Math.max(maxLen, i - lParen.peek());
		    }

		}
	    }
	}

	return maxLen;
    }

    /*
     * At the beginning, I wanted to solve it by counting the number of rParen
     * and lParen
     */
    public static int longestValidParenthesesWrong(String s) {
	if (s == null || s.length() < 2)
	    return 0;

	int max = 0;

	// int[] dp = new int[s.length()];

	int rParen = 0;
	int lParen = 0;

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    int curMax = 0;

	    if (c == ')') {
		rParen++;
	    } else {
		lParen++;
	    }

	    if (rParen > lParen) {
		curMax = 0;
		rParen = 0;
		lParen = 0;
	    } else if (rParen == lParen) {
		curMax = rParen * 2;
	    } else {
		curMax = rParen * 2;
	    }

	    max = Math.max(curMax, max);
	}

	return max;
    }
}
