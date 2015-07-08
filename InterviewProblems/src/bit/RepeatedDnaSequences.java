package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repeated DNA Sequences
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */

/*
 * Use a base-4 number to represent a 10-character DNA String
 * 
 * Set the bits
 */
public class RepeatedDnaSequences {
    public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
	    List<String> res = new ArrayList<>();
	    if (s == null || s.length() < 10) {
		return res;
	    }

	    Map<Character, Integer> map = new HashMap<>();
	    map.put('A', 0);
	    map.put('T', 1);
	    map.put('C', 2);
	    map.put('G', 3);

	    Map<Integer, Integer> counts = new HashMap<>();
	    int value = 0;
	    for (int i = 0; i < s.length(); i++) {
		value = value << 2; // <<2 equals to *4
		value += map.get(s.charAt(i));
		if (i >= 9) {
		    value &= ((1 << 20) - 1);
		    Integer count = counts.get(value);
		    if (count == null) {
			counts.put(value, 1);
		    } else if (count == 1) {
			res.add(s.substring(i - 9, i + 1));
			counts.put(value, count + 1);
		    }

		}
	    }

	    return res;
	}
    }
}
