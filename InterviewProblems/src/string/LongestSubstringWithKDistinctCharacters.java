package string;

/**
 * Given a string you need to print longest possible substring that has exactly
 * M unique characters. If there are more than one substring of longest possible
 * length, then print any one of them.
 * 
 * Examples:
 * 
 * "aabbcc", k = 1 Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * "aabbcc", k = 2 Max substring can be any one from {"aabb" , "bbcc"}.
 * 
 * "aabbcc", k = 3 There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } Max is "aabbcc" with length 6.
 * 
 * "aaabbb", k = 3 There are only two unique characters, thus show error
 * message.
 *
 */
/*
 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-
 * characters-in-a-given-string/
 * 
 * Method 2 (Linear Time) The problem can be solved in O(n). Idea is to maintain
 * a window and add elements to the window till it contains less or equal k,
 * update our result if required while doing so. If unique elements exceeds than
 * required in window, start removing the elements from left side.
 */
public class LongestSubstringWithKDistinctCharacters {
    /*
     * HashMap<char, Integer> map. Keep map to have no more than 3 entries
     */
}
