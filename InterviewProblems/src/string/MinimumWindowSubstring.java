package string;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubstring {
    /**
     * Minimum Window Substring
     * 
     * Given a string S and a string T, find the minimum window in S which will
     * contain all the characters in T in complexity O(n).
     * 
     * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
     * 
     * Note: If there is no such window in S that covers all characters in T,
     * return the empty string "".
     * 
     * If there are multiple such windows, you are guaranteed that there will
     * always be only one unique minimum window in S.
     */

    /*
     * second round... work so hard to debug...
     * 
     * maintain a minimum window
     */
    public static String minWindow(String S, String T) {
	int left = 0;
	int total = 0;
	String result = S;

	HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
	HashMap<Character, Integer> charSeen = new HashMap<Character, Integer>();

	// initialize two maps
	for (int i = 0; i < T.length(); i++) {
	    Character c = T.charAt(i);
	    if (!charCounter.containsKey(c)) {
		charCounter.put(c, 1);
		charSeen.put(c, 0);
	    } else {
		charCounter.put(c, charCounter.get(c) + 1);
	    }
	}

	// worst case O(2n) = O(n)
	int i = 0;
	while (i < S.length()) {
	    Character c = S.charAt(i);
	    if (!charCounter.containsKey(c)) {
		i++;
		continue;
	    }

	    if (total == 0)
		left = i;

	    // record the characters seen in current window [left,i]
	    charSeen.put(c, charSeen.get(c) + 1);

	    if (charSeen.get(c) <= charCounter.get(c)) {
		total++;
	    } else {

		if (S.charAt(left) == c && left < i) {
		    // in this case need to shrink current window

		    /*
		     * detail! Always maintain the correct charSeen
		     */
		    left++;
		    charSeen.put(c, charSeen.get(c) - 1);

		    while (left < i) {
			char c2 = S.charAt(left);
			if (!charCounter.containsKey(c2)) {
			    left++;
			} else if (charSeen.get(c2) > charCounter.get(c2)) {
			    // in this case c2 is still an additional character
			    charSeen.put(c2, charSeen.get(c2) - 1);
			    left++;
			} else {
			    // shrinking ends
			    break;
			}
		    }

		}
	    }

	    if (total == T.length() && result.length() > i - left + 1) {
		result = S.substring(left, i + 1);
	    }
	    i++;
	}

	if (total < T.length()) {
	    return "";
	}
	return result;
    }

    /*
     * first round
     * 
     * My way is very close to O(n)
     */
    public static String minWindow1(String S, String T) {
	int left = 0;
	int right = 0;
	int total = 0;
	String result = S;

	// separately record the positions of every seen char of T
	HashMap<Character, ArrayList<Integer>> charPos = new HashMap<Character, ArrayList<Integer>>();
	HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();

	// record the positions of seen characters of T
	ArrayList<Integer> allPos = new ArrayList<Integer>();

	for (int i = 0; i < T.length(); i++) {
	    Character c = T.charAt(i);
	    if (!charPos.containsKey(c)) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		charPos.put(c, aList);
		charCounter.put(c, 1);
	    } else {
		charCounter.put(c, charCounter.get(c) + 1);
	    }
	}

	int i = 0;
	while (i < S.length()) {
	    Character c = S.charAt(i);
	    if (!charPos.containsKey(c)) {
		i++;
		if (total == 0)
		    left++;
		continue;
	    }

	    allPos.add(i);
	    right = i;
	    if (charPos.get(c).size() < charCounter.get(c)) {
		charPos.get(c).add(i);
		total++;
	    } else {
		// need to replace the first copy of this character
		charPos.get(c).remove(0);
		charPos.get(c).add(i);

		// move left to the second leftmost element
		left = S.length();
		// here may cause this solution not O(n)...
		for (ArrayList<Integer> aList : charPos.values()) {
		    if (!aList.isEmpty())
			left = Math.min(left, aList.get(0));
		}
	    }

	    // if a window string is found, check if it is the smallest one
	    if (total == T.length() && 1 + right - left < result.length()) {
		result = S.substring(left, right + 1);
	    }
	    i++;
	}

	if (total < T.length()) {
	    return "";
	}
	return result;
    }
}
