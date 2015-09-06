package string;

/**
 * Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagram {
    public class Solution {
	public boolean isAnagram(String s, String t) {
	    if (s == null && t == null) {
		return true;
	    } else if (s == null || t == null) {
		return false;
	    } else if (s.length() != t.length()) {
		return false;
	    }

	    return getKey(s).equals(getKey(t));
	}

	// counting sort
	private String getKey(String str) {
	    char[] counts = new char[26];
	    for (int i = 0; i < str.length(); i++) {
		int k = str.charAt(i) - 'a';
		counts[k]++;
	    }

	    return new String(counts);
	}
    }
}
