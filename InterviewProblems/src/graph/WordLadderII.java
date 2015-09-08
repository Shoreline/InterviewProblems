package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
public class WordLadderII {
    
    class Method {
	public List<List<String>> findLadders(String start, String end, Set<String> wordList) {

	    List<List<String>> res = new ArrayList<List<String>>();

	    if (wordList == null || wordList.size() == 0) {
		List<String> aList = new ArrayList<String>();
		res.add(aList);
		return res;
	    }

	    Queue<String> queue = new LinkedList<String>();
	    Set<String> visited = new HashSet<String>();

	    // To get all paths, shall use a HashMap<String, Hash<String>> map!
	    HashMap<String, String> backtrackMap = new HashMap<String, String>();

	    queue.add(start);
	    visited.add(start);

	    while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
		    String word = queue.poll();
		    Set<String> possibleWords = getPossibleWords(word);

		    for (String aWord : possibleWords) {

			if (aWord.equals(end)) {

			    List<String> ans = new ArrayList<String>();
			    ans.add(end);

			    while (word != null) {
				ans.add(word);
				word = backtrackMap.get(word);
			    }
			    Collections.reverse(ans);
			    res.add(ans);

			} else {
			    if (!wordList.contains(aWord) || visited.contains(aWord))
				continue;

			    queue.add(aWord);
			    visited.add(aWord);

			    backtrackMap.put(aWord, word);

			}
		    }
		}
		if (!res.isEmpty()) {
		    return res;
		}
	    }

	    return res;
	}

	private Set<String> getPossibleWords(String word) {
	    Set<String> possibleWords = new HashSet<String>();

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

}
