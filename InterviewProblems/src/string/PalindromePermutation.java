package string;

import java.util.*;

/**
 * Palindrome Permutation
 * 
 * Given a string, determine if a permutation of the
 * string could form a palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 */
public class PalindromePermutation {
    public class Solution {
	public boolean canPermutePalindrome(String s) {
	    if (s == null || s.length() == 0) {
		return false;
	    }

	    Map<Character, Integer> charCount = new HashMap<>();
	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (!charCount.containsKey(c)) {
		    charCount.put(c, 0);
		}
		charCount.put(c, charCount.get(c) + 1);
	    }

	    boolean hasOdd = false;

	    for (Integer count : charCount.values()) {
		if (count % 2 == 1) {
		    if (s.length() % 2 == 0 || hasOdd) {
			return false;
		    }
		    hasOdd = true;
		}
	    }

	    return true;
	}
    }
}
