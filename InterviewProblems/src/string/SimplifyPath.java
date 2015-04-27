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
 * Convert a stack to array: Have to include its type info:
 * stack.toArray(new String[stack.size()])
 */
public class SimplifyPath {

    public class Solution {
	public String simplifyPath(String path) {
	    if (path == null || path.length() == 0) {
		return "";
	    }

	    StringBuilder res = new StringBuilder();
	    Stack<String> stack = new Stack<String>();
	    for (String subPath : path.split("/")) {
		if (subPath.length() == 0 || subPath.equals(".")) {
		    continue;
		} else if (subPath.equals("..")) {
		    if (!stack.isEmpty()) {
			stack.pop();
		    }
		}
		// else if(subPath.equals("..") && !stack.isEmpty()){
		// stack.pop();
		// }
		else {
		    stack.push(subPath);
		}
	    }

	    if (stack.isEmpty()) {
		return "/";
	    }

	    for (String subPath : stack.toArray(new String[stack.size()])) {
		res.append('/');
		res.append(subPath);
	    }

	    return res.toString();
	}
    }
}
