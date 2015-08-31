package string;

import java.util.*;

/**
 * Group Shifted Strings
 * 
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 * 
 * [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 * 
 * Note: For the return value, each inner list's elements must follow the
 * lexicographic order.
 *
 */

public class GroupShiftedStrings {
    public class Solution {
	public List<List<String>> groupStrings(String[] strings) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    
	    // to make sure each inner list in res has lexicographic order
	    Arrays.sort(strings);

	    // value is an index number of res
	    Map<String, Integer> map = new HashMap<String, Integer>();

	    for (String str : strings) {
		String key = getKey(str);
		if (!map.containsKey(key)) {
		    res.add(new ArrayList<String>());
		    map.put(key, res.size() - 1);
		}
		res.get(map.get(key)).add(str);
	    }

	    return res;
	}

	private String getKey(String str) {
	    char[] key = new char[str.length()];
	    for (int i = 0; i < str.length(); i++) {
		int diff = str.charAt(i) - str.charAt(0);
		key[i] = (char) ('a' + (diff < 0 ? 26 + diff : diff));
	    }
	    return new String(key);
	}
    }
}
