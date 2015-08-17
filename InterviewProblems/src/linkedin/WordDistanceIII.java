package linkedin;

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
