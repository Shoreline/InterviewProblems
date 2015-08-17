package linkedin;

import java.util.*;

/**
 * Shortest Word Distance II
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 *
 */

/*
 * Two additional maps: indexMap (necessary) and ans (optional, used to cache
 * known results)
 */
public class WordDistanceII {
    class Solution {
	public class WordDistance {
	    private Map<String, List<Integer>> indexMap;
	    private Map<String, Integer> ans;

	    public WordDistance(String[] words) {
		ans = new HashMap<String, Integer>();
		indexMap = new HashMap<String, List<Integer>>();
		for (int i = 0; i < words.length; i++) {
		    if (!indexMap.containsKey(words[i])) {
			indexMap.put(words[i], new ArrayList<Integer>());
		    }
		    indexMap.get(words[i]).add(i);
		}
	    }

	    public int shortest(String word1, String word2) {
		String combined = word1 + word2;
		if (ans.get(combined) != null) {
		    return ans.get(combined);
		}

		List<Integer> indice1 = indexMap.get(word1);
		List<Integer> indice2 = indexMap.get(word2);
		int i = 0;
		int j = 0;
		int res = Integer.MAX_VALUE;

		while (i < indice1.size() && j < indice2.size()) {
		    res = Math.min(res, Math.abs(indice1.get(i) - indice2.get(j)));
		    if (indice1.get(i) < indice2.get(j)) {
			i++;
		    } else {
			j++;
		    }
		}

		ans.put(word1 + word2, res);
		ans.put(word2 + word1, res);

		return res;
	    }
	}
    }
}
