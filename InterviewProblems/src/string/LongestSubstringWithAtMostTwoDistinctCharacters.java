package string;

import java.util.*;

/**
 * Longest Substring with At Most Two Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 */

/*
 * How about for K distinct characters?
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /*
     * Good for k distinct characters
     */
    public class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
	    Map<Character, Integer> map = new HashMap<>();
	    int maxLen = 0;
	    int left = 0;
	    for (int right = 0; right < s.length(); right++) {
		char c = s.charAt(right);
		if (!map.containsKey(c)) {
		    map.put(c, 0);
		}
		map.put(c, map.get(c) + 1);

		if (map.size() > 2) {
		    for (int i = left; i < right; i++) {
			char tmp = s.charAt(i);
			if (map.get(tmp) == 1) {
			    map.remove(tmp);
			    left = i + 1;
			    break;
			} else {
			    map.put(tmp, map.get(tmp) - 1);
			}
		    }
		}

		maxLen = Math.max(maxLen, right - left + 1);
	    }
	    return maxLen;

	}
    }

    /*
     * Only good for 2 distinct characters
     */
    public class Solution2 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
	    int i = 0, j = -1, maxLen = 0;
	    for (int k = 1; k < s.length(); k++) {
		if (s.charAt(k) == s.charAt(k - 1))
		    continue;
		if (j >= 0 && s.charAt(j) != s.charAt(k)) {
		    maxLen = Math.max(k - i, maxLen);
		    i = j + 1;
		}
		j = k - 1;
	    }
	    return Math.max(s.length() - i, maxLen);

	}
    }

}
