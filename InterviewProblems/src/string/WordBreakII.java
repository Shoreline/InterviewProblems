package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

    /*
     * DFS brute force search, use a 'memo' map to cache reusable intermediate
     * results
     */
    public class Solution_DFS {
	public List<String> wordBreak(String s, Set<String> dict) {
	    // String str -> all posssible word break sentences of str in dict
	    Map<String, List<String>> memo = new HashMap<String, List<String>>();

	    return dfs(s, dict, memo);
	}

	private List<String> dfs(String s, Set<String> dict,
		Map<String, List<String>> memo) {

	    if (memo.containsKey(s)) {
		return memo.get(s);
	    }

	    // case String s the whole is a word in dict
	    List<String> res = new ArrayList<String>();
	    if (dict.contains(s)) {
		res.add(s);
	    }

	    /*
	     * cases a subset of s is a word in dict
	     * 
	     * * if set i=0 still can pass leet code?
	     */
	    for (int i = 1; i < s.length(); i++) {
		String formerPiece = s.substring(0, i);
		String latterPiece = s.substring(i);

		if (!dict.contains(latterPiece)) {
		    continue;
		}

		List<String> formerList = dfs(formerPiece, dict, memo);

		for (String str : formerList) {
		    res.add(str + " " + latterPiece);
		}
	    }

	    memo.put(s, res);
	    return res;
	}
    }

    public class Attempt_DP {
	public List<String> wordBreak(String s, Set<String> dict) {
	    List<String> res = new ArrayList<String>();

	    if (s == null || s.length() == 0) {
		res.add("");
		return res;
	    } else if (dict == null || dict.isEmpty()) {
		return res;
	    }

	    Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
	    dp.put(0, new ArrayList<String>(Arrays.asList("")));

	    for (int i = 1; i <= s.length(); i++) {
		dp.put(i, new ArrayList<String>()); // just create a list for
						    // each index
		for (int j = 0; j < i; j++) {
		    String piece = s.substring(j, i);
		    if (dict.contains(piece)) {
			for (String str : dp.get(j)) {
			    dp.get(i).add(str + " " + piece);
			}
		    }
		}
	    }

	    return dp.get(s.length());
	}
    }
}
