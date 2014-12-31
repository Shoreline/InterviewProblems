package string;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Longest Substring Without Repeating Characters
     * 
     * Given a string, find the length of the longest substring without
     * repeating characters. For example, the longest substring without
     * repeating letters for "abcabcbb" is "abc", which the length is 3. For
     * "bbbbb" the longest substring is "b", with the length of 1.
     */

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

	    if (pos.get(c) == null || pos.get(c) == -1) {
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

	int max = 0;
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
	    max = Math.max(max, uniqueSequence.size());

	}
	return max;
    }
}
