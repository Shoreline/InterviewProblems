package string;

import java.util.*;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original list
 * of strings.
 * 
 * Machine 1 (sender) has the function:
 * 
 * string encode(vector<string> strs) { // ... your code return encoded_string;
 * }
 * 
 * Machine 2 (receiver) has the function: vector<string> decode(string s) {
 * //... your code return strs; }
 * 
 * So Machine 1 does:
 * 
 * string encoded_string = encode(strs); and Machine 2 does:
 * 
 * vector<string> strs2 = decode(encoded_string); strs2 in Machine 2 should be
 * the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * 
 * Note: The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters. Do not use class member/global/static variables to store
 * states. Your encode and decode algorithms should be stateless. Do not rely on
 * any library method such as eval or serialize methods. You should implement
 * your own encode/decode algorithm.
 *
 */
/*
 * String.indexOf(ch, fromIndex): Returns the index within this string of the
 * first occurrence of the specified character, starting the search at the
 * specified index.
 */
public class EncodeAndDecodeStrings {
    public class Codec {
	char delimiter = ',';

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
	    StringBuilder res = new StringBuilder();
	    for (String str : strs) {
		res.append(str.length()).append(delimiter).append(str);
	    }
	    return res.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
	    List<String> res = new ArrayList<>();
	    int pos = 0;
	    while (pos < s.length()) {
		int nextDelimiter = s.indexOf(delimiter, pos);
		int size = Integer.valueOf(s.substring(pos, nextDelimiter));
		String str = s.substring(nextDelimiter + 1, nextDelimiter + size + 1);
		res.add(str);
		pos = nextDelimiter + size + 1;
	    }

	    return res;
	}
    }
}
