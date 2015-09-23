package linkedin;

/**
 * Shortest Word Distance III
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * 
 * Given word1 = "makes", word2 = "makes", return 3.
 */
public class WordDistanceIII {
    public class Solution {
	public int shortestWordDistance(String[] words, String word1, String word2) {
	    int res = Integer.MAX_VALUE;
	    int pos1 = -1;
	    int pos2 = -1;
	    for (int i = 0; i < words.length; i++) {
		if (words[i].equals(word2)) {
		    pos2 = word1.equals(word2) ? pos1 : i;
		}

		if (words[i].equals(word1)) {
		    pos1 = i;
		}

		if (pos1 >= 0 && pos2 >= 0) {
		    res = Math.min(res, Math.abs(pos1 - pos2));
		}

	    }

	    return res;
	}
    }
}
