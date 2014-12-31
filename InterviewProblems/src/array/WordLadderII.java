package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderII {
    /**
     * Word Ladder II
     * 
     * Given two words (start and end), and a dictionary, find all shortest
     * transformation sequence(s) from start to end, such that:
     * 
     * Only one letter can be changed at a time Each intermediate word must
     * exist in the dictionary For example,
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

    public static ArrayList<ArrayList<String>> findLadders(String start,
	    String end, HashSet<String> dict) {
	// Start typing your Java solution below
	// DO NOT write main() function

	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	if (dict == null || dict.size() == 0) {
	    ArrayList<String> aList = new ArrayList<String>();
	    result.add(aList);
	    return result;
	}

	LinkedList<String> queue = new LinkedList<String>();
	HashSet<String> visited = new HashSet<String>();

	// To get all paths, shall use a HashMap<String, Hash<String>> map!
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
		    Collections.reverse(aList);
		    result.add(aList);
		} else {

		    if (!dict.contains(aWord) || visited.contains(aWord))
			continue;

		    queue.add(aWord);
		    visited.add(aWord);

		    backtrackMap.put(aWord, word);

		}
	    }

	}

	return result;
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
