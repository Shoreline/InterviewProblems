package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */

/*
 * DP is complicated to implement and did not improve time complexity, comparing
 * to recursion (DFS).
 */
public class WordBreakII {

    /*
     * DFS brute force search, use a 'memo' map to cache reusable intermediate
     * results
     */
    public class Solution {
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

	    for (int i = 1; i < s.length(); i++) {
		String word = s.substring(0, i);
		if (!dict.contains(word)) {
		    continue;
		}

		String rest = s.substring(i);
		List<String> restList = dfs(rest, dict, memo);

		for (String str : restList) {
		    res.add(word + " " + str);
		}
	    }

	    memo.put(s, res);
	    return res;
	}
    }

    /*
     * TLE.
     * 
     * Using StringBuilder is better than substring.
     */
    public class Solution_simple_DFS {
	public List<String> wordBreak(String s, Set<String> wordDict) {
	    List<String> res = new ArrayList<String>();
	    if (s == null) {
		return res;
	    }
	    dfs(s, wordDict, 0, "", res);
	    return res;
	}

	private void dfs(String s, Set<String> wordDict, int pos, String tmp,
		List<String> res) {
	    if (pos == s.length()) {
		res.add(tmp);
		return;
	    }

	    StringBuilder sb = new StringBuilder();
	    for (int i = pos; i < s.length(); i++) {
		sb.append(s.charAt(i));

		if (wordDict.contains(sb.toString())) {
		    String next = tmp.isEmpty() ? sb.toString() : tmp + " "
			    + sb.toString();
		    dfs(s, wordDict, i + 1, next, res);
		}
	    }
	}
    }

    /*
     * TLE for extreme testing cases
     */
    public class Method_simple_DFS2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
	    List<String> res = new ArrayList<String>();
	    if (s == null) {
		return res;
	    }
	    dfs(s, wordDict, 0, "", res);
	    return res;
	}

	private void dfs(String s, Set<String> wordDict, int pos, String tmp,
		List<String> res) {
	    if (pos == s.length()) {
		res.add(tmp);
		return;
	    }

	    for (int i = pos + 1; i <= s.length(); i++) {
		String word = s.substring(pos, i);
		if (wordDict.contains(word)) {
		    String next = tmp.isEmpty() ? word : tmp + " " + word;
		    dfs(s, wordDict, i, next, res);
		}
	    }
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
