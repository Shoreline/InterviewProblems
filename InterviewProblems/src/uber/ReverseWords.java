package uber;

import java.util.*;

/**
 * Reverse tuples.
 * 
 * 只reverse word不reverse punctuation。比如 "this,,,is.a word" -> "word,,,a.is this"
 *
 */
public class ReverseWords {
    class Method {
	String reverse(String s) {
	    if (s == null) {
		return null;
	    }

	    StringBuilder res = new StringBuilder();
	    Stack<String> words = new Stack<>();

	    int start = 0;
	    for (int i = 0; i <= s.length(); i++) {

		if (i > 0 && Character.isLetterOrDigit(s.charAt(i - 1))
			&& (i == s.length() || !Character.isLetterOrDigit(s.charAt(i)))) {
		    words.push(s.substring(start, i));
		}

		if (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
		    start = i + 1;
		}
	    }

	    for (int i = 0; i <= s.length(); i++) {
		if (i > 0 && Character.isLetterOrDigit(s.charAt(i - 1))
			&& (i == s.length() || !Character.isLetterOrDigit(s.charAt(i)))) {
		    res.append(words.pop());
		}

		if (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
		    res.append(s.charAt(i));
		}
	    }

	    return res.toString();
	}
    }
}
