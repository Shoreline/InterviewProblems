package string;

import java.util.*;

/**
 * Unique Word Abbreviation
 * 
 * An abbreviation of a word follows the form <first letter><number><last
 * letter>. Below are some examples of word abbreviations:
 * 
 * a) it --> it (no abbreviation)
 * 
 * 
 * b) d|o|g --> d1g
 * 
 * 
 * c) i|nternationalizatio|n --> i18n
 * 
 * 
 * d) l|ocalizatio|n --> l10n
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation
 * is unique in the dictionary. A word's abbreviation is unique if no other word
 * from the dictionary has the same abbreviation.
 * 
 * Example: Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * 
 * isUnique("cart") -> true
 * 
 * isUnique("cane") -> false
 * 
 * isUnique("make") -> true
 */

/*
 * Condition of uniqueness: 1) the given word's abb is never seen; 2) There is
 * only one word in the dictionary has the same abb as the given word, plus the
 * word having this abb in dictionary is identical as the given word
 * 
 * 3 Cases for the map
 * 1) map does not have a key;
 * 2) map has this key but the value is null;
 * 3) map has this key and the value is not null
 */
public class UniqueWordAbbreviation {
    public class ValidWordAbbr {
	Map<String, String> map = new HashMap<>(); // abb -> word map

	public ValidWordAbbr(String[] dictionary) {
	    for (String word : dictionary) {
		String abb = getAbb(word);
		if (!map.containsKey(abb)) {
		    map.put(abb, word);
		} else {
		    map.put(abb, null);
		}
	    }
	}

	public boolean isUnique(String word) {
	    String abb = getAbb(word);
	    return !map.containsKey(abb) || (map.get(abb) != null && map.get(abb).equals(word));
	}

	private String getAbb(String word) {
	    if (word.length() <= 2) {	// corner case
		return word;
	    }
	    return word.substring(0, 1) + (word.length() - 2) + word.charAt(word.length() - 1);
	}
    }
}
