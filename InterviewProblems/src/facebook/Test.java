package facebook;

import java.util.*;

import string.WordPatternII;

public class Test {

    public static void main(String[] args) {
	System.out.println(canWin2("++++".toCharArray()));
    }

    public static boolean canWin2(char[] s) {
	for (int i = 1; i < s.length; i++) {
	    if (s[i - 1] == '+' && s[i] == '+') {
		s[i] = '-';
		s[i - 1] = '-';

		if (new String(s).equals("+--+")) {
		    System.out.println();
		}

		if (!canWin2(s)) {
		    s[i] = '+';
		    s[i - 1] = '+';
		    return true;
		}
		s[i] = '+';
		s[i - 1] = '+';
	    }
	}

	return false;
    }

}
