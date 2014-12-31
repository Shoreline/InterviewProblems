package string;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
    /**
     * Anagrams
     * 
     * Given an array of strings, return all groups of strings that are
     * anagrams.
     * 
     * Note: All inputs will be in lower-case.
     */

    /*
     * The solution below is O(n*n*lgn), not good
     * 
     * An O(n*n) method is to count the character frequency of each String
     */
    public static ArrayList<String> anagrams(String[] strs) {
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> anagramList = new ArrayList<String>();

	for (String aString : strs) {
	    char[] temp = aString.toCharArray();
	    Arrays.sort(temp);
	    String tempStr = new String(temp); // get String from char[]
	    if (!anagramList.contains(tempStr)) {
		anagramList.add(tempStr);
	    } else {
		if (!result.contains(strs[anagramList.indexOf(tempStr)])) {
		    result.add(strs[anagramList.indexOf(tempStr)]);
		}
		result.add(aString);

	    }

	}
	return result;
    }
}
