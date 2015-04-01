package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 *   [
    	["aa","b"],
    	["a","a","b"]
    ]
 * 
 *
 */
/*
 * For problems need to return all possible cases, consider DFS first
 */
public class PalindromePartitioning {
    public class Solution {
	public List<List<String>> partition(String s) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    if (s == null || s.length() == 0) {
		return res;
	    }

	    dfs(s, 0, new ArrayList<String>(), res);

	    return res;
	}

	private void dfs(String s, int pos, List<String> tmp,
		List<List<String>> res) {
	    if (pos == s.length()) {
		res.add(new ArrayList<String>(tmp));
		return;
	    }

	    for (int i = pos + 1; i <= s.length(); i++) {
		String piece = s.substring(pos, i);
		if (!isPalindrome(piece)) {
		    continue;
		}

		tmp.add(piece);
		dfs(s, i, tmp, res);
		tmp.remove(tmp.size() - 1);
	    }
	}

	private boolean isPalindrome(String s) {
	    int i = 0;
	    int j = s.length() - 1;
	    while (i < j) {
		if (s.charAt(i) != s.charAt(j)) {
		    return false;
		}
		i++;
		j--;
	    }

	    return true;
	}

    }
}
