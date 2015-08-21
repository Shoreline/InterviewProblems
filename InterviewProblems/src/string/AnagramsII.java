package string;

import java.util.*;

/**
 * Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * Note:
 * 
 * For the return value, each inner list's elements must follow the
 * lexicographic order. All inputs will be in lower-case.
 * 
 * Update (2015-08-09): The signature of the function had been updated to return
 * list<list<string>> instead of list<string>, as suggested here. If you still
 * see your function signature return a list<string>, please click the reload
 * button to reset your code definition.
 *
 */
public class AnagramsII {
    /*
     * O(NlogN) time
     * 
     * Two key points: 1) custom O(N) sorting; 2) Map<String,Integer> to save
     * index
     */
    public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    // sorted str to res index map
	    Map<String, Integer> map = new HashMap<>();
	    Arrays.sort(strs);

	    for (String str : strs) {
		String sortedStr = sort(str);
		if (!map.containsKey(sortedStr)) {
		    res.add(new ArrayList<String>());
		    map.put(sortedStr, res.size() - 1);
		}

		res.get(map.get(sortedStr)).add(str);
	    }

	    return res;
	}

	/*
	 * O(N) sorting time.
	 * 
	 * This method sorts the characters within a given String. It is doable
	 * only because the space of each item (an character) is confined to
	 * between 'a' - 'z'. So the count[] is only of size 26. For regular
	 * sorting, the element space is infinite large, like an number, can be
	 * (-infinite, +infinite)
	 */
	private String sort(String str) {
	    char[] res = new char[str.length()];
	    int[] count = new int[26];
	    for (int i = 0; i < str.length(); i++) {
		count[str.charAt(i) - 'a']++;
	    }

	    int ptr = 0;
	    for (int i = 0; i < count.length; i++) {
		while (count[i] > 0) {
		    res[ptr] = (char) ('a' + i);
		    ptr++;
		    count[i]--;
		}
	    }
	    return new String(res);
	}
    }

    // Strings in the pa is not actually sorted by lexicographic order
    public class Wrong_attempt {
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> res = new ArrayList<List<String>>();
	    // sorted str to res index map
	    Map<String, PriorityQueue<String>> map = new HashMap<>();

	    for (String str : strs) {
		String sortedStr = sort(str);
		if (!map.containsKey(sortedStr)) {
		    map.put(sortedStr, new PriorityQueue<String>());
		}
		map.get(sortedStr).add(str);
	    }

	    for (PriorityQueue<String> pq : map.values()) {
		res.add(new ArrayList<String>(pq));
	    }

	    return res;
	}

	private String sort(String str) {
	    char[] res = new char[str.length()];
	    int[] count = new int[26];
	    for (int i = 0; i < str.length(); i++) {
		count[str.charAt(i) - 'a']++;
	    }

	    int ptr = 0;
	    for (int i = 0; i < count.length; i++) {
		while (count[i] > 0) {
		    res[ptr] = (char) ('a' + i);
		    ptr++;
		    count[i]--;
		}
	    }
	    return new String(res);
	}
    }
}
