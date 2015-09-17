package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print longest possible substring that has exactly
 * M unique characters. If there are more than one substring of longest possible
 * length, then print any one of them.
 * 
 * Examples:
 * 
 * "aabbcc", k = 1 Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * "aabbcc", k = 2 Max substring can be any one from {"aabb" , "bbcc"}.
 * 
 * "aabbcc", k = 3 There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } Max is "aabbcc" with length 6.
 * 
 * "aaabbb", k = 3 There are only two unique characters, thus show error
 * message.
 *
 */
/*
 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-
 * characters-in-a-given-string/
 * 
 * Method 2 (Linear Time) The problem can be solved in O(n). Idea is to maintain
 * a window and add elements to the window till it contains less or equal k,
 * update our result if required while doing so. If unique elements exceeds than
 * required in window, start removing the elements from left side.
 */
public class LongestSubstringWithKDistinctCharacters {
    /*
     * HashMap<char, Integer> map. Keep map to have no more than 3 entries
     */
    public class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
	    Map<Character, Integer> map = new HashMap<>();
	    int maxLen = 0;
	    int left = 0;
	    for (int right = 0; right < s.length(); right++) {
		char c = s.charAt(right);
		if (!map.containsKey(c)) {
		    map.put(c, 0);
		}
		map.put(c, map.get(c) + 1);

		if (map.size() > k) {
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
}
