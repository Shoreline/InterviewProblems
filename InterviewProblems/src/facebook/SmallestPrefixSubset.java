package facebook;

import java.util.*;

/**
 * Given a set of strings, return the smallest subset that contains prefixes for
 * every string.
 * 
 * If the list is ['foo', 'foog', 'food', 'asdf'] return ['foo', 'asdf']
 *
 */

/*
 * 1. Use a Trie:
 * 
 * a). 先对原来的list建一个trie
 * 
 * b) 从trie的root开始做BFS，有非空的child就往下走，直到找到第一个是词的child, 那么这个branch就可在此结束.
 * 在这个过程中把path放到result中.
 * 
 * -> But implementing a Trie is too troublesome.
 */
public class SmallestPrefixSubset {

    /*
     * time: O(Nk). k is the largest word length in the input list.
     */
    class Method_noTrie {
	public List<String> smallestPrefixSubset(String[] input) {
	    List<String> res = new ArrayList<>();
	    if (input == null || input.length == 0) {
		return res;
	    }

	    Set<String> words = new HashSet<>();
	    words.addAll(Arrays.asList(input));

	    for (String word : input) {
		boolean add = true;
		for (int i = 0; i < word.length(); i++) {
		    String prefix = word.substring(0, word.length() - 1 - i);
		    if (words.contains(prefix)) {
			add = false;
			break;
		    }
		}

		if (add) {
		    res.add(word);
		}
	    }

	    return res;
	}
    }

}
