package string;

import java.util.*;

/**
 * Palindrome Permutation II
 * 
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 * 
 * Given s = "abc", return [].
 *
 */
public class PalindromePermutationII {
    public class Solution {
	public List<String> generatePalindromes(String s) {
	    List<String> res = new ArrayList<>();
	    Map<Character, Integer> map = new HashMap<>();

	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (!map.containsKey(c)) {
		    map.put(c, 0);
		}
		map.put(c, map.get(c) + 1);
	    }

	    Character odd = null;
	    for (Character c : map.keySet()) {
		int count = map.get(c);
		if (count % 2 == 1) {
		    if (s.length() % 2 == 0 || odd != null) {
			return res;
		    }
		    odd = c;
		}
	    }

	    char[] tmp = new char[s.length()];
	    if (odd != null) {
		tmp[s.length() / 2] = odd;
		map.put(odd, map.get(odd) - 1);
	    }
	    dfs(map, tmp, 0, res);

	    return res;
	}

	private void dfs(Map<Character, Integer> map, char[] tmp, int pos, List<String> res) {
	    if (pos == tmp.length / 2) {
		res.add(new String(tmp));
		return;
	    }

	    for (Character c : map.keySet()) {
		int count = map.get(c);
		if (count > 0) {
		    tmp[pos] = c;
		    tmp[tmp.length - 1 - pos] = c;
		    map.put(c, count - 2);
		    dfs(map, tmp, pos + 1, res);
		    map.put(c, count);
		}
	    }
	}
    }
}
