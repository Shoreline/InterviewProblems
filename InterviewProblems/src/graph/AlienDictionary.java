package graph;

import java.util.*;

/**
 * Alien Dictionary
 * 
 * Total Accepted: 1538 Total Submissions: 8940 Difficulty: Hard
 * 
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language. Derive the order of letters in this language.
 * 
 * For example, Given the following words in dictionary,
 * 
 * [ "wrt",
 * 
 * "wrf",
 * 
 * "er",
 * 
 * "ett",
 * 
 * "rftt" ]
 * 
 * The correct order is: "wertf".
 * 
 * Note: You may assume all letters are in lowercase. If the order is invalid,
 * return an empty string. There may be multiple valid order of letters, return
 * any one of them is fine.
 *
 */
/*
 * Build a directed graph, compute in-degrees for each node (character), then
 * BFS topological sort.
 * 
 * The direction information only relies on comparing the first different set of
 * characters in two words (the order of characters within one word does not
 * mean anything)
 */
public class AlienDictionary {
    public class Solution {
	public String alienOrder(String[] words) {
	    if (words == null || words.length == 0)
		return "";
	    if (words.length == 1)
		return words[0];
	    Map<Character, Set<Character>> graph = buildGraph(words);
	    Map<Character, Integer> indegree = computeIndegree(graph);
	    String res = topoSort(graph, indegree);
	    return res.length() == indegree.size() ? res : "";
	}

	private String topoSort(Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
	    StringBuilder res = new StringBuilder();
	    Queue<Character> queue = new LinkedList<>();
	    for (char c : indegree.keySet()) {
		if (indegree.get(c) == 0) {
		    queue.add(c);
		}
	    }

	    while (!queue.isEmpty()) {
		char c = queue.poll();
		res.append(c);
		for (char to : graph.get(c)) {
		    indegree.put(to, indegree.get(to) - 1);
		    if (indegree.get(to) == 0) {
			queue.add(to);
		    }
		}
	    }
	    return res.toString();
	}

	private Map<Character, Set<Character>> buildGraph(String[] words) {
	    Map<Character, Set<Character>> graph = new HashMap<>();

	    for (int i = 1; i < words.length; i++) {
		String word1 = words[i - 1];
		String word2 = words[i];

		boolean found = false;
		for (int j = 0; j < Math.max(word1.length(), word2.length()); j++) {
		    char c1 = j < word1.length() ? word1.charAt(j) : ' ';
		    char c2 = j < word2.length() ? word2.charAt(j) : ' ';
		    if (c1 != ' ' && !graph.containsKey(c1))
			graph.put(c1, new HashSet<Character>());
		    if (c2 != ' ' && !graph.containsKey(c2))
			graph.put(c2, new HashSet<Character>());
		    if (c1 != ' ' && c2 != ' ' && c1 != c2 && !found) {
			graph.get(c1).add(c2);
			found = true;
		    }
		}
	    }
	    return graph;
	}

	private Map<Character, Integer> computeIndegree(Map<Character, Set<Character>> graph) {
	    Map<Character, Integer> indegree = new HashMap<>();
	    for (Character from : graph.keySet()) {
		if (!indegree.containsKey(from))
		    indegree.put(from, 0);
		for (Character to : graph.get(from)) {
		    if (!indegree.containsKey(to))
			indegree.put(to, 1);
		    else
			indegree.put(to, indegree.get(to) + 1);
		}
	    }
	    return indegree;
	}
    }

}
