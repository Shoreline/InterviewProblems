package string;

import java.util.Stack;

/**
 * Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home"
 * 
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 */

/*
 * Convert a stack to array: Have to include its type info: stack.toArray(new
 * String[stack.size()])
 * 
 * The input path may not totally in correct format, so be aware of corner cases: ignore ".." if the stack is empty 
 */
public class SimplifyPath {
    public class Solution {
	public String simplifyPath(String path) {
	    if (path == null) {
		return "";
	    }

	    Stack<String> stack = new Stack<>();
	    for (String p : path.split("/")) {
		if (p.isEmpty() || p.equals(".")) {
		    continue;
		} else if (p.equals("..")) {
		    if (!stack.isEmpty()) {
			stack.pop();
		    }
		} else {
		    stack.push(p);
		}
	    }

	    if (stack.isEmpty()) {
		return "/";
	    }

	    StringBuilder res = new StringBuilder();
	    for (String p : stack.toArray(new String[stack.size()])) {
		res.append('/');
		res.append(p);
	    }
	    return res.toString();
	}
    }
}
