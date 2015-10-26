package string;

import java.util.*;

/**
 * Word Pattern II
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Examples:
 * 
 * pattern = "abab", str = "redblueredblue" should return true.
 * 
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * 
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * 
 * Notes: You may assume both pattern and str contains only lowercase letters.
 *
 */
public class WordPatternII {
    public class Solution {
	public boolean wordPatternMatch(String pattern, String str) {
	    if (pattern == null && str == null) {
		return true;
	    } else if (pattern == null || str == null) {
		return false;
	    }

	    return helper(pattern, str, new HashMap<Character, String>(), new HashMap<String, Character>());
	}

	private boolean helper(String pattern, String str, Map<Character, String> map1, Map<String, Character> map2) {
	    if (pattern.isEmpty() || str.isEmpty()) {
		return pattern.isEmpty() && str.isEmpty(); // important
	    }

	    char c = pattern.charAt(0);
	    // return true under two cases
	    for (int i = 1; i <= str.length(); i++) {
		String s = str.substring(0, i);
		if (!map1.containsKey(c) && !map2.containsKey(s)) {
		    map1.put(c, s);
		    map2.put(s, c);
		    if (helper(pattern.substring(1), str.substring(i), map1, map2)) {
			return true;
		    }
		    map1.remove(c);
		    map2.remove(s);
		} else if (map1.containsKey(c) && map2.containsKey(s) && map1.get(c).equals(s) && map2.get(s) == c) {
		    if (helper(pattern.substring(1), str.substring(i), map1, map2)) {
			return true;
		    }
		}
	    }
	    return false; // important
	}
    }
}
