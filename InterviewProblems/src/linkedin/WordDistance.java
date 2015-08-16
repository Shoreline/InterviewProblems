package linkedin;

import java.util.List;

/**
 * Shortest Word Distance
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
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
 * Follow up: what if this method is called frequently (hashmap?)
 *
 */
public class WordDistance {
    class Solution {
	public int findCloestWordDistance(String s1, String s2, List<String> words) {
	    if (s1 == null || s2 == null || words == null) {
		return -1;
	    }

	    int res = Integer.MAX_VALUE;
	    int index1 = -1;
	    int index2 = -1;

	    for (int i = 0; i < words.size(); i++) {
		if (words.get(i).equals(s1)) {
		    index1 = i;
		}
		if (words.get(i).equals(s2)) {
		    index2 = i;
		}

		if (index1 >= 0 && index2 >= 0) {
		    res = Math.min(res, Math.abs(index1 - index2));
		}

	    }

	    return res;
	}
    }
}
