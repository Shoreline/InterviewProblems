package math;

import java.util.*;

/**
 * Expression Add Operators
 * 
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add operators +, -, or * between the digits so they evaluate
 * to the target value.
 * 
 * Examples:
 * 
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * 
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * 
 * "3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperators {
    /*
     * operands must be added BETWEEN digits! So cannot add operand before the
     * whole input numStr
     * 
     * 2*3+2-1 = (2*3) + (2) + (-1) The values in stack is the value of each
     * expression wrapped by parenthesis.
     */
    class Solution {
	public List<String> addOperators(String num, int target) {
	    List<String> result = new ArrayList<String>();
	    dfs(result, "", new Stack<Long>(), num, target);
	    return result;
	}

	private void dfs(List<String> result, String curStr, Stack<Long> stack, String curNumStr, long target) {
	    if (curNumStr.length() == 0) {
		long sum = 0;
		for (int i = 0; i < stack.size(); i++) {
		    sum += stack.elementAt(i);
		}

		if (sum == target) {
		    result.add(curStr);
		}

		return;
	    }

	    for (int i = 1; i <= curNumStr.length(); i++) {
		String tmpNumStr = curNumStr.substring(0, i);

		// tmpNumStr may exceed limit of long. Shall wrap with try-catch
		long tmpNumVal = Long.valueOf(tmpNumStr);

		if (stack.size() == 0) {
		    stack.push(tmpNumVal);
		    dfs(result, tmpNumStr, stack, curNumStr.substring(i), target);
		    stack.pop();
		} else {
		    // 1. *
		    long tmp = stack.peek();
		    stack.push(stack.pop() * tmpNumVal);

		    dfs(result, curStr + "*" + tmpNumStr, stack, curNumStr.substring(i), target);
		    stack.pop();
		    stack.push(tmp); // backtrack *

		    // 2. +
		    stack.push(tmpNumVal);
		    dfs(result, curStr + "+" + tmpNumStr, stack, curNumStr.substring(i), target);
		    stack.pop();

		    // 3. -
		    stack.push(-tmpNumVal);
		    dfs(result, curStr + "-" + tmpNumStr, stack, curNumStr.substring(i), target);
		    stack.pop();
		}

		if (tmpNumVal == 0) {
		    break; // avoid result of "000"/"012" etc
		}
	    }
	}
    }

}
