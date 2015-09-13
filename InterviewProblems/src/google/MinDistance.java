package google;

/**
 * Rearrange a string so that all same characters become d distance away
 * 
 * Given a string and a positive integer d. Some characters may be repeated in
 * the given string. Rearrange characters of the given string such that the same
 * characters become d distance away from each other. Note that there can be
 * many possible rearrangements, the output should be one of the possible
 * rearrangements. If no such arrangement is possible, that should also be
 * reported. Expected time complexity is O(n) where n is length of input string.
 *
 */

/*
 * Just need to return one of qualified String. No need to find all possible
 * results. So no need to use dfs.
 * 
 * http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-
 * become-at-least-d-distance-away/
 * 
 * The idea is to count frequencies of all characters and consider the most
 * frequent character first and place all occurrences of it as close as
 * possible. After the most frequent character is placed, repeat the same
 * process for remaining characters.
 * 
 * 1) Let the given string be str and size of string be n
 * 
 * 2) Traverse str, store all characters and their frequencies in a Max Heap MH.
 * The value of frequency decides the order in MH, i.e., the most frequent
 * character is at the root of MH.
 * 
 * 3) Make all characters of str as ‘\0′.
 * 
 * 4) Do following while MH is not empty. …a) Extract the Most frequent
 * character. Let the extracted character be x and its frequency be f. …b) Find
 * the first available position in str, i.e., find the first ‘\0′ in str. …c)
 * Let the first position be p. Fill x at p, p+d,.. p+(f-1)d
 */
public class MinDistance {

}
