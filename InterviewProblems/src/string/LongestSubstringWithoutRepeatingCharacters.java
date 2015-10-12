package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */
/*
 * Two solutions: traditional sliding window; or charLastPos map.
 * 
 * sliding window: http://blog.csdn.net/linhuanmars/article/details/19949159
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public class Solution {
	public int lengthOfLongestSubstring(String s) {
	    if (s == null) {
		return 0;
	    }

	    Map<Character, Integer> lastPos = new HashMap<>();
	    int len = 0;
	    int maxLen = 0;

	    int i = 0;
	    while (i < s.length()) {
		Character c = s.charAt(i);
		if (lastPos.containsKey(c) && (i - lastPos.get(c)) <= len) {
		    len = i - lastPos.get(c) - 1;
		}
		lastPos.put(c, i);
		len++;
		maxLen = Math.max(maxLen, len);
		i++;
	    }

	    return maxLen;
	}
    }

    /*
     * classic sliding window using for loop
     */
    public class Solution_sliding_windw {
	public int lengthOfLongestSubstring(String s) {
	    if (s == null || s.isEmpty()) {
		return 0;
	    }

	    Map<Character, Integer> lastPos = new HashMap<>();
	    int max = 1;
	    int left = 0;
	    for (int right = 0; right < s.length(); right++) {
		char c = s.charAt(right);
		// condition easy to forget: lastPos.get(c) >= left
		if (lastPos.containsKey(c) && lastPos.get(c) >= left) {
		    max = Math.max(max, right - left);
		    left = lastPos.get(c) + 1;
		}
		lastPos.put(c, right);
	    }

	    max = Math.max(max, s.length() - left);

	    return max;
	}
    }

    /*
     * Jan 2015 O(n), sliding window
     */
    public static int lengthOfLongestSubstring3(String s) {
	if (s == null || s.length() == 0)
	    return 0;

	int maxLength = 0;
	int curLength = 0;
	Map<Character, Integer> charLastPos = new HashMap<Character, Integer>();

	int i = 0;
	while (i < s.length()) {
	    char c = s.charAt(i);

	    if (charLastPos.containsKey(c) && i - charLastPos.get(c) <= curLength) {
		// find a repeated char, curLength will be changed
		maxLength = Math.max(curLength, maxLength);
		curLength = i - charLastPos.get(c);
	    } else {
		curLength++;
	    }
	    charLastPos.put(c, i);
	    i++;
	}
	maxLength = Math.max(curLength, maxLength);
	return maxLength;
    }

    /*
     * second round. 2 time pass
     * 
     * similar as the first round, use a sliding window
     */
    public int lengthOfLongestSubstring2(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (s == null || s.length() == 0)
	    return 0;

	HashMap<Character, Integer> pos = new HashMap<Character, Integer>();

	int i = 0;
	int j = 0;
	int max = 1;

	while (j < s.length()) {
	    char c = s.charAt(j);

	    if (!pos.containsKey(c) || pos.get(c) == -1) {
		pos.put(c, j);
	    } else {
		pos.put(c, j);
		for (int k = i; k < j; k++) {
		    if (s.charAt(k) != c) {
			pos.put(s.charAt(k), -1);
			i++;
		    } else {
			i++;
			break;
		    }
		}

	    }

	    max = Math.max(max, j - i + 1);
	    j++;

	}

	return max;
    }

    /*
     * One time pass
     * 
     * The code is a little bit messy in order to save some search time
     * 
     * Used an ArrayList<Character> to store current unique sequence
     * 
     * Can use a HashMap<Character, Integer> uniqueSequence to store character
     * and its position in s
     */

    public static int lengthOfLongestSubstring(String s) {
	if (s == null || s.length() == 0)
	    return 0;

	int maxLength = 0;
	ArrayList<Character> uniqueSequence = new ArrayList<Character>();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    int index = uniqueSequence.indexOf(c);

	    /*
	     * the if block below judges if the list uniqueSequence does not
	     * contain char c
	     */
	    if (index == 0 && !uniqueSequence.isEmpty() && c != uniqueSequence.get(0)) {
		index = -1;
	    }

	    if (index != -1) {
		uniqueSequence = new ArrayList<Character>(uniqueSequence.subList(index + 1, uniqueSequence.size()));
	    }

	    uniqueSequence.add(c);
	    maxLength = Math.max(maxLength, uniqueSequence.size());

	}
	return maxLength;
    }
}
