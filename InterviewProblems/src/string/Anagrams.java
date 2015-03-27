package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
    /**
     * Anagrams
     * 
     * Given an array of strings, return all groups of strings that are
     * anagrams.
     * 
     * Note: All inputs will be in lower-case.
     */
    /*
     * The goal is to output all Strings that has at least one more anagram in given String[].
     * 
     * The sorted char array of two anagrams are the same. So use it as key to group Strings.
     */
    public class Solution {
	public List<String> anagrams(String[] strs) {
	    List<String> res = new ArrayList<String>();
	    if (strs == null) {
		return res;
	    }

	    Map<String, List<String>> sortedStrMap = new HashMap<String, List<String>>();
	    for (String str : strs) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		String sortedStr = new String(charArray);

		if (!sortedStrMap.containsKey(sortedStr)) {
		    sortedStrMap.put(sortedStr, new ArrayList<String>());
		}

		sortedStrMap.get(sortedStr).add(str);
	    }

	    // cannot compile in LeetCode
//	    Iterator<Entry<String, List<String>>> itr = sortedStrMap.entrySet().iterator();
//	    while (itr.hasNext()) {
//		Entry<String, List<String>> entry = itr.next();
//		if (entry.getValue().size() > 1) {
//		    res.addAll(entry.getValue());
//		}
//	    }
	    
	    for (List<String> list : sortedStrMap.values()) {
		if (list.size() > 1) {
		    res.addAll(list);
		}
	    }

	    return res;
	}
    }   
}
