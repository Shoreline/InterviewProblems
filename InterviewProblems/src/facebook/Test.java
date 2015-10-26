package facebook;

import java.util.*;

import string.WordPatternII;

public class Test {

    public static void main(String[] args) {
	System.out.println(sort("baatt"));
    }

    private static String sort(String str) {
	    char[] res = new char[str.length()];
	    int[] count = new int[26];
	    for (int i = 0; i < str.length(); i++) {
		count[str.charAt(i) - 'a']++;
	    }

	    int ptr = 0;
	    for (int i = 0; i < count.length; i++) {
		while (count[i] > 0) {
		    res[ptr] = (char) ('a' + i);
		    ptr++;
		    count[i]--;
		}
	    }
	    return new String(res);
	}

}
