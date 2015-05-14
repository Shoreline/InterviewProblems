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

/*
 * Set the bits  
 */
public class FindRepeatedDnaSequences {
    public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
	    Set<String> res = new HashSet<String>();
	    if (s == null || s.length() < 10) {
		return new ArrayList<String>(res);
	    }

	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('A', 0);
	    map.put('T', 1);
	    map.put('C', 2);
	    map.put('G', 3);

	    Set<Integer> sequences = new HashSet<Integer>();
	    int num = 0;
	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (i < 10) {
		    num = (num << 2) + map.get(c);
		    if (i == 9) {
			sequences.add(num);
		    }
		} else {
		    num = num & ((1 << 18) - 1);
		    
		    //num = num << 2 + map.get(c); wrong! 
		    num = (num << 2) + map.get(c);

		    if (sequences.contains(num)) {
			res.add(s.substring(i - 9, i + 1));
		    } else {
			sequences.add(num);
		    }
		}
	    }

	    return new ArrayList<String>(res);
	}
    }
}
