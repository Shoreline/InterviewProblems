package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    /**
     * Substring with Concatenation of All Words
     * 
     * You are given a string, S, and a list of words, L, that are all of the
     * same length. Find all starting indices of substring(s) in S that is a
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
     * My thoughts: find all positions for each String in L, then see if the can
     * be concatenated to S -- Too complicated?
     * 
     * A much simple way: check all possible windows, see if anyone of them
     * contains all Strings in L --> slow, but can pass the largest
     */
    public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
	    List<Integer> res = new ArrayList<Integer>();
	    if (S == null || S.length() == 0 || L == null || L.length == 0) {
		return res;
	    }

	    Map<String, Integer> wordCount = new HashMap<String, Integer>();
	    for (String word : L) {
		wordCount.put(word,
			(wordCount.containsKey(word) ? wordCount.get(word) + 1
				: 1));
	    }

	    int wordSize = L[0].length();
	    int slideWindowLength = wordSize * L.length;

	    for (int i = 0; i <= S.length() - slideWindowLength; i++) {
		String slideWindow = S.substring(i, i + slideWindowLength);

		Map<String, Integer> winWordCount = new HashMap<String, Integer>();
		for (int j = 0; j < slideWindowLength; j += wordSize) {
		    String word = slideWindow.substring(j, j + wordSize);
		    if (wordCount.containsKey(word)) {
			winWordCount.put(
				word,
				(winWordCount.containsKey(word) ? winWordCount
					.get(word) + 1 : 1));
		    } else {
			break;
		    }
		}
		if (winWordCount.equals(wordCount)) {
		    res.add(i);
		}
	    }

	    return res;
	}
    }
    
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (S == null || S.length() == 0 || L == null || L.length == 0)
	    return result;

	int totalLength = L.length * L[0].length();
	if (S.length() < totalLength)
	    return result;
	/*
	 * use HashMap to accelerate searching
	 * 
	 * Build two HashMaps. Cannot use HashSet since there may be duplicate
	 * Strings in array L
	 */
	HashMap<String, Integer> strCount = new HashMap<String, Integer>();
	for (int i = 0; i < L.length; i++) {
	    if (strCount.containsKey(L[i])) {
		strCount.put(L[i], strCount.get(L[i]) + 1);
	    } else {
		strCount.put(L[i], 1);
	    }
	}

	// detail!
	for (int i = 0; i + totalLength < S.length() + 1; i++) {
	    String subS = S.substring(i, i + totalLength);

	    HashMap<String, Integer> strFound = new HashMap<String, Integer>();

	    // detail!
	    for (int j = 0; j < totalLength; j = j + L[0].length()) {
		String s = subS.substring(j, j + L[0].length());
		if (!strCount.containsKey(s))
		    break;
		// record Strings seen in this substring
		if (strFound.containsKey(s)) {
		    strFound.put(s, strFound.get(s) + 1);
		} else {
		    strFound.put(s, 1);
		}

	    }
	    /*
	     * In the end, compare if two HashMap are equivalent
	     */
	    if (strFound.equals(strCount))
		result.add(i);
	}

	return result;
    }

    public ArrayList<Integer> findSubstringUnfinished(String S, String[] L) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (S == null || S.length() == 0 || L == null || L.length == 0)
	    return result;
	if (S.length() < L.length * L[0].length())
	    return result;

	// ArrayList<String> haha = new ArrayList<String>(Arrays.asList(L));
	HashSet<String> strings = new HashSet<String>(Arrays.asList(L));

	HashMap<String, ArrayList<Integer>> posMap = new HashMap<String, ArrayList<Integer>>();
	for (int i = 0; i < S.length() - L[0].length(); i++) {
	    String s = S.substring(i, L[0].length());
	    if (strings.contains(s)) {
		if (posMap.get(s) == null) {
		    ArrayList<Integer> newList = new ArrayList<Integer>();
		    newList.add(i);
		    posMap.put(s, newList);
		} else {
		    ArrayList<Integer> aList = posMap.get(s);
		    aList.add(i);
		}
	    }
	}

	/*
	 * check if there is a result
	 */
	ArrayList<Integer> temp = new ArrayList<Integer>();
	for (ArrayList<Integer> aList : posMap.values()) {
	    if (aList == null)
		return result;
	    temp.addAll(aList);
	}

	// see if there is a possible result
	Collections.sort(temp);
	for (int i = 0; i < temp.size(); i++) {
	    boolean isAPath = true;
	    for (int j = i; j < temp.size(); j++) {
		if (temp.size() - j < S.length()) {
		    break;
		}

	    }
	}

	return result;
    }

    private ArrayList<Integer> findPath(
	    HashMap<String, ArrayList<Integer>> posMap) {
	ArrayList<Integer> result = new ArrayList<Integer>();

	return result;

    }
}
