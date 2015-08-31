package string;

import java.util.*;

/**
 * Strobogrammatic Number II
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * Hint:
 * 
 * Try to use recursion and notice that it should recurse with n - 2 instead of
 * n - 1.
 *
 */
/*
 * corner case: "00" is not a valid number; the middle char needs to be treated
 * specially while n is odd
 */
public class StrobogrammaticNumberII {
    public class Solution {
	public List<String> findStrobogrammatic(int n) {
	    List<String> res = new ArrayList<>();
	    if (n <= 0) {
		return res;
	    }
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(6, 9);
	    map.put(9, 6);
	    map.put(8, 8);
	    map.put(1, 1);
	    map.put(0, 0);

	    dfs(map, n, 0, new char[n], res);

	    return res;
	}

	private void dfs(Map<Integer, Integer> map, int n, int pos, char[] tmp, List<String> res) {
	    if (pos == n / 2) {
		if (n % 2 == 0) {
		    res.add(new String(tmp));
		} else {
		    tmp[pos] = '0';
		    res.add(new String(tmp));
		    tmp[pos] = '1';
		    res.add(new String(tmp));
		    tmp[pos] = '8';
		    res.add(new String(tmp));
		}
		return;
	    }

	    for (int i : map.keySet()) {
		if (pos == 0 && i == 0) {
		    continue;
		}
		int j = map.get(i);
		tmp[pos] = (char) ('0' + i);
		tmp[n - 1 - pos] = (char) ('0' + j);
		dfs(map, n, pos + 1, tmp, res);
	    }
	}
    }
}
