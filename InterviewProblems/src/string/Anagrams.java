package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Anagrams
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {
    /*
     * The goal is to output all Strings that has more than one anagram in given
     * String[].
     * 
     * The sorted char array of two anagrams are the same. So use it as key to
     * group Strings.
     */
    public class Solution {
	public List<String> anagrams(String[] strs) {
	    List<String> res = new ArrayList<>();
	    if (strs == null || strs.length == 0) {
		return res;
	    }
	    Map<String, List<String>> sortedMap = new HashMap<String, List<String>>();

	    for (String str : strs) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		String key = new String(charArray);
		if (!sortedMap.containsKey(key)) {
		    sortedMap.put(key, new ArrayList<String>());
		}
		sortedMap.get(key).add(str);
	    }

	    // cannot compile in LeetCode
	    // Iterator<Entry<String, List<String>>> itr = sortedMap.entrySet()
	    // .iterator();
	    // while (itr.hasNext()) {
	    // Entry<String, List<String>> entry = itr.next();
	    // if (entry.getValue().size() > 1) {
	    // res.addAll(entry.getValue());
	    // }
	    // }
	    for (List<String> list : sortedMap.values()) {
		if (list.size() > 1) {
		    res.addAll(list);
		}
	    }
	    return res;
	}
    }

}
