package string;

import java.util.*;

/**
 * Word Pattern
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * 
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * 
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * 
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * Notes: You may assume pattern contains only lowercase letters, and str
 * contains lowercase letters separated by a single space.
 *
 */
public class WordPattern {
    /*
     * use equals() to compare Strings;
     * 
     * null has no equals() method
     */
    public class Solution {
	public boolean wordPattern(String pattern, String str) {
	    if (pattern == null && str == null) {
		return true;
	    } else if (pattern == null || str == null) {
		return false;
	    }

	    Map<Character, String> map1 = new HashMap<>();
	    Map<String, Character> map2 = new HashMap<>();

	    char[] patterns = pattern.toCharArray();
	    String[] strs = str.split(" ");

	    if (patterns.length != strs.length) {
		return false;
	    }

	    for (int i = 0; i < patterns.length; i++) {
		if (!map1.containsKey(patterns[i]) && !map2.containsKey(strs[i])) {
		    map1.put(patterns[i], strs[i]);
		    map2.put(strs[i], patterns[i]);
		} else if (!map1.containsKey(patterns[i]) || !map2.containsKey(strs[i])) {
		    return false;
		} else if (!map1.get(patterns[i]).equals(strs[i]) || map2.get(strs[i]) != patterns[i]) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
