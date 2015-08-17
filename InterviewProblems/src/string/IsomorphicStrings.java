package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example,
 * 
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {
    public class Solution_simple {
	public boolean isIsomorphic(String s, String t) {
	    if (s == null && t == null || (s.length() == 0 && t.length() == 0)) {
		return true;
	    }
	    if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() != t.length()) {
		return false;
	    }

	    Map<Character, Character> mapST = new HashMap<>();
	    Map<Character, Character> mapTS = new HashMap<>();
	    for (int i = 0; i < s.length(); i++) {
		char cs = s.charAt(i);
		char ct = t.charAt(i);
		if (mapST.containsKey(cs) && mapST.get(cs) != ct || (mapTS.containsKey(ct) && mapTS.get(ct) != cs)) {
		    return false;
		}
		mapST.put(cs, ct);
		mapTS.put(ct, cs);
	    }

	    return true;
	}
    }

    public class Solution {
	public boolean isIsomorphic(String s, String t) {
	    if (s.length() == 0 && t.length() == 0) {
		return true;
	    }

	    Map<Character, Character> map = new HashMap<>();
	    Set<Character> valueSet = new HashSet<>();
	    for (int i = 0; i < s.length(); i++) {
		char sc = s.charAt(i);
		char tc = t.charAt(i);

		if ((map.containsKey(sc) && map.get(sc) != tc) || (!map.containsKey(sc) && valueSet.contains(tc))) {
		    return false;
		} else {
		    map.put(sc, tc);
		    valueSet.add(tc);
		}
	    }

	    return true;
	}
    }

    public class Solution2 {
	public boolean isIsomorphic(String s, String t) {
	    if (s == null || s.length() == 0) {
		return true;
	    }

	    Map<Character, Character> map = new HashMap<Character, Character>();
	    Set<Character> set = new HashSet<Character>();
	    for (int i = 0; i < s.length(); i++) {
		char cs = s.charAt(i);
		char ct = t.charAt(i);
		if (!map.containsKey(cs)) {
		    if (set.contains(ct)) {
			return false;
		    }
		    map.put(cs, ct);
		    set.add(ct);
		} else if (map.get(cs) != ct) {
		    return false;
		}
	    }

	    return true;
	}
    }
}
