package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder II
 * 
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given:
 * 
 * start = "hit"
 * 
 * end = "cog"
 * 
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * Return [
 * 
 * ["hit","hot","dot","dog","cog"],
 * 
 * ["hit","hot","lot","log","cog"]
 * 
 * ]
 */

public class WordLadder {
    /*
     * BFS
     * 
     * Use two int variables (curLvlLen and nextLvlLen) to help tracking BFS
     * level
     * 
     * Be careful where to label visited nodes
     */
    public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
	    if ((start == null && end == null)
		    || (start.length() == 0 && end.length() == 0)
		    || dict == null) {
		return 0;
	    }

	    Queue<String> queue = new LinkedList<String>();
	    queue.add(start);
	    int curLvlLen = 1;
	    int nextLvlLen = 0;
	    int ladderLen = 1;
	    Set<String> visited = new HashSet<String>(); // maybe use "addedToQueue" is more precise

	    while (!queue.isEmpty()) {
		String curStr = queue.poll();
		curLvlLen--;
		if (curStr.equals(end)) {
		    return ladderLen;
		}

		Set<String> nextStrings = getNextStrings(curStr, dict, visited);
		for (String str : nextStrings) {
		    queue.add(str);
		    nextLvlLen++;
		    // be careful where to label visited nodes
		    visited.add(curStr);
		}

		// visited.add(curStr); // will cause repeatedly check

		if (curLvlLen == 0) {
		    ladderLen++;
		    curLvlLen = nextLvlLen;
		    nextLvlLen = 0;
		}
	    }
	    return 0;
	}

	private Set<String> getNextStrings(String s, Set<String> dict,
		Set<String> visited) {
	    Set<String> res = new HashSet<String>();
	    for (int i = 0; i < s.length(); i++) {
		char[] cArray = s.toCharArray();
		for (char c = 'a'; c <= 'z'; c++) {
		    cArray[i] = c;
		    String newStr = new String(cArray);
		    if (dict.contains(newStr) && !visited.contains(newStr)) {
			res.add(newStr);
		    }
		}
	    }
	    return res;
	}
    }

    /*
     * Career Cup P480
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
	// Start typing your Java solution below
	// DO NOT write main() function

	if (dict == null || dict.size() == 0) {

	    return 0;
	}

	LinkedList<String> queue = new LinkedList<String>();
	HashSet<String> visited = new HashSet<String>();
	HashMap<String, String> backtrackMap = new HashMap<String, String>();

	queue.add(start);
	visited.add(start);

	while (!queue.isEmpty()) {
	    String word = queue.poll();
	    HashSet<String> possibleWords = getPossibleWords(word);

	    for (String aWord : possibleWords) {

		if (aWord.equals(end)) {

		    ArrayList<String> aList = new ArrayList<String>();
		    aList.add(end);

		    while (word != null) {
			aList.add(word);
			word = backtrackMap.get(word);
		    }

		    return aList.size();
		} else {

		    if (!dict.contains(aWord) || visited.contains(aWord))
			continue;

		    queue.add(aWord);
		    visited.add(aWord);

		    backtrackMap.put(aWord, word);

		}
	    }

	}

	return 0;
    }

    private static HashSet<String> getPossibleWords(String word) {
	HashSet<String> possibleWords = new HashSet<String>();

	for (int i = 0; i < word.length(); i++) {
	    char[] wordArray = word.toCharArray();

	    for (char c = 'a'; c <= 'z'; c++) {
		if (c == word.charAt(i))
		    continue;
		wordArray[i] = c;
		possibleWords.add(new String(wordArray));
	    }
	}

	return possibleWords;

    }

}
