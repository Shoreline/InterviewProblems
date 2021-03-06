package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class RestoreIPAddresses {
    /*
     * DFS + backtracking
     * 
     * Use a list<String> to save Ip pieces
     */
    public class Solution {
	public List<String> restoreIpAddresses(String s) {
	    List<String> res = new ArrayList<>();
	    if (s == null) {
		return res;
	    }

	    dfs(s, 0, new ArrayList<String>(), res);

	    return res;
	}

	private void dfs(String s, int pos, List<String> tmp, List<String> res) {
	    if (pos == s.length() && tmp.size() == 4) {
		StringBuilder sb = new StringBuilder();
		for (String str : tmp) {
		    sb.append(str);
		    sb.append(".");
		}
		sb.setLength(sb.length() - 1);
		res.add(sb.toString());
		return;
	    } else if (tmp.size() > 4) {
		return;
	    }

	    for (int i = pos + 1; i <= s.length() && i <= pos + 3; i++) {
		String str = s.substring(pos, i);
		if ((str.charAt(0) == '0' && str.length() > 1)
			|| Integer.valueOf(str) > 255) {
		    continue;
		}

		tmp.add(str);
		dfs(s, i, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    /*
     * Shall have a more concise version
     */
    public class Solution_loops {
	public List<String> restoreIpAddresses(String s) {
	    List<String> res = new ArrayList<String>();
	    if (s == null || s.length() == 0) {
		return res;
	    }

	    int len = s.length();
	    for (int i = 1; i <= 3 && i < len; i++) {
		if (!isValid(s, 0, i)) {
		    continue;
		}

		for (int j = i + 1; j <= i + 3 && j < len; j++) {
		    if (!isValid(s, i, j)) {
			continue;
		    }

		    for (int k = j + 1; k <= j + 3 && k < len; k++) {
			if (!isValid(s, j, k)) {
			    continue;
			}

			if (!isValid(s, k, len)) {
			    continue;
			}
			res.add(s.substring(0, i) + '.' + s.substring(i, j)
				+ '.' + s.substring(j, k) + '.'
				+ s.substring(k, len));

		    }
		}
	    }
	    return res;
	}

	// need to check if 'end > start+3'; otherwise may exceed Integer length
	// limit
	private boolean isValid(String s, int start, int end) {
	    if ((s.charAt(start) == '0' && end > start + 1) || end > start + 3
		    || Integer.parseInt(s.substring(start, end)) > 255) {
		return false;
	    }

	    return true;
	}

    }

    public class Solution_DFS {
	public List<String> restoreIpAddresses(String s) {
	    List<String> res = new ArrayList<String>();
	    if (s == null) {
		return res;
	    }

	    dfs(s, 0, new ArrayList<String>(), res);

	    return res;
	}

	private void dfs(String s, int pos, List<String> tmp, List<String> res) {
	    if (tmp.size() == 4) {
		if (pos == s.length()) {
		    StringBuilder sb = new StringBuilder();
		    for (String num : tmp) {
			sb.append(num);
			sb.append(".");
		    }
		    sb.setLength(sb.length() - 1);
		    res.add(sb.toString());
		}
		return;
	    }

	    for (int i = pos; i < s.length() && i < pos + 3; i++) {
		String num = s.substring(pos, i + 1);
		if (isValid(num)) {
		    tmp.add(num);
		    dfs(s, i + 1, tmp, res);
		    tmp.remove(tmp.size() - 1);
		}
	    }

	}

	boolean isValid(String num) {
	    if ((num.length() > 1 && num.charAt(0) == '0')
		    || Integer.parseInt(num) > 255) {
		return false;
	    }

	    return true;
	}
    }

    /*
     * The actual addresses are required. DP can only give the number of
     * possible addresses. So, recursion?
     * 
     * Recursion. Each time cut a possible segment and check if the rest String
     * is still possible for part of an IP address
     * 
     * rule for each segment:
     * 
     * 1. if length >1, first digit cannot be 0.
     * 
     * 2. cannot exceed 255
     * 
     * rule for the rest sub-string:
     * 
     * length must bigger than (remaining segNum-1);
     * 
     * length must smaller than 3*(remaining segNum)
     */
    class Solution_2013 {
	public ArrayList<String> restoreIpAddresses(String s) {
	    ArrayList<String> result = new ArrayList<String>();
	    int segNum = 4;

	    result = restoreIpAddresses(s, segNum);

	    return result;
	}

	private ArrayList<String> restoreIpAddresses(String s, int segNum) {
	    ArrayList<String> result = new ArrayList<String>();

	    if (s.length() == 0) {
		return result;
	    }

	    if (segNum == 1) {
		if (s.length() <= 3 && s.length() > 0) {

		    if (Integer.valueOf(s) > 256) {
			return result;
		    }

		    if (s.length() > 1 && s.charAt(0) == '0') {
			return result;
		    }

		    result.add(s);
		    return result;
		}
	    }

	    for (int i = s.length() - 1; i >= s.length() - 3; i--) {
		if (!canCut(s, segNum - 1, i)) {
		    continue;
		}
		String aSeg = s.substring(i, s.length());

		ArrayList<String> temp = restoreIpAddresses(s.substring(0, i),
			segNum - 1);
		for (String aString : temp) {
		    String newString = aString + "." + aSeg;
		    result.add(newString);
		}
	    }

	    return result;
	}

	private boolean canCut(String s, int segNum, int index) {
	    if (index <= (segNum - 1) || index > 3 * segNum) {
		return false;
	    }
	    if (Integer.valueOf(s.substring(index, s.length())) > 255) {
		return false;
	    }
	    if (s.length() - index > 1 && s.charAt(index) == '0') {
		return false;
	    }

	    return true;
	}
    }
}
