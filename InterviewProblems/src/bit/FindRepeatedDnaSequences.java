package bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class FindRepeatedDnaSequences {
    /*
     * unfinished
     */
    public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
	    List<String> res = new ArrayList<String>();
	    if (s == null || s.length() < 10) {
		return res;
	    }

	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('A', 0);
	    map.put('C', 1);
	    map.put('G', 2);
	    map.put('T', 3);

	    Set<Integer> seenDNA = new HashSet<Integer>();
	    int tmp = 0;
	    for (int i = 0; i + 10 <= s.length(); i++) {
		if (i > 0) {

		}

	    }

	    return res;
	}

    }
}
