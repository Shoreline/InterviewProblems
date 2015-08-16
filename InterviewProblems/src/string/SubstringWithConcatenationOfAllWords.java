package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Substring with Concatenation of All Words
 * 
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given:
 * 
 * S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */

/*
 * Compare word histograms between toFind and Found
 */
public class SubstringWithConcatenationOfAllWords {
    public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
	    List<Integer> res = new ArrayList<>();
	    if (s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
		return res;
	    }
	    Map<String, Integer> toFind = new HashMap<>();
	    Map<String, Integer> found = new HashMap<>();

	    for (String word : words) {
		if (!toFind.containsKey(word)) {
		    toFind.put(word, 0);
		}
		toFind.put(word, toFind.get(word) + 1);
	    }

	    int size = words[0].length();
	    for (int i = 0; i + words.length * size <= s.length(); i++) {
		found.clear();
		boolean hasAllWords = true;
		for (int j = i; j < i + words.length * size; j += size) {
		    String word = s.substring(j, j + size);
		    found.put(word, found.containsKey(word) ? found.get(word) + 1 : 1);
		    if (toFind.get(word) == null || toFind.get(word) < found.get(word)) {
			hasAllWords = false;
			break;
		    }
		}
		if (hasAllWords) {
		    res.add(i);
		}
	    }

	    return res;
	}
    }

}
