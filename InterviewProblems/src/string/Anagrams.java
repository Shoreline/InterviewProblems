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
    public class Solution {
	private int getHash(int[] count) {
	    int hash = 0;
	    int a = 378551;
	    int b = 63689;
	    for (int num : count) {
		hash = hash * a + num;
		a = a * b;
	    }
	    return hash;
	}

	public ArrayList<String> anagrams(String[] strs) {
	    ArrayList<String> result = new ArrayList<String>();
	    HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	    for (String str : strs) {
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
		    count[str.charAt(i) - 'a']++;
		}

		int hash = getHash(count);
		if (!map.containsKey(hash)) {
		    map.put(hash, new ArrayList<String>());
		}

		map.get(hash).add(str);
	    }

	    for (ArrayList<String> tmp : map.values()) {
		if (tmp.size() > 1) {
		    result.addAll(tmp);
		}
	    }

	    return result;
	}
    }

    /*
     * The goal is to output all Strings that has more than one anagram in given
     * String[].
     * 
     * The sorted char array of two anagrams are the same. So use it as key to
     * group Strings.
     */
    public class Solution_slow {
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
