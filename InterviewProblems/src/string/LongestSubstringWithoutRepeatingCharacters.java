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

public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
	String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!";

	System.out.println(lengthOfLongestSubstring3(s));
    }

    /*
     * Jan 2015
     * O(n), sliding window
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

	    if (charLastPos.containsKey(c)
		    && i - charLastPos.get(c) <= curLength) {
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
	    if (index == 0 && !uniqueSequence.isEmpty()
		    && c != uniqueSequence.get(0)) {
		index = -1;
	    }

	    if (index != -1) {
		uniqueSequence = new ArrayList<Character>(
			uniqueSequence.subList(index + 1, uniqueSequence.size()));
	    }

	    uniqueSequence.add(c);
	    maxLength = Math.max(maxLength, uniqueSequence.size());

	}
	return maxLength;
    }
}
